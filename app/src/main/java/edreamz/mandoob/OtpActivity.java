package edreamz.mandoob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class OtpActivity extends AppCompatActivity {

    EditText etx_otp;
    Button btn_submit;
    MyPreferenceManager Sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        initview();

          btn_submit.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  otpverify(etx_otp.getText().toString().trim());
              }
          });

    }

    private void initview() {
        etx_otp=(EditText)findViewById(R.id.etx_otp);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        Sharedpref=new MyPreferenceManager(OtpActivity.this);
    }


    private void otpverify(String otpvalue) {

        String tag_json_obj = "json_obj_req";

//                {"message":"Secured","status":200,"success":true,"data":{"key":"gXuAL7vP%c%hkP58k#UU","pin":"WQK5aQ5p%wmF#N4rX^gW"}}

//                String url = "http://mandoobqatar.com/api/web/security/security/getsecuritycode";
        String url = "https://www.mandoobqatar.com/api/web/user/user/otpverification";

        final ProgressDialog pDialog = new ProgressDialog(OtpActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("email", "Durocretepune@gmail.com");
        postParam.put("otp", otpvalue);

        Log.d("a", new JSONObject(postParam).toString());


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("a", response.toString());
                        pDialog.hide();
                        Intent intent = new Intent(OtpActivity.this, Loginactivity.class);
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
