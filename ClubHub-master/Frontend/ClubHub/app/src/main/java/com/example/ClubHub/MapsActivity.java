package com.example.ClubHub;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

/**
 *
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    /**
     * An implementation of a google map
     */
    private GoogleMap mMap;

    /**
     * A given map location
     */
    private String mapLoc;

    /**
     * The maps activity allows users to locate their clubs and events
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mapLoc = getIntent().getStringExtra("clubName");

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        int locExists = 0;

        //Skip logic if the location does not exist
        //if(!existingClub(mapLoc)){
            //return;
        //}

        if(mapLoc.equals("Fishing Club")){
            LatLng fishClub = new LatLng(42.0253, -93.6483);
            mMap.addMarker(new MarkerOptions().position(fishClub).title("Fishing Club"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fishClub,18));
        }

        else if(mapLoc.equals("Sleeping Club")){
            LatLng sleep = new LatLng(42.0281, -93.6496);
            mMap.addMarker(new MarkerOptions().position(sleep).title("Sleeping Club"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sleep,18));
        }

        else if (mapLoc.equals("Duwe Fan Club")){
            LatLng duwe = new LatLng(42.0275, -93.6421);
            mMap.addMarker(new MarkerOptions().position(duwe).title("Duwe Fan Club"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(duwe,18));
        }

        else if (mapLoc.equals("Driving Club")){
            LatLng drive = new LatLng(42.0284, -93.6509);
            mMap.addMarker(new MarkerOptions().position(drive).title("Driving Club"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(drive,18));
        }

        else if(mapLoc.equals("Juicy Boys")){
            LatLng runner = new LatLng(42.0267, -93.6372);
            mMap.addMarker(new MarkerOptions().position(runner).title("Juicy Boys"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(runner,18));
        }
        else{
            LatLng runner = new LatLng(randomX(), randomY());
            mMap.addMarker(new MarkerOptions().position(runner).title(mapLoc));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(runner,18));
        }
    }


    /**
     * Helper method to check if the map locations have been created
     */
    public boolean existingClub(String locName){
        boolean locExists = false;

        switch(locName){
            case("fishing club"):
                locExists = true;
                return locExists;
            case("sleeping club"):
                locExists = true;
                return locExists;
            case("duwe fan club"):
                locExists = true;
                return locExists;
            case("driving club"):
                locExists = true;
                return locExists;
            case("juicy boys"):
                locExists = true;
                return locExists;
            default:
                return locExists;
        }
    }

    /**
     * Returns a random x value for when a club does not have a map location
     * @return
     * The random x coordinate
     */
    public float randomX(){
        float randomValue;

        Random r = new Random();
        double random = 42.026 + r.nextDouble() * (42.029 - 42.026);

        randomValue = (float) random;

        return randomValue;
    }

    /**
     * Returns a random y value for when the club does not have a map location
     * @return
     * The random y coordinate
     */
    public float randomY(){
        float randomValue;

        Random r = new Random();
        double random = -93.6509 + r.nextDouble() * (-93.6372 + 93.6509);

        randomValue = (float) random;

        return randomValue;
    }



}
