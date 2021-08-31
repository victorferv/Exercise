package PackageControllers;
import PackageData.*;
import org.json.simple.JSONArray;

public class DataController {
	
	public static JSONArray JsonRead (String link) {
		return JsonRead.readJson(link);						//calling the function in the Data layer to read the JSON  file
	}
	
	public static void exportJson (JSONArray jsonArray, String link) {
		JsonWrite.WriteJson(jsonArray, link);				//calling the function in the Data layer to write the JSON in a file
	}

}
