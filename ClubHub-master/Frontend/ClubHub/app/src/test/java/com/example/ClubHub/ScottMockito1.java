package com.example.ClubHub;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScottMockito1 {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * Scott's first mockito test
     * @throws JSONException
     */
    @Test
    public void loginSuccessUserTest() throws JSONException{

        LoginSuccess tester = mock(LoginSuccess.class);

        String userFetched = "svlasic";
        when(tester.fetchUser()).thenReturn(userFetched);
        Assert.assertEquals(tester.fetchUser(), "svlasic");

    }


}

