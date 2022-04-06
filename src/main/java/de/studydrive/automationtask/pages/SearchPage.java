package de.studydrive.automationtask.pages;

import de.studydrive.automationtask.config.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends TestBase {

    public void searchByKeyword(String keyword) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='md:border-0 pr-12 leading-6 h-14']"));
        searchBox.sendKeys(keyword);
        WebElement searchIcon = driver.findElement(By.xpath("//i[@id='go-to-search-page-icon']"));
        searchIcon.click();

    }

    public String getSearchResultOfDocument() throws InterruptedException {
        WebElement documentButton = driver.findElement(By.xpath("//button[normalize-space()='Documents']"));
        documentButton.click();
        Thread.sleep(3000);
        return getSearchResults();
    }

    public String getSearchResultOfCourses() throws InterruptedException {
        WebElement documentButton = driver.findElement(By.xpath("//button[normalize-space()='Courses']"));
        documentButton.click();
        Thread.sleep(3000);
        return getSearchResults();
    }

    public String getSearchResultOfFlashcards() throws InterruptedException {
        WebElement documentButton = driver.findElement(By.xpath("//button[normalize-space()='Flashcards']"));
        documentButton.click();
        Thread.sleep(3000);
        return getSearchResults();
    }

    public String getAllExamsAvailable() throws InterruptedException {
        WebElement moreFilters = driver.findElement(By.xpath("//span[@class='ml-1 mt-1']"));
        moreFilters.click();
        WebElement examCheckBox = driver.findElement(By.xpath("//label[5]//span[2]"));
        examCheckBox.click();
        return getSearchResults();
    }

    private String  getSearchResults() throws InterruptedException {
        WebElement searchResults = driver.findElement(By.xpath("//div[@class='text-black-600 float-left']"));
        Thread.sleep(5000);
        return searchResults.getText();
    }
}
