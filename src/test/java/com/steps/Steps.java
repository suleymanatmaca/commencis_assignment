package com.steps;

import com.pages.*;

public class Steps {

    BasePage basePage = new BasePage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    public void openBrowser() {
        basePage.webPageOpen();
    }

    public void waitUntilLoadTheLatestNews() {
        mainPage.waitUntilLoadTheLatestNews();
    }

    public void checkAuthorAndImageForTheLatestNews() {
        mainPage.checkAuthorForTheLatestNews();
        mainPage.checkImageForTheLatestNews();
    }

    public void clickRandomTheLatestNews() {
        mainPage.clickRandomTheLatestNews();
    }

    public void checkTheBrowserTitleSameWithTheNewsTitle() {
        newsPage.checkTheBrowserTitleSameWithTheNewsTitle();
    }

    public void checkTheLinksWithinTheNewsContent() {
        newsPage.checkTheLinksWithinTheNewsContent();
    }
}