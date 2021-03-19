package com.example.ClubHub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Page the user is taken to once they correctly login
 */
public class LoginSuccess extends AppCompatActivity {

    /**
     * TextView that will appear when they reach the page after a successful login
     */
    TextView text;


    /**
     * Sets the view of the LoginSuccess page and adds the required buttons/destinations to it
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        final String userName = fetchUser();
        text = (TextView)findViewById(R.id.textView3);
        String welcomeText = "Welcome back " + userName;
        text.setText(welcomeText);

        Bundle extra = getIntent().getBundleExtra("extra");
        final String userID = (String)extra.getSerializable("IDNumber");

        Button oButton = (Button) findViewById(R.id.homePageBTN);
        Button sButton = (Button) findViewById(R.id.searchClubBtn);

        oButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent userHomePage = new Intent(LoginSuccess.this, UserHomePage.class);
                userHomePage.putExtra("IDNumber", userID);
                startActivity(userHomePage);

            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchPage = new Intent(LoginSuccess.this, ClubSearchPage.class);
                searchPage.putExtra("IDNumber", userID);
                searchPage.putExtra("tag", "all");
                startActivity(searchPage);
            }
        });

        Button pButton = (Button) findViewById(R.id.loggedInChat);
        pButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent LoggedInChat = new Intent(LoginSuccess.this, LoggedInChat.class);
                LoggedInChat.putExtra("userName", userName);
                startActivity(LoggedInChat);
            }
        });

    }

    /**
     * String function that returns the userName of the user once they login
     * @return
     * userName of the user
     */
    public String fetchUser(){

        Bundle extra = getIntent().getBundleExtra("extra");
        String s = "";
        if(extra != null){
            s = (String)extra.getSerializable("user");
            Log.d("Fetched user: ", s);
            return s;
        }
        else{
            Log.d("No user detected", s);
            return "";
        }
    }

}
