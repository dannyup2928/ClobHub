package backend.clubTable;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * @author Danny Yip, Cobi Mom
 *	class to test club table
 *
 */
public class clubTableTestRunner {

	   public static void main(String[] args) {
		      Result result = JUnitCore.runClasses(clubTableTest.class);
		      
		      for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
		      
		      System.out.println(result.wasSuccessful());
		   }
	
	
}
