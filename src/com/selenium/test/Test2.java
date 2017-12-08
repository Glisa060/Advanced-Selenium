package com.selenium.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class Test2 {
    private static final String DRIVER = "webdriver.geckodriver.driver";
    private static final String FILES = "C:\\Users\\Milan\\IdeaProjects\\Advanced Selenium Testing\\geckodriver.exe";
    private static final String PATH = "C:\\Users\\Milan\\IdeaProjects\\Advanced Selenium Testing\\test.png";
    public static void main(String[] args) {
        System.setProperty(DRIVER, FILES);
        FirefoxProfile pro = new FirefoxProfile();
        pro.setAcceptUntrustedCertificates(false);
        WebDriver driver = new FirefoxDriver(pro);
        driver.navigate().to("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")) {
            driver.findElement(By.cssSelector("th[class='next']")).click();
        }
        List<WebElement> list = driver.findElements(By.className("day"));
        System.out.println("Size is " +list.size());
        for (int i = 0; i < list.size(); i++) {
                    if(driver.findElements(By.className("day")).get(i).getText().equalsIgnoreCase("23")) {
                        driver.findElements(By.className("day")).get(i).click();
                        break;
                    }
        }
        TakesScreenshot sc = ((TakesScreenshot)driver);
        File file = sc.getScreenshotAs(OutputType.FILE);
        File dest = new File(PATH);
        try {
            FileUtils.copyFile(file, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        driver.close();
//        driver.quit();
    }
}
