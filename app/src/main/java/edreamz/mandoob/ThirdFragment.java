package edreamz.mandoob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import edreamz.mandoob.network.MyPreferenceManager;

public class ThirdFragment extends Fragment {

    MyPreferenceManager Sharedpef;
    CheckBox cb_show_message;
    Button btn_get_started;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_frag, container, false);

        Initview(view);

        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Loginactivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        cb_show_message.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if (ischecked) {
                    Sharedpef.setBooleanPreferences(MyPreferenceManager.show_message_flag, true);
                } else {
                    Sharedpef.setBooleanPreferences(MyPreferenceManager.show_message_flag, false);
                }
            }
        });

        return view;
    }

    private void Initview(View view) {
        btn_get_started = (Button) view.findViewById(R.id.btn_get_started);
        cb_show_message = (CheckBox) view.findViewById(R.id.cb_show_message);
        Sharedpef = new MyPreferenceManager(getActivity());
    }
}