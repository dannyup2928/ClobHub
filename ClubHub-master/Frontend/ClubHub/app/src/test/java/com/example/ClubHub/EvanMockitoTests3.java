package com.example.ClubHub;


import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


public class EvanMockitoTests3 {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * Evan's third mockito test
     * @throws JSONException
     */
    @Test
    public void clubSearchPage_onQueryTextChange() throws JSONException {
        //This creates a Mock Object of the class that we have not fully implemented
        MapsActivity test = spy(MapsActivity.class);

/* Our simulated values for the test cases
 */
        boolean booleanResponse = true;

        String testLocation = "sleeping club";
        String testLocation1 = "driving club";
        String testLocation2 = "fishing club";
        String testLocation3 = "duwe fan club";
        String brokenClub = "brokenClub";

        //Change comment
/* Tests our method in a variety of fashions to check for all intended results
    Tested with real and fake clubs
 */
        boolean testValue = test.existingClub(testLocation);

        Assert.assertTrue(testValue);

        Assert.assertEquals(test.existingClub(testLocation1),true);

        Assert.assertEquals(test.existingClub(testLocation2),true);

        Assert.assertEquals(test.existingClub(testLocation3),true);

        //This assertion should not work because the club is not real
        Assert.assertEquals(test.existingClub(brokenClub),false);


        //Tries to assert the club to exist
        when(test.existingClub(brokenClub)).thenReturn(true);

        Assert.assertEquals(test.existingClub(brokenClub),true);


/*
        when(test.onQueryTextChange(inputText)).thenReturn(booleanResponse);

        Assert.assertEquals(test.onQueryTextChange(inputText),booleanResponse);

        when(test.onQueryTextChange(inputText)).thenReturn(false);
        boolean tempResult = test.onqueryTextTest(inputText);

        Assert.assertEquals(tempResult,false);
  */


    }

}