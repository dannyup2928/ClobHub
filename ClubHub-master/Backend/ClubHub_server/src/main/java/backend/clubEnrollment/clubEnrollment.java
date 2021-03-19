package backend.clubEnrollment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubenrollment")

/**
 * 
 * @author Danny Yip, Cobi Mom
 *
 * A club enrollment class
 */
public class clubEnrollment {
	
	@Id
	/**
	 * students enrollment number
	 */
	private String enrollmentNumber;
	/**
	 * club unique id
	 */
	private String clubID;
	/**
	 * clubs active status
	 */
	private String clubStanding;
	/**
	 * clubs expired dates  
	 */
	private String expirationDate;
	/**
	 * users join date
	 */
	private String joinDate;
	/**
	 * users ranking
	 */
	private String ranking;
	/**
	 * students identification
	 */
	private String studentID;


	/**
	 * empty club enrollment constructor 
	 */
	public clubEnrollment()
	{
		
	}
	
	/**
	 * Club enrollment constructor with parameters
	 * 
	 * @param enrollmentnumber
	 * students enrollment number
	 * @param clubid
	 * club unique id
	 * @param clubstanding
	 * clubs active status
	 * @param expirationdate
	 * clubs expired dates  
	 * @param joindate
	 * users join date
	 * @param ranking
	 * users ranking
	 * @param studentid
	 * students identification
	 */
	public clubEnrollment(String enrollmentnumber,String clubid,String clubstanding , String expirationdate, String joindate ,String ranking, String studentid )
	{
		this.clubID = clubid;
		this.enrollmentNumber = enrollmentnumber;
		this.studentID = studentid;
		this.ranking = ranking;
		this.joinDate = joindate;
		this.expirationDate = expirationdate;
		this.clubStanding = clubstanding;

		
	}

	/**
	 * gets enrollment numbers
	 * @return
	 * students enrollment number
	 */
	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	/**
	 * sets enrollment numbers
	 * @param enrollmentNumber
	 * students enrollment number
	 */
	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

/**
 * gets club standing
 * @return
 * clubs active status
 */
	public String getClubStanding() {
		return clubStanding;
	}
/**
 * sets club standing
 * @param clubStanding
 * clubs active status
 */
	public void setClubStanding(String clubStanding) {
		this.clubStanding = clubStanding;
	}

	/**
	 * get clubs expiration date
	 * @return
	 * clubs expiration date
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * set clubs expiration date
	 * @param expirationDate
	 * clubs expiration date
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * get users join date
	 * @return
	 * users join date
	 */
	public String getJoinDate() {
		return joinDate;
	}

	/**
	 * set users join date
	 * @param joinDate
	 * users join date
	 */
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * get users ranking
	 * @return
	 * users ranking
	 */
	public String getRanking() {
		return ranking;
	}

	/**
	 * set users ranking
	 * @param ranking
	 * users ranking
	 */
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	/**
	 * get club unique id
	 * @return
	 *  club unique id
	 */
	public String getClubID() {
		return clubID;
	}

/**
 * set club unique id
 * @param clubID
 *  club unique id
 */
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	/**
	 *  get student identification
	 * @return
	 * student identification
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 *  set student identification
	 * @param studentID
	 * get student identification
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}





	
	
	
	
	
}
