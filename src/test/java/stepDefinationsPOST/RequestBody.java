package stepDefinationsPOST;

public class RequestBody {
	
	public static String Body() {
		String data ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return data;		
	}

	public static String BodyPut() {
		String data ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return data;		
	}
}
