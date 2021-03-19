package com.example.ClubHub;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScottMockito2 {
    /**
     * Soctt's second mockito test
     */
    @Test
    public void loginTest(){

        Login tester = mock(Login.class);

        ArrayList<String> list = new ArrayList<>();

        String user = "svlasic";
        String pass = "1234";

        when(tester.loginCredentials(user,pass)).thenReturn(list);

        Assert.assertEquals(tester.loginCredentials(user,pass), list);
    }
}
