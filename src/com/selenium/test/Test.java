package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.sql.Time;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {
    private static final String DRIVER = "webdriver.chrome.driver";
    private static final String FILE = "C:\\Users\\Milan\\IdeaProjects\\Advanced Selenium Testing\\chromedriver.exe";
    public static void main(String[] args) {
        System.setProperty(DRIVER,FILE);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).build().perform();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> e = handles.iterator();
        String parent = e.next();
        String child  = e.next();
        driver.switchTo().window(parent);
        driver.close();
        driver.quit();
    }
}
