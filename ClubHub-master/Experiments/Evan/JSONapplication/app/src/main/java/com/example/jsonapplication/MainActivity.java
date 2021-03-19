package com.example.jsonapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //From tutorial
    private Context mContext;
    private Activity mActivity;

    private CoordinatorLayout mCLayout;
    private Button mButtonDo;
    private TextView mTextView;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    private String postmanTest = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        // Get the widget reference from XML layout
        //mButtonDo = (Button) findViewById(R.id.JSONget);
        mTextView = (TextView) findViewById(R.id.showResponse);

        //Button to get from JSON
        Button mButton = (Button) findViewById(R.id.JSONget);
        mButton.setOnClickListener(this);

        //Button to change text
        Button nButton = (Button) findViewById(R.id.Login);
        nButton.setOnClickListener(this);

        //Button to go to the registration page
        Button oButton = (Button) findViewById(R.id.register);
        oButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.JSONget:

                //Empty text view
                mTextView.setText("");

                //Initialize a new RequestQueue instance
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mJSONURLString, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Do something with response
                                try {
                                // Get JSON object
                                JSONArray array = response.getJSONArray("student");

                                //Change upper bound of for loop to array.length() to print all values
                                for (int i = 0; i < 1; i++) {
                                    // Get current json object
                                    JSONObject student = array.getJSONObject(i);

                                    // Get the current student (json object) data
                                    String name = student.getString("name");
                                    String netid = student.getString("netid");
                                    String password = student.getString("password");

                                    // Display the formatted json data in text view
                                    mTextView.append("Name: " + name + "\n" + "netid: " + netid + "\n" + "Password : " + password);
                                    mTextView.append("\n\n");
                                }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    mTextView.append("failed");
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                );
                // Add JsonObjectRequest to the RequestQueue
                requestQueue.add(jsonObjectRequest);

                break;

            case R.id.Login:
                //mTextView.setText("Text Changed");
                startActivity(new Intent(MainActivity.this, Login.class));
                break;

            case R.id.register:
                startActivity(new Intent(MainActivity.this, Registration.class));
                break;

        }

    }

}

