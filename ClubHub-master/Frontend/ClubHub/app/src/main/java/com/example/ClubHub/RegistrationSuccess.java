package com.example.ClubHub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Page that appears once the user successfully registers
 */
public class RegistrationSuccess extends AppCompatActivity {

    /**
     * Takes the user to the next layout once they are registered
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_success);
    }


}
