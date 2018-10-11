package edreamz.mandoob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import edreamz.mandoob.network.Appcontroller;
import edreamz.mandoob.network.MyPreferenceManager;

public class SignupActivity extends AppCompatActivity {

    EditText first_name, last_name, email, contact_mobile_no, password, confirm_password;
    CheckBox terms_condition, subscribe_newsletter;
    MyPreferenceManager Sharedpref;
    Button btn_create;
    String terms_value, newsletter_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Initview();

        terms_condition.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    terms_value = "1";
                } else {
                    terms_value = "0";
                }

            }
        });

        subscribe_newsletter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    newsletter_value = "1";
                    } else {
                    newsletter_value = "0";
                }
            }
        });

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signup(newsletter_value,terms_value);

            }
        });


    }

    private void Initview() {

        first_name = (EditText) findViewById(R.id.etx_first_name);
        last_name = (EditText) findViewById(R.id.etx_last_name);
        email = (EditText) findViewById(R.id.etx_email);
        contact_mobile_no = (EditText) findViewById(R.id.etx_contact_no);
        password = (EditText) findViewById(R.id.etx_password);
        confirm_password = (EditText) findViewById(R.id.etx_confirm_password);
        terms_condition = (CheckBox) findViewById(R.id.cb_terms_condition);
        subscribe_newsletter = (CheckBox) findViewById(R.id.cb_subscribe_newsletter);
        Sharedpref = new MyPreferenceManager(SignupActivity.this);
        btn_create = (Button) findViewById(R.id.btn_create);
    }

    private void signup(String newsletter_value, String terms_value) {

        String tag_json_obj = "json_obj_req";

//                {"message":"Secured","status":200,"success":true,"data":{"key":"gXuAL7vP%c%hkP58k#UU","pin":"WQK5aQ5p%wmF#N4rX^gW"}}

//                String url = "http://mandoobqatar.com/api/web/security/security/getsecuritycode";
        String url = "https://www.mandoobqatar.com/api/web/user/user/signup";

        final ProgressDialog pDialog = new ProgressDialog(SignupActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("first_name", first_name.getText().toString().trim());
        postParam.put("last_name", last_name.getText().toString().trim());
        postParam.put("email", email.getText().toString().trim());
        postParam.put("country_code", "+974-");
        postParam.put("contact_number", contact_mobile_no.getText().toString().trim());
        postParam.put("password_hash", password.getText().toString().trim());
        postParam.put("password_repeat", confirm_password.getText().toString().trim());
        postParam.put("terms", terms_value);
        postParam.put("newsletter", newsletter_value);

        Log.d("a", new JSONObject(postParam).toString());


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("a", response.toString());
                        pDialog.hide();
                        Intent intent = new Intent(SignupActivity.this, OtpActivity.class);
                        startActivity(intent);
                        finish();
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

// Adding request to request queue
        Appcontroller.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);


    }

}
