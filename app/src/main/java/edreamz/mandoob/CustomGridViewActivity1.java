package edreamz.mandoob;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGridViewActivity1 extends BaseAdapter {

    private Context mContext;
    private ArrayList gridViewString;



    public CustomGridViewActivity1(FragmentActivity activity, ArrayList<String> time_list) {
        mContext = activity;
        this.gridViewString = time_list;
    }

    @Override
    public int getCount() {
        return gridViewString.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.time_gridview_layout, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.android_gridview_text);
            textViewAndroid.setText(gridViewString.get(i).toString());

        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }
}
