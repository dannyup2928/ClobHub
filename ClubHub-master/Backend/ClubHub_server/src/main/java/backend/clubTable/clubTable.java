package backend.clubTable;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "ClubTable")
/**
 * 
 * 
 * @author Danny Yip, Cobi Mom
 * 
 * a club table class 
 *
 */
public class clubTable {

	@Id
	/**
	 * clubs unique id
	 */
	private String clubID;
	/**
	 * clubs name
	 */
	private String clubName;
	/**
	 * clubs domain page
	 */
	private String clubDomain;
	/**
	 * clubs status
	 */
	private String clubStatus;
	/**
	 * array list of club members
	 */
	private ArrayList <String> clubMembers;
	/**
	 * array list of club tags 
	 */
	private ArrayList <String> clubTags;

	/**
	 * an empty club table constructor 
	 */
	public clubTable() {

	}

	/**
	 * constructor for club table
	 * 
	 * @param clubid
	 * club id
	 * @param clubname
	 * club name
	 * @param clubdomain
	 * club domain
	 * @param clubstatus club status
	 * @param clubmembers club members
	 * @param clubtags club tags
	 */
	public clubTable(String clubid, String clubname, String clubdomain, String clubstatus, ArrayList <String> clubmembers,ArrayList <String> clubtags  ) {
		super();

		this.clubName = clubname;
		this.clubID = clubid;
		this.clubDomain = clubdomain;
		this.clubStatus = clubstatus;
		this.clubMembers = clubmembers;
		this.clubTags = clubtags;

	}

	/**
	 * get club
	 * @return
	 */
	public String getClubID() {
		return clubID;
	}

/**
 * set club id
 * @param clubID
 * club id
 */
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	/**
	 * get club name
	 * @return
	 * club name
	 */
	public String getClubName() {
		return clubName;
	}
/**
 * set club name
 * @param clubName
 * club name
 * 
 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	/**
	 * get club domain
	 * @return club domain
	 */
	public String getClubDomain() {
		return clubDomain;
	}
/**
 * set club domain
 * @param clubDomain club domain
 */
	public void setClubDomain(String clubDomain) {
		this.clubDomain = clubDomain;
	}
	/**
	 * get club status
	 * @return club status
	 */
	public String getClubStatus() {
		return clubStatus;
	}

	public void setClubStatus(String clubStatus) {
		this.clubStatus = clubStatus;
	}
	/**
	 * get club members 
	 * @return club members
	 */
	public ArrayList<String> getClubMembers() {
		return clubMembers;
	}

	/**
	 * set club members
	 * @param clubMembers
	 * an array list of sting of club members
	 */
	public void setClubMembers(ArrayList<String> clubMembers) {
		this.clubMembers = clubMembers;
	}
	/**
	 * get club tags 
	 * @return
	 * an array list of sting of club tags 
	 */
	public ArrayList<String> getClubTags() {
		return clubTags;
	}

	/**
	 * set club tage 
	 * @param clubTags
	 * 	 * an array list of sting of club tags 
	 */
	public void setClubTags(ArrayList<String> clubTags) {
		this.clubTags = clubTags;
	}

	
	
	
}