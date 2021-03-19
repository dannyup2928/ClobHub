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


public class EvanMockitoTests2 {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * Evan's second mockito test
     * @throws JSONException
     */
    @Test
public void clubSearchPage_onQueryTextChange() throws JSONException {
    //This creates a Mock Object of the class that we have not fully implemented
    ClubSearchPage test = mock(ClubSearchPage.class);

    //Change comment
/*In this simulated instance, the response from the server is a JSONObject "loginSuccess",
with a boolean value "true" because the login was a success
 */
    boolean booleanResponse = true;

    String inputText = "";
    String inputTextFull = "fullTestData";

    //Change comment
/*This line specifies the behavior of the getResponse method from LoginHandler that currently returns null
    You can think of it as overriding the behavior of the function and forcing it to return a specific value
    In the following line, we are forcing this unimplemented method to return our predefined variable "response"
 */

    when(test.onQueryTextChange(inputText)).thenReturn(false);

    Assert.assertEquals(test.onQueryTextChange(inputText),false);

    when(test.onQueryTextChange(inputText)).thenReturn(booleanResponse);

    Assert.assertEquals(test.onQueryTextChange(inputText),booleanResponse);

    when(test.onQueryTextChange(inputText)).thenReturn(false);
    boolean tempResult = test.onqueryTextTest(inputText);

    Assert.assertEquals(tempResult,false);


}
}