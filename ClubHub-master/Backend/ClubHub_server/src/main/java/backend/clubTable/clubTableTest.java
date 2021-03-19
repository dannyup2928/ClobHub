package backend.clubTable;

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

import backend.userID.userID;

@RunWith(MockitoJUnitRunner.class)
/**
 * class to test club table
 * @author Yip
 *
 */
public class clubTableTest {

	@Mock
	clubTableTest userid;

	@InjectMocks
	clubTableServices clubtableservices;

	@Test
	/**
	 * test get club table method
	 */
	public void testGetClubTable() {

		clubTableServices services = mock(clubTableServices.class);
		ArrayList<String> members = new ArrayList<String>();
		ArrayList<String> tags = new ArrayList<String>();
		when(services.getclubTable("00001"))
				.thenReturn(new clubTable("00010", "uncrustables", "uncrustables.com", "active", members, tags));
		clubTable club = services.getclubTable("00001");

		assertEquals("uncrustables", club.getClubName());
		assertEquals("uncrustables.com", club.getClubDomain());
		assertEquals("active", club.getClubStatus());

	}

	@Test
	/**
	 * test get all club table method
	 */
	public void testGetAllClubTables() {

		clubTableServices services = mock(clubTableServices.class);
		List<clubTable> clubList = new ArrayList<clubTable>();
		clubList.add(new clubTable("00010", "uncrustables", "uncrustables.com", "active", null, null));
		clubList.add(new clubTable("00100", "apple club", "apple.com", "active", null, null));

		when(services.getAllclubTable()).thenReturn(clubList);

		List<clubTable> testList = new ArrayList<clubTable>();
		testList = services.getAllclubTable();

		assertEquals("uncrustables", testList.get(0).getClubName());
		assertEquals("apple.com", testList.get(1).getClubDomain());
	}

	@Test
	/**
	 * test all fields
	 */
	public void testAllFields() {

		clubTableServices services = mock(clubTableServices.class);

		ArrayList<String> members = new ArrayList<String>();
		members.add("123456780");
		members.add("123456781");
		members.add("123456782");

		ArrayList<String> tags = new ArrayList<String>();
		tags.add("food");
		tags.add("social");
		tags.add("fun");

		List<clubTable> clubList = new ArrayList<clubTable>();
		clubList.add(new clubTable("00010", "uncrustables", "uncrustables.com", "active", members, tags));
		clubList.add(new clubTable("00100", "apple club", "apple.com", "active", members, tags));
		when(services.getAllclubTable()).thenReturn(clubList);

		List<clubTable> testList = new ArrayList<clubTable>();
		testList = services.getAllclubTable();

		assertEquals("00010", testList.get(0).getClubID());
		assertEquals("uncrustables", testList.get(0).getClubName());
		assertEquals("uncrustables.com", testList.get(0).getClubDomain());
		assertEquals("active", testList.get(0).getClubStatus());
		assertEquals(members, testList.get(0).getClubMembers());
		assertEquals(tags, testList.get(0).getClubTags());

		assertEquals("00100", testList.get(1).getClubID());
		assertEquals("apple club", testList.get(1).getClubName());
		assertEquals("apple.com", testList.get(1).getClubDomain());
		assertEquals("active", testList.get(1).getClubStatus());
		assertEquals(members, testList.get(0).getClubMembers());
		assertEquals(tags, testList.get(1).getClubTags());

	}

}
