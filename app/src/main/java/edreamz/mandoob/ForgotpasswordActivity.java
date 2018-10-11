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

public class ForgotpasswordActivity extends AppCompatActivity {

    Button Submit;
    EditText email_id;
    MyPreferenceManager Sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initview();
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddata();
            }
        });

    }

    private void senddata() {

        String tag_json_obj = "json_obj_req";

        String url = "https://www.mandoobqatar.com/api/web/user/user/requestpasswordreset";

        final ProgressDialog pDialog = new ProgressDialog(ForgotpasswordActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("email", email_id.getText().toString().trim());


        Log.d("a", new JSONObject(postParam).toString());


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("a", response.toString());
                        pDialog.hide();
                        Intent intent = new Intent(ForgotpasswordActivity.this, Loginactivity.class);
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

        Appcontroller.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        }


    private void initview() {

        Submit = (Button) findViewById(R.id.btn_submit);
        email_id = (EditText) findViewById(R.id.etx_email);
        Sharedpref = new MyPreferenceManager(ForgotpasswordActivity.this);
    }
}
