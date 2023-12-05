package com.pages;

import com.utils.Initialize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import org.testng.Assert;

public class NewsPage extends Initialize {
    private static final String SELECT_NEWS_TITLE = "article__title";
    private static final String LINKS_IN_CONTENT = "//div[@class='article-content']/p/a";
    private List<WebElement> linksInNewsContentElement;

    public void checkTheBrowserTitleSameWithTheNewsTitle() {
        String newsTitle = "";
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(SELECT_NEWS_TITLE)));
        newsTitle = methodes.WEwithClassName(SELECT_NEWS_TITLE).getText();
        System.out.println("Latest news title was seen : " + newsTitle);
        Assert.assertEquals(driver.getTitle(), newsTitle + " | TechCrunch");
        System.out.println("Selected news title verified that same as browser title.");
    }

    public void checkTheLinksWithinTheNewsContent() {
        linksInNewsContentElement = methodes.WEListwithXpath(LINKS_IN_CONTENT);
        for (WebElement i : linksInNewsContentElement) {
            Assert.assertFalse(i.getAttribute("href").isEmpty());
            System.out.println("The link is: " + i.getAttribute("href"));
        }
        System.out.println("All the links within the news content have links");
    }

}
