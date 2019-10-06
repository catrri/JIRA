import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginToJira {

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
    By wrongPassword = By.xpath("//div[@class='aui-message aui-message-error']");
    String userName = "Ekaterina_Voronkova";
    String password = "Ekaterina_Voronkova";
    String passwordWrong = "Ekaterina_";


    @Test
    public void LoginPasswordJira() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(passwordWrong);
        this.driver.findElement(enterButton).click();

        Thread.sleep(2000);
        assertTrue(this.driver.findElement(wrongPassword).isDisplayed());

    }

    @AfterTest
    public void tearDownWrong() {
        this.driver.quit();
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/login.jsp");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(enterButton).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }


    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
