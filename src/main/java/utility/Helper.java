package utility;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Helper {
    static RequestSpecification reqspec;
    static Response resspec;

    public static RequestSpecification requestSpesification() {
        baseURI = readProperty.getValueBykey("BaseUrl");

        if (reqspec == null) {
            try {
                PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
                reqspec = given()
                        .filter(RequestLoggingFilter.logRequestTo(log))
                        .filter(ResponseLoggingFilter.logResponseTo(log))
                        .contentType("application/json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return reqspec;
    }
}
