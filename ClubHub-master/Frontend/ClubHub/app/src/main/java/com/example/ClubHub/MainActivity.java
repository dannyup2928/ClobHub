package com.example.ClubHub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Main page that the user sees when they open the application
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //From tutorial
    private Activity mActivity;

    private CoordinatorLayout mCLayout;
    private Button mButtonDo;
    private TextView mTextView;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    private String postmanTest = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";


    /**
     * Sets up the buttons and views for the page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mActivity = MainActivity.this;

        // Get the widget reference from XML layout
        //mButtonDo = (Button) findViewById(R.id.JSONget);
        mTextView = (TextView) findViewById(R.id.showResponse);



        //Button to change text
        Button nButton = (Button) findViewById(R.id.Login);
        nButton.setOnClickListener(this);

        //Button to go to the registration page
        Button oButton = (Button) findViewById(R.id.register);
        oButton.setOnClickListener(this);

        //Search button
        Button pButton = (Button) findViewById(R.id.search);
        pButton.setOnClickListener(this);

        //Search button
        Button cButton = (Button) findViewById(R.id.chat);
        cButton.setOnClickListener(this);
    }

    /**
     * Sends the user to the specific page based on what they click
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Login:
                //mTextView.setText("Text Changed");
                startActivity(new Intent(MainActivity.this, Login.class));
                break;

            case R.id.register:
                startActivity(new Intent(MainActivity.this, Registration.class));
                break;

            case R.id.search:
                startActivity(new Intent(MainActivity.this, ClubTagSearch.class));
                break;

            case R.id.chat:
                startActivity(new Intent(MainActivity.this, WebSockets.class));
                break;

        }

    }

}

