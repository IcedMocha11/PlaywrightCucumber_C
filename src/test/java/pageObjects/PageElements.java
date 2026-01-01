package pageObjects;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PageElements {

    private final BrowserManager browserManager;

    public PageElements(BrowserManager browserManager){
        this.browserManager = browserManager;
    }

    public Locator displayData(String expctdData) {
        return browserManager.getPage().getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName(expctdData));
    }







}
