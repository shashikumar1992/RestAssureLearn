📚 RestAssured API Automation Project
This project automates API testing using Java, Rest Assured, Cucumber, and TestNG/JUnit frameworks.
________________________________________
🚀 Project Structure
Folder	Description
stepDefinitions/	Step definitions for Cucumber scenarios
utility/	Helper classes (RequestSpec, DataBuilder, Property Reader, etc.)
features/	Gherkin .feature files for BDD scenarios
resources/	Test Data, Environment Properties
pom.xml	Maven dependencies and plugins
________________________________________
🛠 Tech Stack
•	Java 11/17
•	Maven (build tool)
•	Rest Assured (API testing)
•	Cucumber (BDD framework)
•	TestNG / JUnit (Test Runner)
•	Faker Library (to generate fake data)
•	Git (Version Control)
________________________________________
⚙️ Prerequisites
•	Java JDK 11+ installed
•	Maven installed
•	IDE (Eclipse / IntelliJ recommended)
•	Git installed (optional)
________________________________________
📥 How to Setup
bash
CopyEdit
# 1. Clone the repository
git clone https://github.com/<your-username>/<your-repo>.git

# 2. Navigate into the project folder
cd RestAssureLearn

# 3. Install dependencies
mvn clean install
________________________________________
📜 How to Run Tests
Run using Maven:
mvn test
Run Specific Cucumber Feature:
mvn test -Dcucumber.features=src/test/resources/features/yourFeatureFile.feature
________________________________________
🧹 Reporting
•	Cucumber HTML Reports (default)
•	TestNG Reports (if integrated)
Reports will be generated inside:
bash
CopyEdit
target/cucumber-reports/
________________________________________
🔑 Environment Variables
You can set different environments using config.properties under the /resources folder:
Key	Description
BaseUrl	Base API endpoint URL
partnerId	Test Partner ID
________________________________________
🙋‍♂️ Author
Name	GitHub
Shashi Kumar	@shashikumar1992


