package backend.clubEnrollment;

import java.util.List;

/**
 * 
 * @author Danny Yip, Cobi Mom
 * a class for enrollments
 */
public class enrollments {

	/**
	 * 
	 * instance variable for a list of enrollments
	 */
	private List<clubEnrollment> enrollments;

	/**
	 * constructor to pass enrollments into instance variable
	 * @param enrollments
	 * fields of enrollments
	 * 
	 */
	public enrollments(List<clubEnrollment> enrollments) {
		this.enrollments = enrollments;
	}

	/**
	 * get list of the enrollments
	 * @return'
	 * the fields of enrollments
	 */
	public List<clubEnrollment> getEnrollments() {
		return enrollments;
	}
	
}
