package com.example.ClubHub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

/**
 *
 */
public class ClubHomePage extends AppCompatActivity {

    /**
     * Variable to see if the user is already in the club
     */
    private boolean exists = false;

    /**
     * The name of the given club
     */
    private String clubName;

    /**
     * The domain name for the clubs website
     */
    private String domainName;

    /**
     * The status, denoting whether the club is active or not
     */
    private String clubStatus;

    /**
     * The club id passed in from the previous page
     */
    private String clubIDpassedIn;

    /**
     * The user id passed in from the page before
     */
    private String userIDpassedIn;

    /**
     * The url for the json gets and json posts for the club table
     */
    private String cJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";

    /**
     * The url for the json gets and json posts for the club enrollment table
     */
    private String eJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubenrollment";

    /**
     * The url for the json gets and json posts for the club enrollment table
     */
    private String fJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubimage";

    /**
     * The string to hold the main club id being used
     */
    private String mainClubId = "";

    /**
     * The string to hold the url of the given club picture
     */
    private String pictureURL = "https://bloximages.chicago2.vip.townnews.com/iowastatedaily.com/content/tncms/assets/v3/editorial/f/b3/fb3cbf90-8c20-11e7-bab3-9bc829bc7696/59a464a6003b6.image.png?resize=328%2C328";

    /**
     * The club home page is the main hub for each club
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_home_page);

        clubName = getIntent().getStringExtra("clubName");
        domainName = getIntent().getStringExtra("clubDomain");
        clubStatus = getIntent().getStringExtra("clubStatus");
        clubIDpassedIn = getIntent().getStringExtra("clubID");
        userIDpassedIn = getIntent().getStringExtra("IDNumber");


        Button mButton = (Button)findViewById(R.id.mapsLocation);
        Button jButton = (Button)findViewById(R.id.joinButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapLocation = new Intent(ClubHomePage.this,MapsActivity.class);
                mapLocation.putExtra("clubName", clubName);
                startActivity(mapLocation);
            }
        });

//        IMPLEMENT THIS PROPERLY
        jButton.setOnClickListener(new View.OnClickListener() {
            /**
             * The onclick method handles button clicks to redirect the user to new pages
             * @param v
             */
            @Override
            public void onClick(View v) {

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                // New JSON GET Request
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, cJSONURLString, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Do something with response

                                String clubID = "";
                                String clubName = "";
                                String clubDomain = "";
                                String clubStatus = "";
                                ArrayList<String> memList = new ArrayList<>();
                                String [] clubTags = {};

                                int idFound = 0;

                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("clubs"); // From club table

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {

                                        // Get current json object
                                        JSONObject club = array.getJSONObject(i);

                                        String id = club.getString("clubID");
                                        String name = club.getString("clubName");
                                        String domain = club.getString("clubDomain");
                                        String status = club.getString("clubStatus");

                                        JSONArray memArr = club.getJSONArray("clubMembers");
                                        String [] members = new String[memArr.length()];
                                        for(int k = 0; k < memArr.length(); k++){
                                            members[k] = memArr.getString(k);
                                        }


                                        JSONArray tagArr = club.getJSONArray("clubTags");
                                        String [] tags = new String[tagArr.length()];
                                        for(int p = 0; p < tagArr.length(); p++){
                                            tags[p] = tagArr.getString(p);
                                        }
                                        //Toast.makeText(getApplicationContext(), "ID: " + id + "ClubID: " + clubIDpassedIn, Toast.LENGTH_LONG).show();
                                        if(id.equals(clubIDpassedIn)){

                                            idFound = 1;
                                            mainClubId = id;
                                            //ArrayList<String> memList = new ArrayList<>(members.length);
                                            for(String j : members){
                                                memList.add(j);
                                            }

                                            memList.add(userIDpassedIn);
                                            //Toast.makeText(getApplicationContext(), memList.get(memList.size() - 2), Toast.LENGTH_LONG).show();

                                            clubID = id;
                                            clubName = name ;
                                            clubDomain = domain;
                                            clubStatus = status;
                                            clubTags = tags;

                                        }

                                        if(idFound == 1){
                                            //Toast.makeText(getApplicationContext(), "Reached", Toast.LENGTH_LONG).show();
                                            postData(clubID, clubName, clubDomain, clubStatus, memList, clubTags);
                                        }

                                    }

//                                    // Toast if credentials are not in the server
//                                    if (!exists) {
//                                        Toast.makeText(getApplicationContext(), "Incorrect Credentials", Toast.LENGTH_LONG).show();
//
//                                    }


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
                queue.add(jsonObjectRequest);

                // New JSON GET Request
                JsonObjectRequest jsonObjectRequestEnrollment = new JsonObjectRequest(Request.Method.GET, eJSONURLString, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Do something with response

                                String enrollmentNumber = "";


                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("enrollments"); // From enrollment table

                                    // Get current json object
                                    JSONObject enrollment = array.getJSONObject(array.length() - 1);

                                    String enroll = enrollment.getString("enrollmentNumber");

                                    epostData(enroll, mainClubId);

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
                queue.add(jsonObjectRequestEnrollment);

            }

            /**
             * Post data posts the new data to the club table to allow the user to join the club
             * @param clubs
             * The list of clubs
             * @param name
             * The name of the club
             * @param domain
             * The domain of the club
             * @param status
             * The status of the club (active or not)
             * @param mems
             * The arraylist of club members
             * @param tags
             * This list of club tags
             * @throws JSONException
             */
            public void postData(String clubs, String name, String domain, String status, ArrayList<String> mems, String[] tags) throws JSONException {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                //ArrayList<String> memsList = new ArrayList<>(Arrays.asList(mems));
                ArrayList<String> tagsList = new ArrayList<>(Arrays.asList(tags));
                //Toast.makeText(getApplicationContext(), memsList.get(1) + " " + tagsList.get(1), Toast.LENGTH_LONG).show();

                //Map<String, String> params = new HashMap();
                JSONObject params = new JSONObject();
                params.put("clubID", clubs);
                params.put("clubName", name);
                params.put("clubDomain", domain);
                params.put("clubStatus", status);
                params.put("clubMembers", new JSONArray(mems));
                params.put("clubTags", new JSONArray(tagsList));

                String url = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";
                //String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
                JsonObjectRequest postRequestAddMember = new JsonObjectRequest(Request.Method.POST, url, params,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response) {
                                // response
                                Log.d("Response", response.toString());
                                //Toast.makeText(getApplicationContext(), "Welcome to the" + clubName, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Log.d("Error.Response", error.toString());
                               //Toast.makeText(getApplicationContext(), "Error joining the " + clubName, Toast.LENGTH_LONG).show();
                            }
                        }
                );
                queue.add(postRequestAddMember);
            }

            /**
             *
              * @param enrolled
             * The amount of enrolled users
             * @param clubID
             * The id of the club
             * @throws JSONException
             */
        public void epostData(String enrolled, String clubID) throws JSONException {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            int enrolledInt = Integer.parseInt(enrolled);
            enrolledInt += 1;
            enrolled = Integer.toString(enrolledInt);


            DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
            String date = df.format(Calendar.getInstance().getTime());

            //Map<String, String> params = new HashMap();
            JSONObject params = new JSONObject();
            params.put("enrollmentNumber", enrolled);
            params.put("clubID", clubIDpassedIn);
            params.put("clubStanding", "Active");
            params.put("expirationDate", date);
            params.put("joinDate", date);
            params.put("ranking", "Member");
            params.put("studentID",userIDpassedIn );

            String url = "http://cs309-pp-4.misc.iastate.edu:8080/clubenrollment";
            //String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
            JsonObjectRequest postRequestAddMember2 = new JsonObjectRequest(Request.Method.POST, url, params,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // response
                            Log.d("Response", response.toString());
                            //Toast.makeText(getApplicationContext(), "Welcome to the" + clubName, Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("Error.Response", error.toString());
                            //Toast.makeText(getApplicationContext(), "Error joining the " + clubName, Toast.LENGTH_LONG).show();
                        }
                    }
            );
            queue.add(postRequestAddMember2);
        }
        });

        TextView myTxt = (TextView) findViewById(R.id.clubName);
        myTxt.setText(clubName);

        TextView myTxt2 =(TextView)findViewById(R.id.domain);
        myTxt2.setClickable(true);
        myTxt2.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www." + domainName + "'> "+ domainName + " </a>";
        myTxt2.setText(Html.fromHtml(text));

        TextView myTxt3 = (TextView)findViewById(R.id.status);
        myTxt3.setText(clubStatus);

        // New JSON GET Request
        //JSON GET for the club picture
        RequestQueue lastQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequestTwo = new JsonObjectRequest(Request.Method.GET, fJSONURLString, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with response

                        String clubID = "";
                        String clubName = "";

                        int idFound = 0;

                        try {
                            // Get JSON object
                            JSONArray array = response.getJSONArray("image"); // From club table

                            //Change upper bound of for loop to array.length() to print all values
                            for (int i = 0; i < array.length(); i++) {

                                // Get current json object
                                JSONObject club = array.getJSONObject(i);

                                String id = club.getString("clubID");
                                String url = club.getString("imageURL");

                                //Toast.makeText(getApplicationContext(), "ID: " + id + "ClubID: " + clubIDpassedIn, Toast.LENGTH_LONG).show();
                                if(id.equals(clubIDpassedIn)){
                                    //Toast.makeText(getApplicationContext(), "Reached", Toast.LENGTH_LONG).show();
                                    pictureURL = url;

                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                        ImageView i = findViewById(R.id.imageView2);

                        Picasso.get().load(pictureURL).resize(600, 600).centerInside().into(i);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        lastQueue.add(jsonObjectRequestTwo);

    }

}
