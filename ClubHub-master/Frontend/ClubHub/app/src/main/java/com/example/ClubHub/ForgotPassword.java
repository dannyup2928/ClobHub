package com.example.ClubHub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Allows the user to change their password given their userid exists in the database
 */
public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    /**
     * String that references the server
     */
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    //Test comment for development purposes


    /**
     * Sets the page and onClickListener
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //Button to go to register
        Button oButton = (Button) findViewById(R.id.submitChange);
        oButton.setOnClickListener(this);

    }

    /**
     * Performs a JSON get to retrieve the userid of the user
     * @param v
     */
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.submitChange:
                RequestQueue queue = Volley.newRequestQueue(this);  // this = context

                EditText IDEdit = (EditText)findViewById(R.id.username);
                final String IDInput = IDEdit.getText().toString();

                EditText passwordEdit = (EditText)findViewById(R.id.newPassword);
                final String passwordInput = passwordEdit.getText().toString();

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mJSONURLString, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                String currentID = "";
                                String currentNetID = "";
                                String currentfirstName = "";
                                String currentlastName = "";
                                String currentClassification = "";
                                String currentPhoneNumber = "";
                                String currentMajor = "";

                                int idExists = 0;
                                // Do something with response
                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("student");

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {
                                        // Get current json object
                                        JSONObject currentStudent = array.getJSONObject(i);

                                        // Get the current student (json object) data
                                        String id = currentStudent.getString("studentID");
                                        String netID = currentStudent.getString("netID");
                                        String firstName = currentStudent.getString("firstName");
                                        String lastName = currentStudent.getString("lastName");
                                        String classification = currentStudent.getString("classification");
                                        String phoneNumber = currentStudent.getString("phoneNumber");
                                        String major = currentStudent.getString("major");
                                        String password = currentStudent.getString("password");

                                        if(netID.equals(IDInput)){
                                            //Toast.makeText(getApplicationContext(), "NetID Already Registered", Toast.LENGTH_LONG).show();
                                            idExists = 1;
                                            currentID = id;
                                            currentNetID = netID;
                                            currentfirstName = firstName;
                                            currentlastName = lastName;
                                            currentClassification = classification;
                                            currentPhoneNumber = phoneNumber;
                                            currentMajor = major;
                                        }
                                    }
                                    if(idExists == 1) {
                                        //Log.d("Got here", "This is my message");
                                        postData(currentID, currentNetID, currentfirstName, currentlastName, currentClassification, currentPhoneNumber, currentMajor);
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "NetID does not exist", Toast.LENGTH_LONG).show();
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
                // Add JsonObjectRequest to the RequestQueue
                queue.add(jsonObjectRequest);

                break;
        }
    }

    /**
     * Performs a JSON post to change the password of the user while keeping the rest of their data the same
     * @param id
     * userId of the user
     * @param netID
     * netID of the user
     * @param firstName
     * First name of the user
     * @param lastName
     * Last name of the user
     * @param classification
     * Classification of the user
     * @param phoneNumber
     * Phone Number of the user
     * @param major
     * Major of the user
     */
    public void postData(String id, String netID, String firstName, String lastName, String classification, String phoneNumber, String major){
        RequestQueue queue = Volley.newRequestQueue(this);

        EditText IDEdit = (EditText)findViewById(R.id.username);
        final String IDInput = IDEdit.getText().toString();

        EditText passwordEdit = (EditText)findViewById(R.id.newPassword);
        final String passwordInput = passwordEdit.getText().toString();

        Map<String, String> params = new HashMap();
        params.put("studentID", id);
        params.put("netID", netID);
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("classification", classification);
        params.put("phoneNumber", phoneNumber);
        params.put("major", major);
        params.put("password", passwordInput);

        JSONObject parameters = new JSONObject(params);

        String url = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
        //String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
        JsonObjectRequest postRequestForgotPassword = new JsonObjectRequest(Request.Method.POST, url, parameters,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        Log.d("Response", response.toString());
                        Toast.makeText(getApplicationContext(), "Password Successfully Changed", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ForgotPassword.this, Login.class));
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                        Toast.makeText(getApplicationContext(), "Password Successfully Changed", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ForgotPassword.this, Login.class));
                    }
                }
        );
        queue.add(postRequestForgotPassword);
    }

}

