package edreamz.mandoob.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import edreamz.mandoob.CustomGridViewActivity1;
import edreamz.mandoob.R;

/**
 * Created by Belal on 18/09/16.
 */


public class Time_allocationfragment extends Fragment {

    TextView time_allocation;
    GridView time_grid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_allocation, container, false);

        time_grid=(GridView)view.findViewById(R.id.grid_cust_time_allocation);
        time_allocation=(TextView)view.findViewById(R.id.time_allocation) ;

        final ArrayList<String>time_list= new ArrayList<>();
        time_list.add("09-10");
        time_list.add("10-11");
        time_list.add("11-12");
        time_list.add("1-2");
        time_list.add("09-10");
        time_list.add("10-11");
        time_list.add("11-12");
        time_list.add("1-2");

        CustomGridViewActivity1 adapterViewAndroid = new CustomGridViewActivity1(getActivity(), time_list);
        time_grid.setAdapter(adapterViewAndroid);
        time_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
               time_allocation.setText(time_list.get(i).toString());
            }
        });


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Time Allocation");
    }
}
