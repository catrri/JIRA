package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.PageURLs.loginPage;

public class LoginPage {

    WebDriver driver = null;

    private By userNameInput = By.xpath("//*[@id='login-form-username']");
    private By passwordInput = By.xpath("//*[@id='login-form-password']");
    private By enterButton = By.xpath("//*[@id='login-form-submit']");
    private By wrongPassword = By.xpath("//div[@class='aui-message aui-message-error']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(loginPage);
    }

    public void enterUserName(String name) {
        driver.findElement(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(enterButton).click();
    }

    public boolean  isErrorMessageDisplayed() {return driver.findElement(wrongPassword).isDisplayed();}

    public void loginToJira(String name, String password) {
        enterUserName(name);
        enterPassword(password);
        clickLogin();
    }

   }
