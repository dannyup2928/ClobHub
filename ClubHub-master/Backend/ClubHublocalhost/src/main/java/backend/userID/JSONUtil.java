package backend.userID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONUtil {

	@SuppressWarnings("unchecked")
	public static String toJSon(userID userid) {
		// Here we convert Java Object to JSON
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", userid.getId());
		jsonObj.put("name", userid.getName()); // Set the first name/pair
		jsonObj.put("description", userid.getDescription());

		return jsonObj.toString();

	}
}