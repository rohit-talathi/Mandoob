package edreamz.mandoob.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;

import java.util.ArrayList;

import edreamz.mandoob.R;
import edreamz.mandoob.model.Doc_upload;
import edreamz.mandoob.model.Subcategory;
import edreamz.mandoob.model.Subofsubcategory;
import edreamz.mandoob.network.MyPreferenceManager;

import static edreamz.mandoob.fragment.Homefragment.flag;

/**
 * Created by Belal on 18/09/16.
 */


public class Myrequestfragment extends Fragment {

    SliderLayout imageslider;
    GridView category_grid;
    String category_id;
    MyPreferenceManager Sharedpref;
    ArrayList<Subcategory> subcategorylist = new ArrayList<>();
    ArrayList<Doc_upload> documentlist = new ArrayList<>();
    Subcategory subcategory;
    Subofsubcategory subtosubcategory;
    Doc_upload documents;
    TextView service_name, service_description;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself_other, container, false);

        Sharedpref = new MyPreferenceManager(getActivity());
        service_name = (TextView) view.findViewById(R.id.service_name);
        service_description = (TextView) view.findViewById(R.id.service_description);

        Bundle b = getArguments();

        if (flag == 1) {
            if (null != b.getParcelable("Subcateory") && !b.getParcelable("Subcateory").equals("")) {
                subcategory = (Subcategory) b.getParcelable("Subcateory");
            }

            if (null != b.getParcelable("documents") && !b.getParcelable("documents").equals("")) {
                documents = (Doc_upload) b.getParcelable("documents");
            }
            service_name.setText(subcategory.getName());
            service_description.setText(subcategory.getDescription());

        } else {
            if (null != b.getParcelable("Subofsubcategory") && !b.getParcelable("Subofsubcategory").equals("")) {
                subtosubcategory = (Subofsubcategory) b.getParcelable("Subofsubcategory");
            }

            if (null != b.getParcelable("documents") && !b.getParcelable("documents").equals("")) {
                documents = (Doc_upload) b.getParcelable("documents");
            }
            service_name.setText(subtosubcategory.getName());
            service_description.setText(subtosubcategory.getDescription());
        }

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Service");
    }


}
