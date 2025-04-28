package utility;

import java.util.Arrays;

import com.github.javafaker.Faker;

import pojoClass.AccountDetailsInfo;
import pojoClass.ConsumerInfo;
import pojoClass.ContinueConsumerInfo;
import pojoClass.DepositWithdrawalInfo;
import pojoClass.WebHookInfo;

public class TestDataBuild {

	public static ConsumerInfo setConsumerData(String fname, String lname, String mailaddress, String phonnumber,
			String partnerid) {
		ConsumerInfo consumer = new ConsumerInfo();
				
		consumer.setEmailAddress(mailaddress);
		consumer.setFirstName(fname);
		consumer.setLastName(lname);
		consumer.setPin("9394");
		consumer.setPartnerId(partnerid);
		consumer.setMobilePhoneNumber(phonnumber);

		consumer.setConsumerDefinedFields(Arrays.asList("", // index 0
				"AUHW", // index 1
				"022993543", // index 2
				"V", // index 3
				"", // index 4
				"", // index 5
				"", // index 6
				"", // index 7
				"", // index 8
				"", // index 9
				"" // index 10
		));
		return consumer;

		// You can now serialize this to JSON or use it in your API test
	}

	public static ContinueConsumerInfo setContinueConsumerData(String fname, String lname, String email,
			String phoneNumber, String consumer_public_key, String consumerAccessToken) {
		Faker faker = new Faker();
		
		ContinueConsumerInfo consumer = new ContinueConsumerInfo();
		consumer.setFirstName(fname);
		consumer.setLastName(lname);
		consumer.setDob("12/19/2005");
		consumer.setPartnerId("MTI3");
		consumer.setStreetAddress("48 ALLENSTOWN RD");
		//consumer.setApartmentNumber(""); // optional
		consumer.setCity("ALLENSTOWN");
		consumer.setState("NY");
		consumer.setZipCode("03275");
		consumer.setMainPhoneNumber(phoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3"));
		consumer.setIdentificationType("DL");
		consumer.setIdentificationState("LA");
		consumer.setIdentificationNumber("3454354545");
		consumer.setTermsAndConditions("true");

		ContinueConsumerInfo.Payload payload = consumer.new Payload();

		payload.setPublicKey(consumer_public_key);
		payload.setAccessToken(consumerAccessToken);

		consumer.setPayload(payload);

		return consumer;
	}

	public static WebHookInfo setWebHookInfo(String partnerid, String Consumerid) {
		WebHookInfo w = new WebHookInfo();
		w.setPartnerId(partnerid);
		w.setConsumerId(Consumerid);
		return w;

	}

	public static AccountDetailsInfo setAccountDeatilsInfo(String accountNumber, String routingNumber,
			String Accouconsumer_public_key, String consumerAccessTokenntDetailsInfo, String partnerid) {

		AccountDetailsInfo ad = new AccountDetailsInfo();
		ad.setAccountNumber(accountNumber);
		ad.setRoutingNumber(routingNumber);

		AccountDetailsInfo.Payload payload = ad.new Payload();
		payload.setPublicKey(Accouconsumer_public_key);
		payload.setAccessToken(consumerAccessTokenntDetailsInfo);
		ad.setPayload(payload);
		ad.setPartnerId(partnerid);

		return ad;
	}

	public static DepositWithdrawalInfo setDepositWithdrawalInfo(String DepositAmount, String WithdrawalAmount,
			String Accouconsumer_public_key, String consumerAccessTokenntDetailsInfo, String partnerid) {

		DepositWithdrawalInfo ad = new DepositWithdrawalInfo();
		ad.setDepositAmount(DepositAmount);
		ad.setWithdrawalAmount(WithdrawalAmount);

		DepositWithdrawalInfo.Payload payload = ad.new Payload();
		payload.setPublicKey(Accouconsumer_public_key);
		payload.setAccessToken(consumerAccessTokenntDetailsInfo);
		ad.setPayload(payload);
		ad.setPartnerId(partnerid);

		return ad;
	}

}
