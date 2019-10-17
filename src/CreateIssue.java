import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CreateIssue extends BaseTest{

//    WebDriver driver;

//    @BeforeTest
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/TRASH_JIRA/chromedriver.exe");
//        // Create a new instance of the Chrome driver
//        this.driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//    }

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
        // Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_link"))).click();

        // this.driver.findElement(createButton).click();
        //Thread.sleep(2000);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='summary']")));
        // this.driver.findElement(projectInput);
        // this.driver.findElement(issueTypeInput);
        this.driver.findElement(summaryInput).sendKeys("Test Create Issue");
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='description']"))).click();
        //this.driver.findElement(By.xpath("//*[@id=\"description-wiki-edit\"]")).click();
        this.driver.findElement(descriptionInput).sendKeys("Description of my Test Issue");
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='create-issue-submit']"))).click();
        //this.driver.findElement(createIssue).click();

        assertTrue(this.driver.findElement(createSuccsess).isDisplayed());
        //Thread.sleep(5000);
        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='create-issue-submit']")));


    }

//    @AfterTest
//    public void tearDown(
//
//    ) {
//        this.driver.quit();
//    }
}