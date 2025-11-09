package stepDefinitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.InputElements;
import utils.Console;

import java.awt.*;

public class Homepage_Steps {


    public BrowserManager browserManager;
    private final InputElements inputFld;
    Console console = new Console();

    public Homepage_Steps(BrowserManager browserManager){
        this.browserManager = browserManager;
        this.inputFld = new InputElements(browserManager);
    }

    @Given("I navigate to the webdriveruniversity homepage")
    public void nav_wbdrvruniversity(){
          browserManager.page.navigate("https://www.webdriveruniversity.com/");


    }

    @When("I click on the contact us button")
    public void click_submitbtn(){
        browserManager.page = browserManager.context.waitForPage(() -> {
            browserManager.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
        });

        browserManager.page.bringToFront();


    }

    @And("User inputs {string} data in {string} field")
    public void inputData(String fldVal, String fldName){

        inputFld.inputField(fldName).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        if(inputFld.inputField(fldName).isVisible()){
            inputFld.inputField(fldName).fill(fldVal);
            console.setPassed(fldName +" field has been populated! ");

        } else {
            console.setFailed("Error"+ fldName + "is not found","Check field name");
        }


    }



}
