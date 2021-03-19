package backend.clubEnrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
/**
 * class for club enrollment controller
 * @author Danny Yip, Cobi Mom
 *
 */
public class clubEnrollmentController {
	
	@Autowired
	/**
	 * private fields of type clubEnrollmentServices
	 */
	private clubEnrollmentServices clubenrollmentServices;
	
	/**
	 * get all club enrollment table
	 * @return
	 * the club all enrollment fields
	 */
	@RequestMapping("/clubenrollment")
	public enrollments getAllclubEnrollment() {
		return new enrollments(clubenrollmentServices.getAllclubEnrollment());
	}

	/**
	 * get a specific club enrollment 
	 * 
	 * @param netid users net id 
	 * @return
	 * specific club enrollment 
	 * 
	 * 
	 */
	@RequestMapping("/clubenrollment/{netid}")
	public clubEnrollment getclubEnrollment(@PathVariable String netid) {
		return clubenrollmentServices.getclubEnrollment(netid);
	}

	/**
	 * add a user into club  
	 * 
	 * @param clubenrollment
	 * the club to enrolled in
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/clubenrollment")
	public void addclubEnrollment(@RequestBody clubEnrollment clubenrollment) {
		clubenrollmentServices.addclubEnrollment(clubenrollment);
	}

//	@RequestMapping(method = RequestMethod.PUT, path = "/clubenrollment/{netid}")
//	public void updateclubTable(@RequestBody clubTable clubtable, @PathVariable String netid) {
//		clubenrollmentServices.updateclubTable(netid, clubtable);
//	}

	/**
	 * delete the certain users with net id
	 * 
	 * @param netid
	 * users net id
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/clubenrollment/{netid}")
	public void deleteclubEnrollment(@PathVariable String netid) {
		clubenrollmentServices.deleteclubEnrollment(netid);
	}
	

}
