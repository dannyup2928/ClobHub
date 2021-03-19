package backend.userID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
/**
 * 
 * @author Danny Yip, Coi Mom
 *
 */
public class userIDTest {

		@Mock
		userID userid;

		@InjectMocks
		userIDServices useridservices;

		
		
		
		@Test
		/**
		 * test get yser id 
		 */
		public void testGetUserId() {
			
			userIDServices services = mock(userIDServices.class);
			when(services.getuserID("00001")).thenReturn(new userID("00010", "", "Cobi", "Mom", "", "", "", ""));
			userID user = services.getuserID("00001");
			
			assertEquals("Cobi", user.getFirstName());
			assertEquals("Mom", user.getLastName());
			assertEquals("", user.getPassword());

		}


		@Test
		/**
		 * test get all usr id
		 */
		public void testGetAllUserID() {
		
		userIDServices services = mock(userIDServices.class);
		List<userID> myList = new ArrayList<userID>();
		myList.add(new userID("00010", null, "Cobi", null, null, null, null, null) );
		myList.add(new userID("00011", null, "Danny", null, null, null, null, null) );
		
		when(services.getAlluserID()).thenReturn(myList);
		
		List<userID> testList = new ArrayList<userID>();
		testList = services.getAlluserID();
		
		assertEquals("Cobi", testList.get(0).getFirstName());
		assertEquals("Danny", testList.get(1).getFirstName());
		}
		
		
		@Test
		/**
		 * test all fields in user id
		 */
		public void testAllFields() {
			
			userIDServices services = mock(userIDServices.class);
			List<userID> myList = new ArrayList<userID>();
			myList.add(new userID("00010", "cmom", "Cobi", "Mom", "Senior", "5155234567", "SE", "kk") );
			myList.add(new userID("00011", "dannyyip", "Danny", "Yip", "Senior", "5155234566", "COMS", "pp") );
			when(services.getAlluserID()).thenReturn(myList);
			
			List<userID> testList = new ArrayList<userID>();
			testList = services.getAlluserID();
			
			assertEquals("00010", testList.get(0).getStudentID());
			assertEquals("cmom", testList.get(0).getNetID());
			assertEquals("Cobi", testList.get(0).getFirstName());
			assertEquals("Mom", testList.get(0).getLastName());
			assertEquals("Senior", testList.get(0).getClassification());
			assertEquals("5155234567", testList.get(0).getPhoneNumber());
			assertEquals("SE", testList.get(0).getMajor());
			assertEquals("kk", testList.get(0).getPassword());

			
			
			assertEquals("00011", testList.get(1).getStudentID());
			assertEquals("dannyyip", testList.get(1).getNetID());
			assertEquals("Danny", testList.get(1).getFirstName());
			assertEquals("Yip", testList.get(1).getLastName());
			assertEquals("Senior", testList.get(1).getClassification());
			assertEquals("5155234566", testList.get(1).getPhoneNumber());
			assertEquals("COMS", testList.get(1).getMajor());
			assertEquals("pp", testList.get(1).getPassword());
			
			
			
		}
		
		
	
	
}
