package pojoClass;

public class DepositWithdrawalInfo {
	private String DepositAmount;
	private String WithdrawalAmount;
	private String partnerId;
	private Payload Payload;

	public String getDepositAmount() {
		return DepositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		DepositAmount = depositAmount;
	}

	public String getWithdrawalAmount() {
		return WithdrawalAmount;
	}

	public void setWithdrawalAmount(String withdrawalAmount) {
		WithdrawalAmount = withdrawalAmount;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public Payload getPayload() {
		return Payload;
	}

	public void setPayload(Payload payload) {
		Payload = payload;
	}

	public class Payload {
		private String PublicKey;
		private String AccessToken;

		public String getPublicKey() {
			return PublicKey;
		}

		public void setPublicKey(String publicKey) {
			PublicKey = publicKey;
		}

		public String getAccessToken() {
			return AccessToken;
		}

		public void setAccessToken(String accessToken) {
			AccessToken = accessToken;
		}
	}

}
