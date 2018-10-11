package edreamz.mandoob.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edreamz.mandoob.CustomGridViewActivity;
import edreamz.mandoob.R;
import edreamz.mandoob.model.Category;
import edreamz.mandoob.network.Appcontroller;
import edreamz.mandoob.network.MyPreferenceManager;

/**
 * Created by Belal on 18/09/16.
 */


public class Homefragment extends Fragment implements BaseSliderView.OnSliderClickListener {

SliderLayout imageslider;
    GridView category_grid;
    MyPreferenceManager Sharedpref;
    ArrayList<String>imagelist=new ArrayList<>();
    ArrayList<Category>categorylist=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageslider=(SliderLayout)view.findViewById(R.id.image_slider);
        category_grid=(GridView)view.findViewById(R.id.category_grid);
        Sharedpref=new MyPreferenceManager(getActivity());

        getdata();








        return view;
    }

    private void getdata() {

        String tag_json_obj = "json_obj_req";

//                {"message":"Secured","status":200,"success":true,"data":{"key":"gXuAL7vP%c%hkP58k#UU","pin":"WQK5aQ5p%wmF#N4rX^gW"}}

//                String url = "http://mandoobqatar.com/api/web/security/security/getsecuritycode";
        String url = "https://www.mandoobqatar.com/api/web/request/request/getcategory";

        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("a", response.toString());

                        HashMap<String,String> url_maps = new HashMap<String, String>();
                        try {
                            JSONArray jsonArray= response.getJSONArray("banner");
                            for(int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject object3 = jsonArray.getJSONObject(i);
                                String image = object3.getString("image");
                                url_maps.put(""+i,image);
                            }

                            setdata(url_maps);


                            JSONArray jsonArray1= response.getJSONArray("data");
                            for(int i = 0; i < jsonArray1.length(); i++)
                            {
                                JSONObject object3 = jsonArray1.getJSONObject(i);
                                Category  category= new Category();
                                category.setId(object3.getString("id"));
                                category.setName(object3.getString("name"));
                                category.setDescription(object3.getString("description"));
                                category.setImage(object3.getString("image"));
                                category.setIs_subcategory(object3.getInt("is_subcategory"));
                                category.setInfo(object3.getString("info"));
                                categorylist.add(category);
                            }



                            pDialog.dismiss();
                            CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getActivity(), categorylist);
                            category_grid.setAdapter(adapterViewAndroid);
                           ;
                            category_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,
                                                        int i, long id) {
                                    if (categorylist.get(i).getIs_subcategory() > 0) {
                                        Fragment fragment = null;
                                        fragment = new SubCategoryfragment();
                                        Bundle b=new Bundle();
                                        b.putString("category_id",categorylist.get(i).getId());
                                        fragment.setArguments(b);
                                        if (fragment != null) {
                                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                            ft.replace(R.id.content_frame, fragment);
                                            ft.commit();
                                        }
                                    }else
                                    {

                                    }
                                }
                            });




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("a", "Error: " + error.getMessage());
                pDialog.hide();
            }
        })

        {  @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("key", "gXuAL7vP%c%hkP58k#UU");
            headers.put("pin", "WQK5aQ5p%wmF#N4rX^gW");
            headers.put("language", Sharedpref.getStringPreferences(MyPreferenceManager.language));
            return headers;
        }

        };

        Appcontroller.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        }

    private void setdata(HashMap<String, String> file_maps) {

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            imageslider.addSlider(textSliderView);
        }
        imageslider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        imageslider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imageslider.setCustomAnimation(new DescriptionAnimation());
        imageslider.setDuration(8000);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
