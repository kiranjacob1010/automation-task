package de.studydrive.automationtask;

import de.studydrive.automationtask.config.TestBase;
import de.studydrive.automationtask.pages.HomePage;
import de.studydrive.automationtask.pages.SearchPage;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class SearchPageTest extends TestBase {

    HomePage homePage;
    SearchPage searchPage;


    public SearchPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        initialise();
        homePage = new HomePage();
        searchPage = new SearchPage();
        homePage.acceptCookies();
    }

    @Test
    public void searchByKeywordTest() throws InterruptedException {
        homePage.clickOnSearchIcon();
        searchPage.searchByKeyword("mathematics");
        // searching number of documents available for the keyword
        String documents = searchPage.getSearchResultOfDocument();
       // Assertions.assertEquals("1,689 results", documents);
        int numberOfDocuments = Integer.parseInt(documents.split(" ")[0].replaceAll(",", ""));
        Assertions.assertTrue(numberOfDocuments > 0);

        // searching number of courses available for the keyword
        String courses = searchPage.getSearchResultOfCourses();
        //Assertions.assertEquals("783 results", courses);
        int numberOfCourses = Integer.parseInt(courses.split(" ")[0].replaceAll(",", ""));
        Assertions.assertTrue(numberOfCourses > 0);

        // searching number of Flashcards available for the keyword
        String flashcards = searchPage.getSearchResultOfFlashcards();
        //Assertions.assertEquals("9 results", flashcards);
        int numberOfFlashcards = Integer.parseInt(flashcards.split(" ")[0].replaceAll(",", ""));
        Assertions.assertTrue(numberOfFlashcards > 0);
    }

    @Test
    public void searchWithMoreFiltersTest() throws InterruptedException {
        homePage.clickOnSearchIcon();
        searchPage.searchByKeyword("mathematics");
        // searching number of available exams for the keyword
        String exams = searchPage.getAllExamsAvailable();
        //Assertions.assertEquals("363 results", exams);
        int numberOfExams = Integer.parseInt(exams.split(" ")[0]);
        Assertions.assertTrue(numberOfExams > 0);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
