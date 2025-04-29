package utility;

import static io.restassured.RestAssured.*;

import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClass.ConsumerInfo;

public class Helper {
	static RequestSpecification reqspec;
	static Response resspec;

	public static RequestSpecification requestSpesification() {
		baseURI = readProperty.getValueBykey("BaseUrl");

		if (reqspec == null) {
			PrintStream log = null;

			log = new PrintStream(new FileOutputStream("loggig.txt"));

			reqspec = given().filter(RequestLoggingFilter.logRequestTo(log))
					.filter(ResponseLoggingFilter.logResponseTo(log)).contentType("application/json");
		}

		return reqspec;
	}
}
