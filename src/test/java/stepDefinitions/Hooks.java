package stepDefinitions;

import com.github.javafaker.Faker;

import io.cucumber.java.Before;

public class Hooks {

	Faker f = new Faker();
	String fname = f.name().firstName();
	TestDefinition sd;

	@Before
	public void setup() {
		sd = new TestDefinition();
	}

	@Before("@continueEnrollment")
	public void beforecontinueEnrollmentScenario() {

		if (TestDefinition.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("CREATE_CONSUMER_API", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
		}

	}

	@Before("@PostToWebhookOnIAVExit")
	public void beforePostToWebhookOnIAVExitScenario() {

		if (TestDefinition.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("CREATE_CONSUMER_API", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
			sd.continue_enrollment_with_other_basic_details();
			sd.send_the_request_with_method("CONTINUE_ENROLLMENT_API", "POST");
		}

	}

	@Before("@cdwMatchEnrollment")
	public void beforecdwMatchEnrollmentScenario() {

		if (TestDefinition.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("CREATE_CONSUMER_API", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
			sd.continue_enrollment_with_other_basic_details();
			sd.send_the_request_with_method("CONTINUE_ENROLLMENT_API", "POST");
			sd.exit_iav_and_continue_enrollment_with_cdw();
			sd.send_the_request_with_method("POST_TO_WEBHOOK_ON_IAV_EXIT_API", "POST");
		}
	}

	@Before("@ConfirmCdw")
	public void beforeconfirmCdwScenario() {

		if (TestDefinition.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("CREATE_CONSUMER_API", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
			sd.continue_enrollment_with_other_basic_details();
			sd.send_the_request_with_method("CONTINUE_ENROLLMENT_API", "POST");
			sd.exit_iav_and_continue_enrollment_with_cdw();
			sd.send_the_request_with_method("POST_TO_WEBHOOK_ON_IAV_EXIT_API", "POST");
			sd.add_account_and_routing_to_continue_enrollment("2423140235636677", "121000358");
			sd.send_the_request_with_method("CDW_MATCH_ENROLLMENT_API", "POST");
		}

	}
}
