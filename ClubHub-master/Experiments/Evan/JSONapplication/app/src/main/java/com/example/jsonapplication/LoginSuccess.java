package com.example.jsonapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginSuccess extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        String fetched = fetchUser();
        text = (TextView)findViewById(R.id.textView3);
        fetched = "Welcome user: " + fetched;
        text.setText(fetched);

    }

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
