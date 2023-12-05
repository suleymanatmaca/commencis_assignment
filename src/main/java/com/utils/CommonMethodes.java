package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonMethodes extends Initialize {
    public static void openBrowser(String URL) {
        driver.get(URL);
    }

    public WebElement WEwithClassName(String name) {
        WebElement element = driver.findElement(By.className(name));
        return element;
    }

    public WebElement WEwithXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }


    public WebElement WEwithId(String id) {
        WebElement element = driver.findElement(By.id(id));
        return element;
    }

    public WebElement WEwithCss(String css) {
        WebElement element = driver.findElement(By.cssSelector(css));
        return element;
    }

    public List<WebElement> WEListwithXpath(String xpath) {
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        return elementList;
    }
}
