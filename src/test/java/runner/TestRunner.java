package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions", "utils"},
        tags = "@Tc1 or @Tc2",
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
        private static final Properties properties = new Properties();
        private static final Logger logger = Logger.getLogger(TestRunner.class.getName());


        //* static block to load properties file
        static {
            Path configPath = Paths.get(System.getProperty("config.path",
                    Paths.get(System.getProperty("user.dir"), "src", "main", "resources",
                            "config.properties").toString()));

            try(InputStream input = Files.newInputStream(configPath)){
                properties.load(input);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to load properties file!", e);
            }

        }

        public static void main (String[] args) {
            //Create an instance of TestNG
            TestNG testNG = new TestNG();

            //create a new TestNG Suite
            XmlSuite suite = new XmlSuite();

            //get the thread count from the properties file
            int  threadCount = getThreadCount();
            System.out.println("Configured thread count value: " +threadCount);

            //set the number of threads for the data provider
            suite.setDataProviderThreadCount(threadCount);

            //Create a new TestNG test and add it to the suite
            XmlTest test = new XmlTest(suite);
            test.setName("Cucumber Tests"); //Setting the name of our test
            test.setXmlClasses(Collections.singletonList(new XmlClass(TestRunner.class)));   //Add the test class to the test

            testNG.setUseDefaultListeners(false); //Disable  default listeners (Will disable TestNG reports from being generated)
            testNG.setXmlSuites(Collections.singletonList(suite)); //Add the suite to the TestNG instance
            testNG.run(); //Run TestNG with the configured suite

        }

        //*Method to get thread count from properties file
        private static int getThreadCount(){
           // return Integer.parseInt(properties.getProperty("thread.count","1")); //* this line reads from the config.properties file
            return Integer.parseInt(System.getProperty("thread.count", properties.getProperty("thread.count","1"))); //this line reads and overrides values from the terminal
        }

        //* DataProvider Method - used for parallel execution that allows multiple tests to run simultaneous
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
            return super.scenarios(); //Provides data for the test, enabling parallel execution
        }



}
