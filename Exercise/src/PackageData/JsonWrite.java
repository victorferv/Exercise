package PackageData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWrite {
	public static void WriteJson (JSONArray jsonArray, String link) {
		JSONObject obj = new JSONObject();
		obj.put("Position data", jsonArray);								//structuring the JSON to be written
		try {
			File file = new File(link);										//deleting the file if already exists to rewrite data
			if (file.exists()) {
				file.delete();
			}
			FileWriter writer = new FileWriter(file);
			writer.write(obj.toJSONString());
			writer.close();
		}
		catch (IOException e) {
			System.out.println ("Some error ocurred writing data");
			System.out.println("*** getMessage: " + e.getMessage());
			System.out.println("*** toString: " + e.toString());
		}
		catch (Exception e) {
			System.out.println("*** getMessage: " + e.getMessage());
			System.out.println("*** toString: " + e.toString());
		}
	}

}
