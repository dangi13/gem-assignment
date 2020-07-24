# gem-assignment

Steps to run the project :
1. Clone or download the project
2. Go to the project folder where it is downloaded (`where pom.xml file is present`)
3. type command : `mvn install`

Now your test suite execution will start and report will be generated.

**Little points about the framework** ____

The framework is designed to meet the minimal requirement for a API automation project.
Though it can be enhanced to be more generic and optimized, but due to the time shortage as of now it will meet all basic needs.

Some points that i want to mention regards this framework :
Used Libraries/tools/database :
1. `RestAssured` : for API automation
2. `GSON` : for JSON/objects serializing/deserializing
3. `ExtentReports` : for test case reporting
4. `TestNG` : as a unit testing framework
5. `MySQL` : as database

**Reporting**  
The report will be generated in `test-results/execution-reports` folder with date and time for the day.  
For test reporting I have used ExtentReports as it provides an interactive UI for beautiful and representable reports.
(i have added one example html report in the repo at `test-results/execution-reports/2020-07-24` folder)

**Test Configuration**  
You can configure your tests to run in this file : `src/test/resources/test-config.xml`

**Listener Implemenation**
I have used TestNG listeners in this assignment to avoid duplicate configuration/actions/console outputs.
So that we can handle all events at one place `Our test files are way more cleaner and only contains tests and nothing else`

I have tried to implement the **AAA** pattern **(Arrange-Act-Assert)** in tests to make them structured and more readable.

**Project Structure** : 
<pre>   
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---gem
|   |   |           +---listeners
|   |   |           |       CustomReporter.java
|   |   |           |       ExtentReporter.java
|   |   |           |       
|   |   |           \---utils
|   |   |               +---common
|   |   |               |       CommonUtils.java
|   |   |               |       Config.java
|   |   |               |       Constants.java
|   |   |               |       DateUtils.java
|   |   |               |       
|   |   |               \---db
|   |   |                       DbConnector.java
|   |   |                       
|   |   \---resources
|   \---test
|       +---java
|       |   \---com
|       |       \---gem
|       |           +---model
|       |           |   +---requests
|       |           |   \---responses
|       |           |           Country.java
|       |           |           Currencies.java
|       |           |           Languages.java
|       |           |           RegionalBlocs.java
|       |           |           Translations.java
|       |           |           
|       |           +---service
|       |           |       CountryService.java
|       |           |       DbService.java
|       |           |       Routes.java
|       |           |       
|       |           +---tests
|       |           |       CountryTest.java
|       |           |       
|       |           \---validators
|       |                   CountryValidator.java
|       |                   
|       \---resources
|           |   test-config.xml
|           |   
|           \---config
|                   config.properties
|                   
\---test-result
    \---execution-reports
        \---2020-07-24
                execution-report 2020-07-24 071647.html
</pre>

I will be happy to further take this basic framework to next level, adding cool features and enhancements.
Some of them are : 
 1. Parallel test execution
 2. Parallel test case reporting
 3. Completely Excel configurable (non-technical guy can also run scripts just by configuring tests in excel file)
 4. Implementing generic response capture (`interface and implementaion class for holding all type/Class of response`)
 5. Generic methods for Database query results (`instead of different method for each query`)
 5. Cucumber BDD implementaion
 6. Running tests in Docker images and containers using github actions
 
 and anything feasible that you can imagine or you want.
 
 Well, Thanks if you have reached to the end.
 Hope we will meet in the next round.
 
 Stay Safe Stay Healthy


