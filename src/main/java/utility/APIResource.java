package utility;

public enum APIResource {

	CREATE_CONSUMER_API("api/hostedEnrollment/consumerEnrollment"),
	CONTINUE_ENROLLMENT_API("/api/hostedEnrollment/continueEnrollment"),
	POST_TO_WEBHOOK_ON_IAV_EXIT_API("/api/hostedEnrollment/PostToWebhookOnIAVExit"),
	CDW_MATCH_ENROLLMENT_API("/api/hostedEnrollment/cdwMatchEnrollment"),
	CONFIRM_CDW_API("/api/hostedEnrollment/confirmCdw");
	String resource;

	APIResource(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
}
