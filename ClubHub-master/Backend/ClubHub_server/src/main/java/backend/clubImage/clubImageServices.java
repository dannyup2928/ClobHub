package backend.clubImage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * 
 * @author Danny Yip, Cobi Mom
 * 
 * a class for club image services 
 *
 */
public class clubImageServices {
	
	@Autowired
	/**
	 * an instance field for club image services
	 */
	private clubImageRepository clubImageRepository;
	
	/**
	 * a list to get all of club image fields
	 * @return
	 * all club image fields
	 */
	public List<clubImage> getAllclubImage()
	{
		List<clubImage> clubimage = new ArrayList<>();
		clubImageRepository.findAll().forEach(clubimage::add);
		return clubimage;
	}
	
	/**
	 * get specific club clubimage 
	 * 
	 * @param netid
	 * users net id
	 * 
	 * @return
	 * the specific club clubimage fields
	 * 
	 */
	public clubImage getclubImage(String netid)
	{
		return clubImageRepository.findOne(netid);
	}
	
	/**
	 * add club image  
	 * @param clubimage
	 * club image
	 */
	public void addclubImage( clubImage clubimage)
	{
		clubImageRepository.save(clubimage);
	}
	
	
	/**
	 * delete club image 
	 * 
	 * @param netid
	 * users net id
	 * 
	 */
	public void deleteclubImage(String netid)
	{
		clubImageRepository.delete(netid);

	}
	
	
	
	

}
