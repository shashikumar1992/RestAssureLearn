package pojoClass;

public class ContinueConsumerInfo {
	private String FirstName;
	private String LastName;
	private String Dob;
	private String partnerId;
	private String StreetAddress;
	private String ApartmentNumber;
	private String City;
	private String State;
	private String ZipCode;
	private String MainPhoneNumber;
	private String IdentificationType;
	private String IdentificationState;
	private String IdentificationNumber;
	private String TermsAndConditions;
	private Payload Payload;

	// Getters and Setters

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getStreetAddress() {
		return StreetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		StreetAddress = streetAddress;
	}

	public String getApartmentNumber() {
		return ApartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		ApartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getMainPhoneNumber() {
		return MainPhoneNumber;
	}

	public void setMainPhoneNumber(String mainPhoneNumber) {
		MainPhoneNumber = mainPhoneNumber;
	}

	public String getIdentificationType() {
		return IdentificationType;
	}

	public void setIdentificationType(String identificationType) {
		IdentificationType = identificationType;
	}

	public String getIdentificationState() {
		return IdentificationState;
	}

	public void setIdentificationState(String identificationState) {
		IdentificationState = identificationState;
	}

	public String getIdentificationNumber() {
		return IdentificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		IdentificationNumber = identificationNumber;
	}

	public String getTermsAndConditions() {
		return TermsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		TermsAndConditions = termsAndConditions;
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
