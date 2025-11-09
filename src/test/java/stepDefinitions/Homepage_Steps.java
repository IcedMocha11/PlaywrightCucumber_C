package stepDefinitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.awt.*;

public class Homepage_Steps {

    private final Page page; //Represents a single web page within a context
    private final BrowserContext browserContext; // Represents a browser context (separate browsing session)
    private Page mostRecentPage;

    public Homepage_Steps(){
        //Get viewport size of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        page = browserContext.newPage();

    }




    @Given("I navigate to the webdriveruniversity homepage")
    public void nav_wbdrvruniversity(){
        page.navigate("https://www.webdriveruniversity.com/");


    }

    @When("I click on the contact us button")
    public void click_submitbtn(){
        mostRecentPage = browserContext.waitForPage(() -> {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
        });

        mostRecentPage.bringToFront();
        //mostRecentPage.pause();
        mostRecentPage.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("Hoshina");



    }



}
