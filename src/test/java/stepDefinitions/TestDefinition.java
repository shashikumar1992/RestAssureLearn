package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.APIResource;
import utility.FakeEmailGenerater;
import utility.Helper;
import utility.TestDataBuild;
import utility.readProperty;

public class TestDefinition   extends Helper {

	static RequestSpecification req;
	static Response response;
	static String consumerAccessToken;
	static String consumer_public_key;
	static String consumer_id;
	String partnerid = readProperty.getValueBykey("partnerId");

	@Given("Register a consumer with partner {string} using consumer details {string}, {string}, {string}, and {string}.")
	public void register_a_consumer_with_partner_using_consumer_details_and(String partner, String fname, String lname,
			String email, String phoneNumber) {
		if (fname.equals("_") || lname.equals("_") || email.equals("_")) {
			
			List<String> consumerData = FakeEmailGenerater.getfakeEmail();
			fname = consumerData.get(0);
			lname = consumerData.get(1);
			email = consumerData.get(2);
		}
		partner = partnerid;
		req = given().spec(requestSpesification())
				.body(TestDataBuild.setConsumerData(fname, lname, email, phoneNumber, partner));
	}

	@When("send the {string} request with {string} method")
	public void send_the_request_with_method(String Apiresource, String method) {
		switch (method.toUpperCase()) {
		case "POST":
			response = req.when().post(APIResource.valueOf(Apiresource).getResource());
			break;
		case "GET":
			response = req.when().get(APIResource.valueOf(Apiresource).getResource());
			break;
		case "PUT":
			response = req.when().put(APIResource.valueOf(Apiresource).getResource());
			break;
		case "DELETE":
			response = req.when().delete(APIResource.valueOf(Apiresource).getResource());
			break;
		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + method);
		}
	}

	@Then("response status code should be {string}")
	public void response_status_code_should_be(String expectedstatuscode) {
		assertEquals(response.getStatusCode(), Integer.parseInt(expectedstatuscode));
	}

	@Then("response message should be {string}")
	public void response_message_should_be(String expectedMessage) {

		String actualMessage = null;

		try {
			// Try parsing the response into a Map
			Map<String, Object> responseMap = response.getBody().as(Map.class);

			if (responseMap.containsKey("messages")) {
				List<?> messages = (List<?>) responseMap.get("messages");
				if (messages != null && !messages.isEmpty()) {
					actualMessage = messages.get(0).toString();
				}
			} else if (responseMap.containsKey("status")) {
				Object status = responseMap.get("status");
				actualMessage = String.valueOf(status);
			} else {
				actualMessage = response.asString();
			}
		} catch (Exception e) {
			actualMessage = response.asString();
		}

		// ❗ Correct order: (error message first, then expected, then actual)
		assertEquals("Response message did not match the expected message.", expectedMessage, actualMessage);

	}

	@Then("Extract {string} and {string} from response")
	public void extract_and_from_response(String string, String string2) {

		consumer_public_key = response.jsonPath().getString("payload.consumer_public_key");
		consumerAccessToken = response.jsonPath().getString("payload.consumerAccessToken");
		consumer_id = response.jsonPath().getString("payload.consumer_id");

	}

	@Given("Continue Enrollment with other basic details")
	public void continue_enrollment_with_other_basic_details() {
		req = given().spec(requestSpesification()).body(TestDataBuild.setContinueConsumerData(
				response.jsonPath().getString("payload.fname"), response.jsonPath().getString("payload.lname"),
				response.jsonPath().getString("payload.email_address"),
				response.jsonPath().getString("payload.mobile_phone"), consumer_public_key, consumerAccessToken));
	}

	@Given("Exit IAV and continue Enrollment with CDW")
	public void exit_iav_and_continue_enrollment_with_cdw() {
		req = given().spec(requestSpesification()).body(TestDataBuild.setWebHookInfo(partnerid, consumer_id));
	}

	@Given("Adding {string} and {string} continue Enrollment")
	public void adding_and_continue_enrollment(String AccountNumber, String RoutingNumber) {
		req = given().spec(requestSpesification()).body(TestDataBuild.setAccountDeatilsInfo(AccountNumber,
				RoutingNumber, consumer_public_key, consumerAccessToken, partnerid));
	}

	@Given("Adding {string} and {string} complete Enrollment")
	public void adding_and_complete_enrollment(String deposit, String withdrow) {
		req = given().spec(requestSpesification()).body(TestDataBuild.setDepositWithdrawalInfo(deposit, withdrow,
				consumer_public_key, consumerAccessToken, partnerid));
	}

	@Then("Notification should be {string}")
	public void notification_should_be(String expectedNotification) {
		String actualNotifiction = response.jsonPath().getString("notification");
		assertEquals(expectedNotification, actualNotifiction);
	}
}
