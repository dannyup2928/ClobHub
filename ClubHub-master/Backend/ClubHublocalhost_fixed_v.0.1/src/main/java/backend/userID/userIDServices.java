package backend.userID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userIDServices {
	
	@Autowired
	private userIDRepository usersidRepository;
			
	public List<userID> getAlluserID()
	{
		List<userID> usersid = new ArrayList<>();
		usersidRepository.findAll().forEach(usersid::add);
		return usersid;
	}
	
	public userID getuserID(String netid)
	{
		return usersidRepository.findOne(netid);
	}
	
	public void adduserID( userID userid)
	{
		usersidRepository.save(userid);
	}
	
	public void updateuserID(String netid, userID userid)
	{
		usersidRepository.save(userid);

	}
	
	public void deleteuserID(String netid)
	{
		usersidRepository.delete(netid);

	}

}
