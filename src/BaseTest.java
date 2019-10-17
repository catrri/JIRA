import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    WebDriver driver;

    @BeforeTest
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/TRASH_JIRA/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();

    }
}
