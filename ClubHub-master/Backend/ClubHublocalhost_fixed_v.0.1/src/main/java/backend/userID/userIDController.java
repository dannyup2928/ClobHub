package backend.userID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class userIDController {

    @Autowired
   private userIDServices useridServices;

    @RequestMapping("/usersid")
    
    public Student getAlluserID()
    {
    	
		return new Student(useridServices.getAlluserID());
    	
    }
    
    
    @RequestMapping("/usersid/{netid}")
    public userID getuserID(@PathVariable String netid)
    {
		return useridServices.getuserID(netid);
    	
    }

    @RequestMapping(method = RequestMethod.POST, path = "/usersid")
    public void adduserID(@RequestBody userID userid)
    {
    	useridServices.adduserID(userid);
    }

    @RequestMapping(method = RequestMethod.PUT, path ="/usersid/{netid}")
    public void updateuserID(@RequestBody userID userid, @PathVariable String netid)
    {
    	useridServices.adduserID(userid);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/usersid/{netid}")
    public void deleteuserID(@PathVariable String netid)
    {
    	useridServices.deleteuserID(netid);
    }
    
}
    
    