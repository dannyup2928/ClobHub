package backend.clubImage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClubImage")

/**
 * 
 * @author Danny Yip, Cobi Mom
 *
 * A club image class
 */
public class clubImage {
	
	@Id
	/**
	 * club unique id
	 */
	private String imageID;
	/**
	 * students image number
	 */
	private String clubID;

	/**
	 * clubs image url
	 */
	private String imageURL;


	/**
	 * empty club image constructor 
	 */
	public clubImage()
	{
		
	}
	
	/**
	 * Club image constructor with parameters
	 * 
	 * @param clubid
	 * students image number
	 * @param imageid
	 * club unique id
	 * @param imageformat
	 * clubs image format
	 * @param imageurl
	 * clubs image url
	 */
	public clubImage(String imageid,String clubid, String imageurl)
	{
		this.imageID = imageid;
		this.clubID = clubid;
		this.imageURL = imageurl;


		
	}

	/**
	 * get club image number
	 * @return
	 * image number
	 */
	public String getImageID() {
		return imageID;
	}

	/**
	 * set image number
	 * @param imageNumber image number
	 */
	public void setImageID(String imageid) {
		this.imageID = imageid;
	}

	/**
	 * get club id
	 * @return
	 * club id
	 */
	public String getClubID() {
		return clubID;
	}

	/**
	 * set club id
	 * @param clubID club id
	 */
	public void setClubID(String clubid) {
		this.clubID = clubid;
	}

	/**
	 * get image url
	 * @return
	 * image url
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * set image url
	 * @param imageURL 
	 * image url
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}





	
	
	
	
	
}
