package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.


        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.youtube.com");
        //Get youtube title

        String title;

        title = driver.getTitle();
        System.out.println("The youtube title is: "+title);
        //Change window size
        driver.manage().window().setSize(new Dimension(1024, 768));
        //Search video
        //primero hago que se meta a yt y busque el video
        WebElement AcceptCookies = driver.findElement(By.xpath("//*[@class='yt-spec-button-shape-next yt-spec-button-shape-next--filled yt-spec-button-shape-next--call-to-action yt-spec-button-shape-next--size-m ']"));
        //WebElement nextButton = driver.findElement(By.className(""));
        //WebElement textBox = driver.findElement(By.id("search"));
        WebElement submitButton = driver.findElement(By.id("search-icon-legacy"));

        AcceptCookies.click();
        WebElement search = new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.id("search")));
        search.click();
        search.sendKeys("dog thing");
        submitButton.click();

        WebElement Button = driver.findElement(By.xpath("//a[@href='href=/watch?v=taWzoLpdxaI&pp=ygUJZG9nIHRoaW5n')"));
        Button.click();

        driver.close();
        driver.quit();

    }


}