package Section13;



import java.io.IOException;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import java.sql.SQLOutput;
import java.util.List;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.asserts.SoftAssert;



public class BrokenLinks {



    public static void main(String[] args) throws MalformedURLException, IOException {

// TODO Auto-generated method stub

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);



        //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        SoftAssert a =new SoftAssert();

        for(WebElement link : links)

        {
            String url= link.getAttribute("href");
            System.out.println("The web "+url);

            HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

            conn.setRequestMethod("HEAD");

            conn.connect();

            int respCode = conn.getResponseCode();

            System.out.println("Has a response code: "+respCode);
            System.out.println("");

            a.assertTrue(respCode<400, "The link with Text "+link.getText()+" is broken with code " +respCode + "and url: "+url);

        }
        a.assertAll(); //do all failures and then print them here
    }
    private static Object getReturnCode(WebElement link) {

// TODO Auto-generated method stub

        return null;

    }

}