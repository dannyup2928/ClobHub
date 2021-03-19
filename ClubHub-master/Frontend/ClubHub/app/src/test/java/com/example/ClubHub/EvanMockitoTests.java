package com.example.ClubHub;


import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EvanMockitoTests {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * Evan's first mockito test
     * @throws JSONException
     */
    @Test
public void loginSuccess_fetchUserTest() throws JSONException {
    //This creates a Mock Object of the class that we have not fully implemented
    LoginSuccess test = mock(LoginSuccess.class);

    //Change comment
/*Sets the variables used for testing
 */
    String methodResponse = "";

/*Testing to ensure that the function returns the desired results when testing in our system
 */
    when(test.fetchUser()).thenReturn(methodResponse);

    Assert.assertEquals(test.fetchUser(),"");

    methodResponse = "testUser";
    when(test.fetchUser()).thenReturn(methodResponse);

    Assert.assertEquals(test.fetchUser(),"testUser");
}


}