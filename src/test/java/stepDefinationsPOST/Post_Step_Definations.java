package stepDefinationsPOST;

import io.cucumber.java.en.*;
//import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;


public class Post_Step_Definations {

	String Request,responseString;
	RequestSpecification req, res;
	ResponseSpecification resspec;
	Response response;
	@Given("User takes the request Body")
	public void user_takes_the_request_body() {		
		Request = RequestBody.Body();
		System.out.println(Request);		
	}
	@When("User Send the request to Server")
	public void user_send_the_request_to_server() {		
//Build Request using Request Specification Builder
		req =new RequestSpecBuilder().setBaseUri("https://reqres.in/")/*.addQueryParam("key", "qaclick123")*/
				.setContentType(ContentType.JSON).build();		
//Sending Request to Server
		res = given().log().all().spec(req).body(Request);		
	}
	@Then("User will get response from Server")
	public void user_will_get_response_from_server() {
//Capturing Response from Server
		response = res.when().post("api/users");		
//Converting Response to String for validation		
		responseString = response.then().extract().response().asString();		
		System.out.println(responseString);		
	}
	@And("User Validate Responce Status code and Response Body")
	public void user_validate_responce_status_code_and_response_body() {
//Validating response code
		response.then().assertThat().statusCode(201);		
//Validation of response body
		JsonPath js = new JsonPath(responseString);
		String NAME = js.getString("name");
		String JOB = js.getString("job");		
		System.out.println(NAME);		
		if(NAME.equalsIgnoreCase("morpheus")) 
			System.out.println("Name Matching Test Case Pass");
		else
			System.out.println("Name not Matching");			   
		if(JOB.equalsIgnoreCase("leader"))
			System.out.println("Job Title Matching Test Case Pass");
		else
			System.out.println("Job Title Matching Test Case Failed");		
		System.out.println(response.asString());	    
	}
}
