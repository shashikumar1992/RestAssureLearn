package utility;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

import java.io.FileOutputStream;
import java.io.PrintStream;


import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;




public class Helper {
    static RequestSpecification reqspec;
    static Response resspec;

    public static RequestSpecification requestSpecsification() {
        baseURI = ReadProperty.getValueBykey("BaseUrl");

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

        public static void generateReport() {
            File reportOutputDir = new File("target/cucumber-html-report");
            String jsonPath = "target/jsonReports/cucumber-report.json";

            Configuration config = new Configuration(reportOutputDir, "BuydirectEnrollmentEAutomation");
            config.addClassifications("Author", "Shashikumar");
            config.addClassifications("Build Number", "1.0");
            config.addClassifications("Sprint", "1.0");
            config.addClassifications("Environment", "QA");
            config.addClassifications("Test Type", "API Testing");  


            ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList(jsonPath), config);
            reportBuilder.generateReports();
        }
}
