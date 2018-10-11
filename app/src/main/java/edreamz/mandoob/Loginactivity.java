package edreamz.mandoob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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

public class Loginactivity extends AppCompatActivity {

    ImageButton btn_corp_request, btn_sign_up;
    Button btn_sign_in;
    EditText etx_forgot_password, etx_password, etx_email;
    MyPreferenceManager Sharedpref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Initview();

        etx_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginactivity.this, ForgotpasswordActivity.class);
                startActivity(intent);
            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginactivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btn_corp_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginactivity.this, CorporateRequestActivity.class);
                startActivity(intent);
            }
        });

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etx_email.getText().toString().trim();
                String password = etx_password.getText().toString().trim();
                login(email, password);
            }
        });




        }

    private void login(String email, String password) {

        String tag_json_obj = "json_obj_req";

//                {"message":"Secured","status":200,"success":true,"data":{"key":"gXuAL7vP%c%hkP58k#UU","pin":"WQK5aQ5p%wmF#N4rX^gW"}}

//                String url = "http://mandoobqatar.com/api/web/security/security/getsecuritycode";
        String url = "https://www.mandoobqatar.com/api/web/user/user/login";

        final ProgressDialog pDialog = new ProgressDialog(Loginactivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("email", email);
        postParam.put("password", password);
        postParam.put("device_type", "iOS");
        postParam.put("device_token", "512512");
        Log.d("a",new JSONObject(postParam).toString());


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("a", response.toString());
                        pDialog.hide();
                        Intent intent =new Intent(Loginactivity.this,MainActivity.class);
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

        {  @Override
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

    private void Initview() {
        btn_corp_request = (ImageButton) findViewById(R.id.btn_corp_request);
        btn_sign_up = (ImageButton) findViewById(R.id.btn_sign_up);
        btn_sign_in = (Button) findViewById(R.id.btn_sign_in);
        etx_forgot_password = (EditText) findViewById(R.id.etx_forgot_password);
        etx_password = (EditText) findViewById(R.id.etx_password);
        etx_email = (EditText) findViewById(R.id.etx_email);
        Sharedpref=new MyPreferenceManager(Loginactivity.this);

    }
}

