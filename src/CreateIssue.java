import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateIssue {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/LoginToJira/Jira1/chromedriver.exe");
        // Create a new instance of the Chrome driver
        this.driver = new ChromeDriver();
    }

    By userNameInput = By.xpath("//*[@id='login-form-username']");
    By passwordInput = By.xpath("//*[@id='login-form-password']");
    By enterButton = By.xpath("//*[@id='login-form-submit']");
    By createButton = By.xpath("//*[@id='create_link']");
    By projectInput = By.xpath("//*[@id='project-field']");
    By issueTypeInput = By.xpath("//*[@id='issuetype-field']");
    By summaryInput = By.xpath("//*[@id='summary']");
    By descriptionInput = By.xpath("//*[@id='description']");
    By createIssue = By.xpath("//*[@id='create-issue-submit']");
    By createSuccsess = By.xpath("//*[@id='create-issue-submit']");
    String userName = "Ekaterina_Voronkova";
    String password = "Ekaterina_Voronkova";

    @Test
    public void firstTest() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(enterButton).click();
        Thread.sleep(2000);
        this.driver.findElement(createButton).click();
        Thread.sleep(2000);
        this.driver.findElement(projectInput);
        this.driver.findElement(issueTypeInput);
        this.driver.findElement(summaryInput).sendKeys("Test CreateIssue");
        Thread.sleep(2000);
        this.driver.findElement(By.xpath("//*[@id=\"description-wiki-edit\"]")).click();
        this.driver.findElement(descriptionInput).sendKeys("Description of my Test Issue");
        this.driver.findElement(createIssue).click();

        // Thread.sleep(5000);
        assertTrue(this.driver.findElement(createSuccsess).isDisplayed());
        Thread.sleep(5000);


    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }


}