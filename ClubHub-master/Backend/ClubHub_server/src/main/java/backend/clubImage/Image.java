package backend.clubImage;

import java.util.List;

/**
 * 
 * @author Danny Yip, Cobi Mom
 * a class for clubImage
 */
public class Image {

	/**
	 * 
	 * instance variable for a list of image
	 */
	private List<clubImage> clubimage;

	/**
	 * constructor to pass image into instance variable
	 * @param image
	 * fields of image
	 * 
	 */
	public Image(List<clubImage> clubimage) {
		this.clubimage = clubimage;
	}

	/**
	 * get list of the image
	 * @return'
	 * the fields of image
	 */
	public List<clubImage> getImage() {
		return clubimage;
	}
	
}
