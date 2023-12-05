package com.tests;

import com.steps.Steps;
import com.utils.Initialize;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners()
public class RunTest extends Initialize {

    Steps user = new Steps();

    @Test
    public void runTest() {
        user.openBrowser();
        user.waitUntilLoadTheLatestNews();
        user.checkAuthorAndImageForTheLatestNews();
        user.clickRandomTheLatestNews();
        user.checkTheBrowserTitleSameWithTheNewsTitle();
        user.checkTheLinksWithinTheNewsContent();
    }
}
