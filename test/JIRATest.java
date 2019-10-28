import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class JIRATest extends BaseTest {


    @Test
    public void LoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.loginToJira("Ekaterina_Voronkova", "Ekaterina_Voronkova");
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }


    @Test
    public void CreateIssueTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.loginToJira("Ekaterina_Voronkova", "Ekaterina_Voronkova");
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        CreateIssuePage createIssuePage = new CreateIssuePage(driver);
        createIssuePage.clickCreate();
        createIssuePage.enterSummary("Test create Issue");
        createIssuePage.enterDescription("Description of My Test");
        assertTrue(createIssuePage.createSuccsess());
    }

}