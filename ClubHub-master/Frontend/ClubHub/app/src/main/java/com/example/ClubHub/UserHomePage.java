package com.example.ClubHub;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
 * Home page of the user that displays all of the clubs they are a memeber of
 */
public class UserHomePage extends Activity {

    /**
     * Performs a JSON get request to retrieve all of the clubs the user is a member of and display
     * them in a listview
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        final ArrayList<String> clubNames = new ArrayList<String>();
        final ListView listView = (ListView) findViewById(R.id.myList);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clubNames);

        final ArrayList<String> memberClubIDArray = new ArrayList<String>();
        final ArrayList<String> clubDomain = new ArrayList<>();
        final ArrayList<String> clubStatus = new ArrayList<>();
        final ArrayList<String> clubIDs = new ArrayList<>();

        final String userIDNumber = getIntent().getStringExtra("IDNumber");

        RequestQueue queue = Volley.newRequestQueue(this);
        //Maybe to change
        String enrollmentURL = "http://cs309-pp-4.misc.iastate.edu:8080/clubenrollment";
        String tableURL = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";

        JsonObjectRequest JSONRequest = new JsonObjectRequest(Request.Method.GET, enrollmentURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    //Maybe to change
                    JSONArray array = response.getJSONArray("enrollments");
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject clubEnrollment = array.getJSONObject(i);
                        String clubID = clubEnrollment.getString("clubID");
                        String studentID = clubEnrollment.getString("studentID");

                        if(studentID.equals(userIDNumber)){
                            memberClubIDArray.add(clubID);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(JSONRequest);

        JsonObjectRequest JSONRequestTwo = new JsonObjectRequest(Request.Method.GET, tableURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray array = response.getJSONArray("clubs");
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        String clubID = object.getString("clubID");
                        String clubs = object.getString("clubName");
                        String domains = object.getString("clubDomain");
                        String status = object.getString("clubStatus");

                        if(memberClubIDArray.contains(clubID)) {
                            clubIDs.add(clubID);
                            clubNames.add(clubs);
                            clubDomain.add(domains);
                            clubStatus.add(status);
                        }

                    }

                    listView.setAdapter(arrayAdapter);
                    // Once we added the string to the array, we notify the arrayAdapter
                    arrayAdapter.notifyDataSetChanged();

                    // ListView Item Click Listener
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {


                            // ListView Clicked item index
                            int itemPosition     = position;

                            // ListView Clicked item value
                            String  itemValue    = (String) listView.getItemAtPosition(position);

                            Intent intent = new Intent(UserHomePage.this, ClubHomePage.class);
                            intent.putExtra("clubID", clubIDs.get(position));
                            intent.putExtra("clubDomain", clubDomain.get(position));
                            intent.putExtra("clubStatus", clubStatus.get(position));
                            intent.putExtra("clubName", clubNames.get(position));
                            startActivity(intent);

                        }

                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(JSONRequestTwo);
    }



}


