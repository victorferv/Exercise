package PackageData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {
	public static JSONArray readJson (String link) {
		try {
			JSONParser parser = new JSONParser();
	        FileReader reader = new FileReader(link);
	        Object obj = parser.parse(reader);
	        JSONObject pJsonObject = (JSONObject) obj;
	        JSONArray jsonArray = (JSONArray) pJsonObject.get("Position data");		//getting only the position data array form all the JSON
	        reader.close();
	        return jsonArray;
		}
		catch (FileNotFoundException e) {
			System.out.println("JSON file " + e + " not found");
		}
		catch (IOException e) {
			System.out.println ("Some error ocurred reading data");
			System.out.println("*** getMessage: " + e.getMessage());
			System.out.println("*** toString: " + e.toString());
		}
		catch (Exception e) {
			System.out.println("*** getMessage: " + e.getMessage());
			System.out.println("*** toString: " + e.toString());
		}
		return null;
	}
}
