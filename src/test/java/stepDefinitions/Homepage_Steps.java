package stepDefinitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.InputElements;
import pageObjects.ActionElements;
import pageObjects.PageElements;
import utils.Console;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Homepage_Steps {


    public BrowserManager browserManager;
    private final InputElements inputFld;
    private final ActionElements actionElm;
    private final PageElements pageElm;
    Console console = new Console();

    public Homepage_Steps(BrowserManager browserManager){
        this.browserManager = browserManager;
        this.inputFld = new InputElements(browserManager);
        this.actionElm = new ActionElements(browserManager);
        this.pageElm = new PageElements(browserManager);
    }

    @Given("I navigate to the webdriveruniversity homepage")
    public void nav_wbdrvruniversity(){
          browserManager.page.navigate("https://www.webdriveruniversity.com/");



    }

    @When("I click on the contact us button")
    public void click_link(){
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
            console.setPassed(" entered " + fldVal + " into " + fldName + " field! ");
        } else {
            console.setFailed("Error"+ fldName + "is not found","Check field name");
        }


    }

    @And("User clicks {string} button")
    public void clickBtn(String btnName){

        actionElm.actionBtn(btnName).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        if(actionElm.actionBtn(btnName).isVisible()) {
            actionElm.actionBtn(btnName).click();
            console.setPassed(btnName + " button was clicked! ");

        } else {
            console.setFailed("Error"+ btnName + "is not found","Check btn name");
        }

    }

    @And("User expects {string} data to be displayed")
    public void expectData(String expctdData){

        try{
            pageElm.displayData(expctdData).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            assertThat(pageElm.displayData(expctdData)).isVisible();
            assertThat(pageElm.displayData(expctdData)).hasText(expctdData);
            console.setPassed(expctdData + " was displayed! ");

        } catch (AssertionError | PlaywrightException e) {
            console.setFailed(expctdData + " was NOT displayed.", "Reason: " + e.getMessage());

        }

    }



}
