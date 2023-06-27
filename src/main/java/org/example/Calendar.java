package org.example;

import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.path2usa.com/travel-companions");
//April 23
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("#form-field-travel_comp_date"));
        WebElement calendar = new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form-field-travel_comp_date']")));
        calendar.click();
        /*
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
        WebElement calendar = driver.findElement(By.cssSelector("//input[@id='form-field-travel_comp_date']"));
        calendar.click();
        System.out.println(driver.findElement(By.cssSelector("//input[@id='form-field-travel_comp_date']")).getText());
        Actions a = new Actions(driver);
        a.moveToElement(calendar).click().build();
/*
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }


        List<WebElement> dates= driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
        int count=driver.findElements(By.className("day")).size();

        for(int i=0;i<count;i++)
        {
            String text=driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("21"))
            {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }*/
    }

}