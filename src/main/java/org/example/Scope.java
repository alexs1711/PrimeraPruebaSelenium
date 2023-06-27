package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //1. Show all links from body
        System.out.println(driver.findElements(By.tagName("a")).size());
        //2. Show footer links
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3. Show footer links from first column limiting the scope using the footdriver webelement
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //4. click on each link in the column and check if the pages are opening
        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size() ; i++) {

            String clickonlinkTabs= Keys.chord(Keys.CONTROL,Keys.ENTER);

            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTabs);
            Thread.sleep(5000L);
        }
        //open all tabs
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
