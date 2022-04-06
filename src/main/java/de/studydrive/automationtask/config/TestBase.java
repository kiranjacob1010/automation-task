package de.studydrive.automationtask.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;

    public static Properties readPropertyfile() throws IOException {

        Properties prop = new Properties();
        String location = System.getProperty("user.dir") + "/src/main/resources/application.properties";
        prop.load(new FileInputStream(location));
        return prop;

    }

    public static void initialise() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        Properties propp = readPropertyfile();
        driver.get(propp.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
}
