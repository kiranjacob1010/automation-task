package de.studydrive.automationtask.pages;

import de.studydrive.automationtask.config.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

    public void  acceptCookies() throws InterruptedException {
        String buttonJsPath = "return document.querySelector('#usercentrics-root').shadowRoot.querySelector('.sc-gsDKAQ.iXaGJM')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(5000);
        WebElement acceptCookieButton = (WebElement) js.executeScript(buttonJsPath);
        acceptCookieButton.click();
    }

    public void clickOnSearchIcon() {
        WebElement searchIcon = driver.findElement(By.xpath("//i[@class='icon icon-search']"));
        searchIcon.click();
    }
}
