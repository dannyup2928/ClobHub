package backend.clubTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * 
 * @author Danny Yip, Cobi Mom
 *
 *a class for club table services
 */
public class clubTableServices {
	
	@Autowired
	/**
	 * an instance variable for club table repository
	 */
	private clubTableRepository clubTableRepository;
			
	/**
	 * get a list of all club table 
	 * @return a list of club table
	 */
	public List<clubTable> getAllclubTable()
	{
		List<clubTable> clubtable = new ArrayList<>();
		clubTableRepository.findAll().forEach(clubtable::add);
		return clubtable;
	}
	
	/**
	 * get a club table 
	 * @param netid users id 
	 * @return get a specific club table
	 */
	public clubTable getclubTable(String netid)
	{
		return clubTableRepository.findOne(netid);
	}
	/**
	 * add a club table 
	 * @param clubtable a club
	 */
	public void addclubTable( clubTable clubtable)
	{
		clubTableRepository.save(clubtable);
	}
	/**
	 * update a club table
	 * @param netid user id 
	 * @param clubtable club table 
	 */
	public void updateclubTable(String netid, clubTable clubtable)
	{
		clubTableRepository.save(clubtable);

	}
	/**
	 * delete a club table 
	 * @param netid users id 
	 */
	public void deleteclubTable(String netid)
	{
		clubTableRepository.delete(netid);

	}

}
