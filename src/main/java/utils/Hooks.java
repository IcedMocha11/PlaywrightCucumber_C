package utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import browser.BrowserManager;

public class Hooks {

    Console console = new Console();
    private final BrowserManager browserManager;

    public Hooks(BrowserManager browserManager){
        this.browserManager = browserManager;
    }


    //Runs before all test starts
    @BeforeAll
    public static void beforeAll(){
        System.out.println("\n Executing test suite...");
    }

    //Runs after all test are done
    @AfterAll
    public static void afterAll(){
        System.out.println("\n Finished executing test suite!");
    }

    //Runs before each test
    @Before
    public void setup(){
        browserManager.setUp();
    }

    //Runs after each test
    @After
    public void tearDown(){
        browserManager.tearDown();
    }


}
