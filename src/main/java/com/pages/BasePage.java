package com.pages;

import com.utils.CommonMethodes;
import com.utils.Initialize;
import org.testng.Assert;

public class BasePage extends Initialize {
    public void webPageOpen() {
        String URL = "";
        String title = "";
        URL = getTestDataPF("Url");
        title = getTestDataPF("Title");
        CommonMethodes.openBrowser(URL);
        Assert.assertEquals(driver.getTitle(), title);
        System.out.println("Main Page Opened");
    }
}
