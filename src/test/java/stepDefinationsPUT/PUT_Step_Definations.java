package stepDefinationsPUT;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import stepDefinationsPOST.RequestBody;

import static io.restassured.RestAssured.*;

public class PUT_Step_Definations {

	String request, responseString;
	RequestSpecification req, res;
	ResponseSpecification ressep;
	Response response;
	
	@Given("User takes the PUT request Body")
	public void user_takes_the_put_request_body() {
	    request = RequestBody.BodyPut();	    
	}

	@When("User Send the PUT request to Server")
	public void user_send_the_put_request_to_server() {
	    req = new RequestSpecBuilder().setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
	    res = given().spec(req).body(request);
	}

	@Then("User will get PUT response from Server")
	public void user_will_get_put_response_from_server() {
	    response = res.when().put("api/users/2");
	    responseString = response.then().extract().response().asString();
	}

	@And("User Validate PUT Responce Status code and Response Body")
	public void user_validate_put_responce_status_code_and_response_body() {
		response.then().assertThat().statusCode(200);
		
		JsonPath js = new JsonPath(responseString);
		String NAME = js.getString("name");
		String JOB = js.getString("job");
		
		System.out.println(NAME);
		System.out.println(JOB);
		if(NAME.equalsIgnoreCase("morpheus")) 
			System.out.println("Name Matching Test Case Pass");
		else
			System.out.println("Name not Matching");
			   
		if(JOB.equalsIgnoreCase("zion resident"))
			System.out.println("Job Title Matching Test Case Pass");
		else
			System.out.println("Job Title Not Matching Test Case Failed");
	
	}

}
