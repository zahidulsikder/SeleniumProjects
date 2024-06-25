package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.daraz.com.bd/");
//        driver.manage().window().maximize();
//        driver.findElement(By.name("search")).sendKeys("Mac");
//        boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
//        System.out.println(logoDisplayStatus);
//        driver.findElement(By.linkText("Tablets")).click();
//
//        by class name
//        List<WebElement > headerLinks = driver.findElements(By.className("list-inline-item"));
//        for (WebElement headerLink : headerLinks) {
//            System.out.println(headerLink);
//        }
//        by tag name
//        List<WebElement> links = driver.findElements(By.tagName("aa"));
//        System.out.println(links.size());
//        for (WebElement a : links) {
//            System.out.println(a);
//        }
//
//        driver.findElement(By.cssSelector("input#q")).sendKeys("T-shirts");
//
//        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.daraz.com.bd/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("mobile");
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);

        List<WebElement> searchPageResults;
        List<String> allLinkText = new ArrayList<>();
        HashMap<String, String> allLinkMap = new HashMap();

        String xpath, linkHref, linkText;
        for (int i = 1; i <= 3; i++) {
            if (i > 1) {
                xpath = "//a[contains(@href, 'q=mobile') and contains(@href, 'page=" + i + "')]";
                driver.findElement(By.xpath(xpath)).click();
                Thread.sleep(500);
            }
            searchPageResults = driver.findElements(By.xpath("//div[@data-tracking='product-card']/a"));
            for (WebElement link : searchPageResults) {
                linkText = link.getText();
                linkHref = link.getAttribute("href");
                allLinkMap.put(linkText, linkHref);
            }
        }

        Thread.sleep(2000);
        driver.close();
        for (Map.Entry<String, String> eachMapItem : allLinkMap.entrySet()) {
            eachMapItem.getKey();
            eachMapItem.getValue();

            System.out.println("Product Item: " + eachMapItem.getKey() + "\nProduct Link: " + eachMapItem.getValue());
        }

        ExcelFunction ef = new ExcelFunction();
        ef.saveDataExcel(allLinkMap);

        //a[contains(@href, 'q=mobile') and contains(@href, 'page=2')]
        // driver.close();

        // x-Path
        //   https://theautomationzone.blogspot.com/2020/07/xpath-practice.html

        //*[@id='id1']
        //tag[@attribute='value']      ||  // attribute = class, id , name, placeholder etc
        //p[@name='a' and @id='b']
        //p[@name='a' or @id='b']
        //p[(@name='a' and @id='b') or @id='b']


        //p[text()='unique id']
        //p[text()='unique id' and @id = 'id1']

        //span[@id='link' and text() = 'google link'] /../..         \\ going parent tag for div>a>span     || it is select div tag




    }
}