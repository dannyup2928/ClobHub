package backend.userID;

import java.util.List;

/**
 * 
 * @author Danny Yip, Cobi Mom
 * a class for student
 */
public class Student {
	/**
	 * 
	 * instance variable for a list of Student
	 */
	private List<userID> Student;
	/**
	 * constructor to pass Student into instance variable
	 * @param Student
	 * fields of Student
	 * 
	 */
	public Student(List<userID> Student) {
		this.Student = Student;
	}
	/**
	 * get list of the Student
	 * @return'
	 * the fields of Student
	 */
	public List<userID> getStudent() {
		return Student;
	}
}