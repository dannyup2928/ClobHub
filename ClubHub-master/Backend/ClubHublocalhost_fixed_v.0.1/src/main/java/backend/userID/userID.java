package backend.userID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "UserID")
public class userID {
	
	@Id
	private  String netid;
	private  String password;
	


public userID()
{
	
}

public userID(String netid, String password)
{
	super();
		
	
	this.netid = netid;
	this.password = password;
	
}

public String getNetid() {
	return netid;
}

public void setNetid(String netid) {
	this.netid = netid;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}





}
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private Integer id;
//
//    @Column(name = "Name")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String name;
//
//    @Column(name = "NetID")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String netid;
//
//    @Column(name = "FirstName")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String firstname;
//
//    @Column(name = "LastName")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String lastname;
//
//    @Column(name = "Classification")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String classification;
//    
//    @Column(name = "Phone")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String phone;
//    
//    @Column(name = "Major")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private String major;
//    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public boolean isNew() {
//        return this.id == null;
//    }
//
//    public String getName() {
//    	return this.name;
//    }
//    
//    public void setName(String name) {
//    	this.name = name;
//    }
//    
//    public String getNetID() {
//    	return this.netid;
//    }
//    
//    public String getFirstName() {
//        return this.firstname;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstname = firstName;
//    }
//
//    public String getLastName() {
//        return this.lastname;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastname = lastName;
//    }
//
//    public String getClassification() {
//        return this.classification;
//    }
//
//    public void setClassification(String classification) {
//        this.classification = classification;
//    }
//
//    public String getPhone() {
//        return this.phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getMajor() {
//    	return this.major;
//    }
//    
//    public void setMajor(String major) {
//        this.major = major;
//    }
//    @Override
//    public String toString() {
//        return new ToStringCreator(this)
//
//                .append("id", this.getId())
//                .append("name", this.getName())
//                .append("netid", this.getNetID())
//                .append("firstname", this.getFirstName())
//                .append("lastname", this.getLastName())
//                .append("classification", this.getClassification())
//        		.append("phone", this.getPhone())
//                .append("major", this.getMajor()).toString();
//    }
//}
