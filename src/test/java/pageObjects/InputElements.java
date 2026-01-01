package pageObjects;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class InputElements {

    private final BrowserManager browserManager;

    public InputElements(BrowserManager browserManager){
        this.browserManager = browserManager;
    }

    public Locator inputField(String fieldName) {
        return browserManager.getPage().getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName(fieldName));
    }



}
