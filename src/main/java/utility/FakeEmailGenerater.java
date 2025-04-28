package utility;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class FakeEmailGenerater {

	static Faker f = new Faker();

	public static List<String> getfakeEmail() {
		List<String> testData = new ArrayList<String>();
		String fname = f.name().firstName();
		String lname = f.name().lastName();
		String mailAddress = fname + lname + "@gmail.com";
		testData.add(fname);
		testData.add(lname);
		testData.add(mailAddress);
		return testData;
	}
}
