package com.example.ClubHub;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScottMockito3 {

    /**
     * Soctt's third mockito test
     */
    @Test
    public void registrationTest(){

        Registration tester = mock(Registration.class);

        ArrayList<String> list = new ArrayList<>();

        String netID = "396332961";
        String id = "svlasic";
        String fName = "Scott";
        String lName = "Vlasic";
        String classification = "junior";
        String phone = "949-370-4160";
        String major = "CPRE";
        String pass = "1234";

        when (tester.regCreds(netID, id, fName, lName, classification, phone, major, pass)).thenReturn(list);

        Assert.assertEquals(tester.regCreds(netID, id, fName, lName, classification, phone, major, pass), list);
    }
}
