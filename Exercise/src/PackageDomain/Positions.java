package PackageDomain;
import PackageControllers.DataController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Positions {
	private JSONArray jsonArray;
	
	public Positions (String link) {
		jsonArray = DataController.JsonRead(link);
	}
	
	public void modifySerialNumber (int i, String number) {
		JSONObject position = (JSONObject) jsonArray.get(i);
		position.put("serialNumber", number);						//changing the old serialNumber for the new
	}
	
	public void modifyTime (long InitialTime) {
		JSONObject position1 = (JSONObject) jsonArray.get(0);
		long init = (long) position1.get("time");					//old initialTime
		position1.put("time",InitialTime);							//changing the old initialTime for the new
		for (int i = 1; i < jsonArray.size(); ++i) {
			JSONObject position2 = (JSONObject) jsonArray.get(i);	//old time of position i
			long rest = (long) position2.get("time") - init;		//calculation of the interval from the old initialTime to this time
			position2.put("time", InitialTime + rest);				//changing the time of the position to IntialTime + the old interval
		}
	}
	
	public void modifyTimeAndInterval (long InitialTime, long interval) {
		JSONObject position = (JSONObject) jsonArray.get(0);
		position.put("time", InitialTime);							//changing the old InitialTime for the new
		for (int i = 1; i < jsonArray.size(); ++i) {
			position = (JSONObject) jsonArray.get(i);
			position.put("time",InitialTime + interval*i);			//changing the old time for the InitialTime + the correspondent interval
		}
	}
	
	public void export(String link) {
		DataController.exportJson(jsonArray, link);					//calling the data controller to export the JSON
	}
	
	public JSONArray getArray() {
		return jsonArray;
	}
}
