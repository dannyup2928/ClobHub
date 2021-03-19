package backend.clubImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
/**
 * class for club image controller
 * @author Danny Yip, Cobi Mom
 *
 */
public class clubImageController {
	
	@Autowired
	/**
	 * private fields of type clubImageServices
	 */
	private clubImageServices clubimageServices;
	
	/**
	 * get all club image table
	 * @return
	 * the club all image fields
	 */
	@RequestMapping("/clubimage")
	public Image getAllclubImage() {
		return new Image(clubimageServices.getAllclubImage());
	}

	/**
	 * get a specific club image 
	 * 
	 * @param netid users net id 
	 * @return
	 * specific club image 
	 * 
	 * 
	 */
	@RequestMapping("/clubimage/{netid}")
	public clubImage getclubImage(@PathVariable String netid) {
		return clubimageServices.getclubImage(netid);
	}

	/**
	 * add a user into club  
	 * 
	 * @param clubimage
	 * the club to image in
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/clubimage")
	public void addclubImage(@RequestBody clubImage clubimage) {
		clubimageServices.addclubImage(clubimage);
	}



	/**
	 * delete the certain users with net id
	 * 
	 * @param netid
	 * users net id
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/clubimage/{netid}")
	public void deleteclubImage(@PathVariable String netid) {
		clubimageServices.deleteclubImage(netid);
	}
	

}
