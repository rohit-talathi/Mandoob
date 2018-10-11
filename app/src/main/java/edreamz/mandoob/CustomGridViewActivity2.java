package edreamz.mandoob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edreamz.mandoob.model.Subcategory;

public class CustomGridViewActivity2 extends BaseAdapter {

    private Context mContext;
   private ArrayList<Subcategory> subcategorylist=new ArrayList<>();

    public CustomGridViewActivity2(Context context, ArrayList<Subcategory> categorylist) {
        mContext = context;
        this.subcategorylist = categorylist;

    }

    @Override
    public int getCount() {
        return subcategorylist.size();
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
            gridViewAndroid = inflater.inflate(R.layout.gridview_layout, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.android_gridview_text);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.android_gridview_image);
            textViewAndroid.setText(subcategorylist.get(i).getName());
            Picasso.with(mContext).load(subcategorylist.get(i).getImage()).into(imageViewAndroid);

        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }
}
