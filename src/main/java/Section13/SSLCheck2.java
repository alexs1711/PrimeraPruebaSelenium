package Section13;

import java.util.HashMap;

import java.util.Map;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;


public class SSLCheck2 {



    public static void main(String[] args) {

// TODO Auto-generated method stub

        ChromeOptions options = new ChromeOptions();

        Proxy proxy = new Proxy();

        proxy.setHttpProxy("ipaddress:4444");

        options.setCapability("proxy", proxy);

        //CAMBIAR DIRECCION DESCARGAS
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

// FirefoxOptions options1 = new FirefoxOptions();

// options1.setAcceptInsecureCerts(true);

// EdgeOptions options2 = new EdgeOptions();

        options.setAcceptInsecureCerts(true);

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());



    }



}