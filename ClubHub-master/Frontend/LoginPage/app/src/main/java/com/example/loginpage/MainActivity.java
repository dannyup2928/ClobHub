package com.example.loginpage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginpage.app.AppController;
import com.example.loginpage.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText LoginID;
    private EditText Password;
    private Button Login;


    private static String TAG = MainActivity.class.getSimpleName();

    private RequestQueue mQueue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = (Button) findViewById(R.id.btnLogin);
        LoginID = (EditText)findViewById(R.id.loginText);
        Password = (EditText) findViewById(R.id.passText);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }

    private void login() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", LoginID.getText().toString());
        params.put("password", Password.getText().toString());
        String url = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
//        JSONObject jsonBody = new JSONObject();
//        jsonBody.put("name", "name");
//        jsonBody.put("password", "pass");
//        final String requestBody = jsonBody.toString();
//        StringRequest jsonObjReq = new StringRequest(Request.Method.POST,
//                Const.POSTMAN_URL + "/login",
//                new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//                        Toast toast = Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT);
//                        toast.show();
//                        Log.d(TAG, response.toString());
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.getCause();
//                VolleyLog.d(TAG, "Error: " + error.getCause());
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                error.printStackTrace();
//            }
//        }) {
//
//            /**
//             * Passing some request headers
//             * */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("Content-Type", "application/json");
//                return headers;
//            }
//
//            @Override
//            public byte[] getBody() throws AuthFailureError {
//                try{
//
//                    return requestBody == null ? null : requestBody.getBytes("utf-8");
//                } catch (UnsupportedEncodingException e) {
//                    return null;
//                }
//
////                Map<String, String> params = new HashMap<String, String>();
//
////                params.put("name", "Androidhive");
////                params.put("pass", "password123");
////
////                return params;
//            }
//
//        };
//        mQueue.add(jsonObjReq);

//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq,"");

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);




}
