package edreamz.mandoob.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;

import java.util.ArrayList;

import edreamz.mandoob.R;
import edreamz.mandoob.model.Doc_upload;
import edreamz.mandoob.model.Subcategory;
import edreamz.mandoob.network.MyPreferenceManager;

/**
 * Created by Belal on 18/09/16.
 */


public class Myrequestfragment extends Fragment implements BaseSliderView.OnSliderClickListener {

    SliderLayout imageslider;
    GridView category_grid;
    String category_id;
    MyPreferenceManager Sharedpref;
    ArrayList<Subcategory> subcategorylist = new ArrayList<>();
    ArrayList<Doc_upload> documentlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself_other, container, false);

        Sharedpref = new MyPreferenceManager(getActivity());

        Bundle b = getArguments();
        if (null != b.getString("category_id") && !b.getString("category_id").equalsIgnoreCase("")) {
            category_id = b.getString("category_id");
        }


        return view;
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
