package backend.clubTable;

import java.util.List;

/**
 * 
 * @author Danny Yip, Cobi Mom
 * a class for clubs
 */
public class clubs {
	/**
	 * 
	 * instance variable for a list of clubs
	 */
	private List<clubTable> clubs;
	/**
	 * constructor to pass clubs into instance variable
	 * @param clubs
	 * fields of clubs
	 * 
	 */
	public clubs(List<clubTable> clubs) {
		this.clubs = clubs;
	}
	/**
	 * get list of the clubs
	 * @return'
	 * the fields of clubs
	 */
	public List<clubTable> getclubs() {
		return clubs;
	}
}