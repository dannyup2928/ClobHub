package backend.userID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "UserID")
/**
 * 
 * @author Danny Yip, Cobi Mom
 *
 * a user id class
 */
public class userID {

	@Id
	/**
	 * student id 
	 */
	private String studentID;
	/**
	 * user net id
	 */
	private String netID;
	/**
	 * user first name
	 */
	private String firstName;
	/**
	 *  user last name
	 */
	private String lastName;
	/**
	 * user classification
	 */
	private String classification;
	/**
	 *  user phone number
	 */
	private String phoneNumber;
	/**
	 * user major
	 */
	private String major;
	/**
	 * users password
	 */
	private String password;

	/**
	 * an empty constructor for userid
	 */
	public userID() {

	}

	/**
	 * constructor for user ID
	 * @param studentid student id 
	 * @param netid net id
	 * @param firstname user first name
	 * @param lastname user last name
	 * @param classification users classification
	 * @param phonenumber user phone number
	 * @param major user major
	 * @param password user major
	 */
	public userID(String studentid, String netid, String firstname, String lastname, String classification, String phonenumber, String major, String password) {
		super();

		this.studentID = studentid;
		this.netID = netid;
		this.firstName = firstname;
		this.lastName = lastname;
		this.classification = classification;
		this.phoneNumber = phonenumber;
		this.major = major;
		this.password = password;

	}

	/**
	 * get user id
	 * @return
	 * user id
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * set user id
	 * @param studentID user id
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * get user net id
	 * @return user net id 
	 */
	public String getNetID() {
		return netID;
	}
/**
 *  set user net id
 * @param netID user net id
 */
	public void setNetID(String netID) {
		this.netID = netID;
	}
/**
 * get user first name
 * @return user first name
 */
	public String getFirstName() {
		return firstName;
	}
/**
 * set user first name
 * @param firstName user first name
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
/**
 * get user last name
 * @return user last name
 */
	public String getLastName() {
		return lastName;
	}
/**
 * set user last name
 * @param lastName user last name
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/**
 * get user classification
 * @return
 * user classification
 */
	public String getClassification() {
		return classification;
	}
/**
 *  set user classification
 * @param classification
 * 	user classification
 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
/**
 * get user phone number
 * @return user phone number
 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
/**
 * set user phone number
 * @param phoneNumber user phone number
 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
/**
 * get user major
 * @return user major
 */
	public String getMajor() {
		return major;
	}
/**
 * set user major 
 * @param major user major
 */
	public void setMajor(String major) {
		this.major = major;
	}
/**
 * get user password
 * @return user password
 */
	public String getPassword() {
		return password;
	}
/**
 *  set user password
 * @param password user password
 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}

