package stepDefinatonsGET;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;


public class GET_Step_Definations {
	
	String responseString, email, actualemail;
	RequestSpecification req, res;
	ResponseSpecification ressep;
	Response response;
	
	@Given("User Send the GET request to Server")
	public void user_send_the_get_request_to_server() {
		req = new RequestSpecBuilder().setBaseUri("https://reqres.in/")./*addQueryParam("key", "page=2").*/setContentType(ContentType.JSON).build();
		res = given().spec(req);
	}

	@When("User will get GET response from Server")
	public void user_will_get_get_response_from_server() {
		response = res.when().get("api/users?page=2");
		responseString = response.then().extract().response().asString();
	}

	@Then("User Validate GET Responce Status code and Response Body")
	public void user_validate_get_responce_status_code_and_response_body() {
		response.then().assertThat().statusCode(200);
		System.out.println(response.asString());
		JsonPath js = new JsonPath(response.asString());
		int countData = js.getInt("data.size()");
		System.out.println(countData);
		
		actualemail="lindsay.ferguson@reqres.in";
		int id=8;
		for(int i=0; i<countData; i++) {
			if(js.getInt("data["+i+"].id")==id) {
				email = js.getString("data["+i+"].email");
				System.out.println(email);
				break;
			}
		}
		if(email.equalsIgnoreCase(actualemail))
				System.out.println("email id is matching TC Passed");
		else
			System.out.println("email id does not matching TC Failed");
		
			
	}

}
