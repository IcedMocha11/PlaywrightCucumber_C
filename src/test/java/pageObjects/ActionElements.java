package pageObjects;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ActionElements {

    private final BrowserManager browserManager;

    public ActionElements(BrowserManager browserManager){
        this.browserManager = browserManager;
    }


    public Locator actionBtn(String btnName) {
        return browserManager.getPage().getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(btnName));
    }

}
