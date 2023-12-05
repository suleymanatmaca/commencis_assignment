package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class Initialize {
    public static WebDriver driver;
    protected static WebDriverWait wait;
    protected static CommonMethodes methodes = new CommonMethodes();

    File T = new File("src/test/resources/testdata");
    File Tstdt = new File(T, "TestData.properties");

    public String getTestDataPF(String KeyName) {
        Properties prop = null;
        InputStream IP = null;
        try {
            IP = new FileInputStream(Tstdt.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(IP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String Val = prop.getProperty(KeyName);
        return Val;

    }

    @BeforeClass
    public void setUpClass() throws Exception {
        driver = initializeDriver();
    }


    @AfterClass
    public void tearDownClass() {
        System.out.flush();
        driver.quit();
    }

    public WebDriver initializeDriver() {
        System.out.println("*******************");
        System.out.println("Launching Chrome Browser");
        File f = new File("src/test/resources/drivers/windows");
        File ChromeDriver = new File(f, "chromedriver.exe");


        System.setProperty("webdriver.chrome.driver", ChromeDriver.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getTestDataPF("ImplicitWait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, ofSeconds(Integer.parseInt(getTestDataPF("ExplicitWait"))));

        return driver;
    }
}