package utility;

public enum APIResource {

	createConsumerAPI("api/hostedEnrollment/consumerEnrollment"),
	continueEnrollmentAPI("/api/hostedEnrollment/continueEnrollment"),
	PostToWebhookOnIAVExitAPI("/api/hostedEnrollment/PostToWebhookOnIAVExit"),
	cdwMatchEnrollmentAPI("/api/hostedEnrollment/cdwMatchEnrollment"),
	confirmCdwAPI("/api/hostedEnrollment/confirmCdw");
	String resource;

	APIResource(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
}
