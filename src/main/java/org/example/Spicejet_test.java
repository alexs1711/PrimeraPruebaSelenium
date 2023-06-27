package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;



public class Spicejet_test {



    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub
        String from = "IXM";
        String to = "PNY";
        int numberpax = 4;

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://spicejet.com"); //URL in the browser
        //click one way
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73'])[1]")).click();
        //check if one way was clicked by checking the svg circle fill property, it should be filled with some circle in orange
        if(driver.findElement(By.xpath("//*[name()='circle' and contains(@fill,'#EDB16A')]/parent::*//parent::*/parent::*//parent::*/div/div")).getText().equals("One Way"))
        {
            System.out.println("One way button is checked");
            //Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        //click from button
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[1]")).click();
        //click text that contains string to
        driver.findElement(By.xpath("(//div[contains(text(),\""+from+"\")])[1]")).click();

        Thread.sleep(2000);
        //click to button
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73'])[2]")).click();
        //click PNY
        driver.findElement(By.xpath("//div[contains(text(),\""+to+"\")]")).click();

        //calendar click june 2023 day 10
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-June-2023']//div//div//div[@data-testid='undefined-calendar-day-10']")).click();

        //passengers click
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();

        Thread.sleep(2000);
        //click + numberpax times
        for(int i=1;i<numberpax;i++)

        {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();

        }

        //Check if we have adults
        if(numberpax==1){
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[2]")).getText(), numberpax+" Adult");
        }else{
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[2]")).getText(), numberpax+" Adults");
        }

        //Print 5 adults
        System.out.println(driver.findElement(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[2]")).getText());
        //Click currency
        driver.findElement(By.xpath("//div[normalize-space()='Currency']")).click();
        //Select USD as currency
        driver.findElement(By.xpath("//div[contains(text(),'USD')]")).click();
        //click to search flight
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();

    }



}

