package browser;

import com.microsoft.playwright.*;
import java.awt.*;
import utils.*;

public class BrowserManager {
    Console console = new Console();
    public Playwright playwright; //used to create an instance of chromium
    public Page page; // is the single tab or window in the browser
    public BrowserContext context; // is the isolated browser session
    public Browser browser; //represents the browser instance

    public void setUp(){
        console.setInfo("Setting up Playwright");
        //Get viewport size of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        playwright = Playwright.create();
        browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        page = context.newPage();
        System.out.println("Playwright setup complete!");


    }

    public void tearDown(){
        console.setInfo("Closing Playwright...");
        if(page != null) page.close();
        if(browser != null) browser.close();
        if(playwright != null) playwright.close();
        console.setInfo("Playwright teardown complete!");

    }

}
