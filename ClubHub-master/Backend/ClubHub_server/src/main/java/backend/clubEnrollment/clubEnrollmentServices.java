package backend.clubEnrollment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * 
 * @author Danny Yip, Cobi Mom
 * 
 * a class for club enrollment services 
 *
 */
public class clubEnrollmentServices {
	
	@Autowired
	/**
	 * an instance field for club enrollment services
	 */
	private clubEnrollmentRepository clubEnrollmentRepository;
	
	/**
	 * a list to get all of club enrollment fields
	 * @return
	 * all club enrollment fields
	 */
	public List<clubEnrollment> getAllclubEnrollment()
	{
		List<clubEnrollment> clubenrollment = new ArrayList<>();
		clubEnrollmentRepository.findAll().forEach(clubenrollment::add);
		return clubenrollment;
	}
	
	/**
	 * get specific club enrollment 
	 * 
	 * @param netid
	 * users net id
	 * 
	 * @return
	 * the specific club enrollment fields
	 * 
	 */
	public clubEnrollment getclubEnrollment(String netid)
	{
		return clubEnrollmentRepository.findOne(netid);
	}
	
	/**
	 * add club enrollment  
	 * @param clubenrollment
	 * club enrollment
	 */
	public void addclubEnrollment( clubEnrollment clubenrollment)
	{
		clubEnrollmentRepository.save(clubenrollment);
	}
	
//	public void updateclubEnrollment(String netid, clubEnrollment clubenrollment)
//	{
//		clubEnrollmentRepository.save(clubenrollment);
//
//	}
	
	/**
	 * delete club enrollment 
	 * 
	 * @param netid
	 * users net id
	 * 
	 */
	public void deleteclubEnrollment(String netid)
	{
		clubEnrollmentRepository.delete(netid);

	}
	
	
	
	

}
