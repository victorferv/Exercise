package PackageTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import PackageDomain.Positions;

class JUnitPositons {

	@Test
	void testPositions() {
		String current = System.getProperty("user.dir");
		Positions pos = new Positions(current + "/ejemplo");
		assertNotNull(pos);
	}
	
	@Test
	void testModifySerialNumber() {
		String current = System.getProperty("user.dir");
		Positions pos = new Positions(current + "/ejemplo");
		pos.modifySerialNumber(0,"1234");
		JSONObject obj = (JSONObject) pos.getArray().get(0);
		assertEquals((String) obj.get("serialNumber"),"1234");
	}
	
	@Test
	void testModifyTime() {
		String current = System.getProperty("user.dir");
		Positions pos = new Positions(current + "/ejemplo");
		pos.modifyTime(5);
		JSONObject obj = (JSONObject) pos.getArray().get(0);
		assertEquals((long) obj.get("time"),5);
	}
	
	@Test
	void testModifyTimeInterval() {
		String current = System.getProperty("user.dir");
		Positions pos = new Positions(current + "/ejemplo");
		pos.modifyTimeAndInterval(5, 5);
		JSONObject obj = (JSONObject) pos.getArray().get(0);
		JSONObject obj2 = (JSONObject) pos.getArray().get(1);
		JSONObject obj3 = (JSONObject) pos.getArray().get(2);
		assertEquals((long) obj.get("time"),5);
		assertEquals((long) obj2.get("time"),10);
		assertEquals((long) obj3.get("time"),15);
	}

}
