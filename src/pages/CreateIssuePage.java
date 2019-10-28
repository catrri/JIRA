package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateIssuePage {

    public WebDriver driver = null;

    private By createButton = By.xpath("//*[@id='create_link']");
    private By projectInput = By.xpath("//*[@id='project-field']");
    private By issueTypeInput = By.xpath("//*[@id='issuetype-field']");
    private By summaryInput = By.xpath("//*[@id='summary']");
    private By descriptionInput = By.xpath("//*[@id='description']");
    private By createIssue = By.xpath("//*[@id='create-issue-submit']");
    private By createSuccsess = By.xpath("//*[@id='create-issue-submit']");

    public CreateIssuePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCreate() throws InterruptedException {
        driver.findElement(createButton).click();
    }

//    public void enterProject(String project) {
//        driver.findElement(projectInput).sendKeys(project);
//    }
//
//    public void enterIssueType(String issue) {
//        driver.findElement(issueTypeInput).sendKeys(issue);
//    }

    public void enterSummary(String summary) {
        driver.findElement(summaryInput).sendKeys(summary);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionInput).sendKeys(description);
    }

    public boolean createSuccsess() {
        return driver.findElement(createSuccsess).isDisplayed();
    }

}







