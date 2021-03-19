package backend.userID;

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
 *a class for user id services
 */
public class userIDServices {
	
	@Autowired
	/**
	 * an instance variable for user id repository
	 */
	private userIDRepository usersidRepository;
			
	/**
	 * get a list of all userID
	 * @return a list of userID
	 */
	public List<userID> getAlluserID()
	{
		List<userID> usersid = new ArrayList<>();
		usersidRepository.findAll().forEach(usersid::add);
		return usersid;
	}
	
	/**
	 * get a userID
	 * @param netid users id 
	 * @return get a specific userID
	 */
	public userID getuserID(String netid)
	{
		return usersidRepository.findOne(netid);
	}
	
	/**
	 * add a userID
	 * @param userid userID
	 */
	public void adduserID( userID userid)
	{
		usersidRepository.save(userid);
	}
	/**
	 * update a userID
	 * @param netid user net ID
	 * @param userid userID
	 */
	public void updateuserID(String netid, userID userid)
	{
		usersidRepository.save(userid);

	}
	/**
	 * delete a userID
	 * @param netid users id 
	 */
	public void deleteuserID(String netid)
	{
		usersidRepository.delete(netid);

	}

}
