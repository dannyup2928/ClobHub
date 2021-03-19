package com.example.ClubHub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.ArrayList;

/**
 * Login page that the user enters their credentials in assuming they exist in the database
 */
public class Login extends AppCompatActivity implements View.OnClickListener{

    /**
     * String that references the server
     */
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    /**
     * See if the user exists in the database
     */
    private boolean exists = false;

    /**
     * Sets the onClickListeners for each of the buttons on the Login page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Login Button
        Button oButton = (Button) findViewById(R.id.btnLogin);
        oButton.setOnClickListener(this);

        // Forgot Password Button
        Button pButton = (Button) findViewById(R.id.forgotPasswordButton);
        pButton.setOnClickListener(this);

    }

    /**
     * Function that performs a JSON get from the datbase and checks to see if the credentials being
     * entered matches or if the user does not exist.
     * @param v
     */
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnLogin:
                RequestQueue queue = Volley.newRequestQueue(this);  // this = context

                EditText netIDEdit = (EditText)findViewById(R.id.loginText);
                final String netIDInput = netIDEdit.getText().toString();

                EditText passEdit = (EditText)findViewById(R.id.passText);
                final String passInput = passEdit.getText().toString();


                //Initialize a new RequestQueue instance
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                // New JSON GET Request
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mJSONURLString, null,
                         new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Do something with response
                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("student"); // From usersid table

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {

                                        // Get current json object
                                        JSONObject user = array.getJSONObject(i);

                                        // Get the current student (json object) data
                                        String netid = user.getString("netID");
                                        String password = user.getString("password");
                                        String studentID = user.getString("studentID");

                                        // If netID and password match have intent go to LoginSuccess with custom message
                                        if(netid.equals(netIDInput) && password.equals(passInput)){
                                            Bundle extra = new Bundle();
                                            String userID = netIDInput;

                                            String userIDNumber = studentID;
                                            extra.putSerializable("user", userID);
                                            extra.putSerializable("IDNumber", userIDNumber);

                                            Log.d("Got here", "yes");

                                            Intent j = new Intent(getApplicationContext(), LoginSuccess.class);
                                            j.putExtra("extra", extra);
                                            startActivity(j);
                                            finish();
                                            exists = true;
                                        }

                                    }

                                    // Toast if credentials are not in the server
                                    if (!exists) {
                                        Toast.makeText(getApplicationContext(), "Incorrect Credentials", Toast.LENGTH_LONG).show();

                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();

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

                requestQueue.add(jsonObjectRequest);
                break;

            // Intent takes user to the ForgotPassword page if clicked
            case R.id.forgotPasswordButton:
                startActivity(new Intent(Login.this, ForgotPassword.class));
                break;
        }

    }

    /**
     * Function that returns the login credentials of the user
     * @param user
     * User's userid
     * @param pass
     * User's password
     * @return
     * Credentials as an arrayList
     */
    public ArrayList<String> loginCredentials(String user, String pass){

        ArrayList<String> loginStuff = new ArrayList<String>();

        loginStuff.add(user);
        loginStuff.add(pass);

        return loginStuff;

    }
}
