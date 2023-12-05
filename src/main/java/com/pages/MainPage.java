package com.pages;

import com.utils.Initialize;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class MainPage extends Initialize {
    private static final String LATEST_NEWS_LINKS = "//article[contains(@class,'post-block')]";
    private List<WebElement> latestNews;

    public void waitUntilLoadTheLatestNews() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithXpath(LATEST_NEWS_LINKS)));
        System.out.println("Latest news was seen");
        latestNews = methodes.WEListwithXpath(LATEST_NEWS_LINKS);
    }

    public void checkAuthorForTheLatestNews() {
        Assert.assertTrue(checkTheLatestNewsHaveAuthor());
    }

    public void checkImageForTheLatestNews() {
        Assert.assertTrue(checkTheLatestNewsHaveImage());
    }

    public void clickRandomTheLatestNews() {
        Random randomNum = new Random();
        int index = randomNum.nextInt(countOfTheLatestNews()) - 1;
        System.out.println("Selected random news index is: " + index);
        latestNews.get(index).click();
        System.out.println("Selected random news URL is: " + latestNews.get(index).getAttribute("data-mrf-link"));
    }

    public boolean checkTheLatestNewsHaveAuthor() {
        String getAuthorName = "";
        boolean var = true;

        for (WebElement i : latestNews) {
            getAuthorName = i.findElement(By.className("river-byline__authors")).getText();
            if (getAuthorName.isEmpty()) {
                System.out.println("News without an author. The link is" + i.getAttribute("data-mrf-link"));
                var = false;
            } else {
                System.out.println("Author Name: " + getAuthorName);
            }
        }
        if (var) {
            System.out.println("All news has an author");
        } else {
            System.out.println("There is news without an author");
        }
        return var;
    }

    public boolean checkTheLatestNewsHaveImage() {
        WebElement imageElement;
        boolean var = true;

        for (WebElement i : latestNews) {
            imageElement = i.findElement(By.className("post-block__media"));

            if (imageElement.findElement(By.cssSelector("img")).getAttribute("src").isEmpty()) {
                System.out.println("News without an image. The link is: " + i.getAttribute("data-mrf-link"));
                var = false;
            } else {
                System.out.println("Image URL: " + imageElement.findElement(By.cssSelector("img")).getAttribute("src"));
            }
        }
        if (var) {
            System.out.println("All news has an image");
        } else {
            System.out.println("There is news without an image");
        }
        return var;
    }

    public int countOfTheLatestNews() {
        int count = 0;
        count = latestNews.size();
        System.out.println("Count of the latest news: " + count);
        return count;
    }
}
