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
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edreamz.mandoob.CustomGridViewActivity2;
import edreamz.mandoob.R;
import edreamz.mandoob.model.Doc_upload;
import edreamz.mandoob.model.Subcategory;
import edreamz.mandoob.network.Appcontroller;
import edreamz.mandoob.network.MyPreferenceManager;

/**
 * Created by Belal on 18/09/16.
 */


public class SubCategoryfragment extends Fragment implements BaseSliderView.OnSliderClickListener {

    SliderLayout imageslider;
    GridView category_grid;
    String category_id;
    MyPreferenceManager Sharedpref;
    ArrayList<Subcategory> subcategorylist = new ArrayList<>();
    ArrayList<Doc_upload> documentlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);
        category_grid = (GridView) view.findViewById(R.id.category_grid);
        Sharedpref = new MyPreferenceManager(getActivity());

        Bundle b = getArguments();
        if (null != b.getString("category_id") && !b.getString("category_id").equalsIgnoreCase("")) {
            category_id = b.getString("category_id");
        }

        setdata(category_id);


//
//
//        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getActivity(), gridViewString, gridViewImageId);
//        category_grid.setAdapter(adapterViewAndroid);
//        category_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int i, long id) {
//                Fragment fragment = null;
//                fragment = new SubtoSubCategoryfragment();
//                if (fragment != null) {
//                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.content_frame, fragment);
//                    ft.commit();
//                }
//            }
//        });


        return view;
    }

    private void setdata(final String category_id) {
        String tag_json_obj = "json_obj_req";

        String url = "https://www.mandoobqatar.com/api/web/request/request/getsubcategories";

        final ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();

        Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("category_id", category_id);

        Log.d("a", new JSONObject(postParam).toString());


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("a", response.toString());

                        JSONArray jsonArray1 = null;
                        try {
                            jsonArray1 = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject object3 = jsonArray1.getJSONObject(i);
                                Subcategory subcategory = new Subcategory();
                                subcategory.setId(object3.getString("id"));
                                subcategory.setCategory_id(object3.getString("category_id"));
                                subcategory.setName(object3.getString("name"));
                                subcategory.setDescription(object3.getString("description"));
                                subcategory.setImage(object3.getString("image"));
                                subcategory.setIs_subofsubcategory(object3.getInt("is_subofsubcategory"));
                                if (object3.getInt("is_subofsubcategory") == 0) {
                                    JSONObject info = object3.getJSONObject("info");
                                    subcategory.setCategory(info.getString("Category"));
                                    subcategory.setApplication_fee(info.getString("application_fee"));
                                    subcategory.setService_fee(info.getString("service_fee"));
                                    subcategory.setDuration(info.getString("duration"));
                                    subcategory.setDocument_count(info.getString("document_count"));
                                    JSONArray doc_upload = info.getJSONArray("doc_upload");
                                    for (int j = 0; j < doc_upload.length(); j++) {
                                        JSONObject document = jsonArray1.getJSONObject(i);
                                        Doc_upload docUpload = new Doc_upload();
                                        docUpload.setId(document.getString("id"));
                                        documentlist.add(docUpload);
                                    }
                                    subcategory.setDocumentlist(documentlist);
                                    subcategorylist.add(subcategory);
                                } else {
                                    subcategory.setInfo(object3.getString("info"));
                                    subcategorylist.add(subcategory);
                                }
                            }
                            pDialog.dismiss();
                            CustomGridViewActivity2 adapterViewAndroid = new CustomGridViewActivity2(getActivity(), subcategorylist);
                            category_grid.setAdapter(adapterViewAndroid);
                            ;
                            category_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,
                                                        int i, long id) {
                                    if (subcategorylist.get(i).getIs_subofsubcategory() > 0) {
                                        Fragment fragment = null;
                                        fragment = new SubtoSubCategoryfragment();
                                        Log.d("a",subcategorylist.toString());
                                        Bundle b = new Bundle();
                                        b.putString("category_id", category_id);
                                        b.putString("subcategory_id", subcategorylist.get(i).getId());
                                        fragment.setArguments(b);
                                        if (fragment != null) {
                                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                            ft.replace(R.id.content_frame, fragment);
                                            ft.commit();
                                        }
                                    } else {
                                        Log.d("a",subcategorylist.toString());
                                        Fragment fragment = null;
                                        fragment = new Myrequestfragment();
                                        Log.d("a",subcategorylist.toString());
                                        Subcategory subcategory=subcategorylist.get(i);
                                        Doc_upload doc_upload=documentlist.get(i);
                                        Bundle b = new Bundle();
                                        b.putParcelable("Subcateory", subcategory);
                                        b.putParcelable("documents", doc_upload);
                                        fragment.setArguments(b);
                                        if (fragment != null) {
                                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                            ft.replace(R.id.content_frame, fragment);
                                            ft.commit();
                                        }
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

        {
            @Override
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


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Service");
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
