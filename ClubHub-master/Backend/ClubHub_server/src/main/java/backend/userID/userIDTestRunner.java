package backend.userID;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * @author Danny Yip, Cobi Mom
 *	class to test user id 
 *
 */
public class userIDTestRunner {

	   public static void main(String[] args) {
		      Result result = JUnitCore.runClasses(userIDTest.class);
		      
		      for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
		      
		      System.out.println(result.wasSuccessful());
		   }
	
	
}
