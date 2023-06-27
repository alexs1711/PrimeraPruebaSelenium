package org.example;


import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;


public class frameTest {



    public static void main(String[] args) {

// TODO Auto-generated method stub
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://jqueryui.com/droppable/");

        //driver.switchTo().frame(1);  Si tenemos el frame principal y un iframe cambia al iframe el foco, es mejor igualemente hacerlo por id o clase
        //System.out.println(driver.findElements(By.tagName("iframe")).size());  nº de iframes
        driver.switchTo().frame(0);
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        //driver.findElement(By.id(""draggable)).click();
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        a.dragAndDrop(source,target).build().perform(); //hacemos drag and drop de un id a otro
        driver.switchTo().defaultContent(); //salimos del iframe

    }



}