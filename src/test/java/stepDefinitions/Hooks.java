package stepDefinitions;

import com.github.javafaker.Faker;

import io.cucumber.java.Before;

public class Hooks {

	Faker f = new Faker();
	String fname = f.name().firstName();

	@Before("@continueEnrollment")
	public void beforecontinueEnrollmentScenario() {

		;
		TestDefenation sd = new TestDefenation();
		if (TestDefenation.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_consumer_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("createConsumerAPI", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
		}

	}

	@Before("@PostToWebhookOnIAVExit")
	public void beforePostToWebhookOnIAVExitScenario() {

		TestDefenation sd = new TestDefenation();
		if (TestDefenation.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_consumer_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("createConsumerAPI", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
			sd.continue_enrollment_with_other_basic_details();
			sd.send_the_request_with_method("continueEnrollmentAPI", "POST");
		}

	}

	@Before("@cdwMatchEnrollment")
	public void beforecdwMatchEnrollmentScenario() {

		TestDefenation sd = new TestDefenation();
		if (TestDefenation.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_consumer_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("createConsumerAPI", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
			sd.continue_enrollment_with_other_basic_details();
			sd.send_the_request_with_method("continueEnrollmentAPI", "POST");
			sd.exit_iav_and_continue_enrollment_with_cdw();
			sd.send_the_request_with_method("PostToWebhookOnIAVExitAPI", "POST");
		}
	}

	@Before("@confirmCdw")
	public void beforeconfirmCdwScenario() {

		TestDefenation sd = new TestDefenation();
		if (TestDefenation.consumer_public_key == null) {
			sd.register_a_consumer_with_partner_using_consumer_details_and(sd.partnerid, fname, f.name().lastName(),
					fname + "@gmail.com", "789-987-9512");
			sd.send_the_request_with_method("createConsumerAPI", "POST");
			sd.extract_and_from_response("accessToken", "publicKey");
			sd.continue_enrollment_with_other_basic_details();
			sd.send_the_request_with_method("continueEnrollmentAPI", "POST");
			sd.exit_iav_and_continue_enrollment_with_cdw();
			sd.send_the_request_with_method("PostToWebhookOnIAVExitAPI", "POST");
			sd.adding_and_continue_enrollment("2423140235636677", "121000358");
			sd.send_the_request_with_method("confirmCdwAPI","POST");
		}

	}
}
