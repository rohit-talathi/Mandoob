package edreamz.mandoob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edreamz.mandoob.network.MyPreferenceManager;

public class LanguageActivity extends AppCompatActivity {

    private Button btn_arebic, btn_english;
    MyPreferenceManager Sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        Initview();

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Sharedpref.getBooleanPreferences(MyPreferenceManager.show_message_flag)) {
                    Sharedpref.setStringPreferences(MyPreferenceManager.language, "en");
                    Intent i = new Intent(LanguageActivity.this, Loginactivity.class);
                    startActivity(i);

                } else {
                    Sharedpref.setStringPreferences(MyPreferenceManager.language, "en");
                    Intent i = new Intent(LanguageActivity.this, SliderActivity.class);
                    startActivity(i);
                }

            }
        });

        btn_arebic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Sharedpref.getBooleanPreferences(MyPreferenceManager.show_message_flag)) {
                    Sharedpref.setStringPreferences(MyPreferenceManager.language, "ar");
                    Intent i = new Intent(LanguageActivity.this, Loginactivity.class);
                    startActivity(i);
                } else {
                    Sharedpref.setStringPreferences(MyPreferenceManager.language, "ar");
                    Intent i = new Intent(LanguageActivity.this, SliderActivity.class);
                    startActivity(i);
                }
            }
        });


    }

    private void Initview() {
        btn_english = (Button) findViewById(R.id.btn_english);
        btn_arebic = (Button) findViewById(R.id.btn_arebic);
        Sharedpref = new MyPreferenceManager(LanguageActivity.this);
    }

}
