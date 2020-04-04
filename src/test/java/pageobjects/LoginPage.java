package pageobjects;

import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;
import util.Environments;

/**
 * Created by tdatta on 5/25/17.
 */
public class LoginPage extends BaseClass {
    private Wait wait = new Wait();

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;


    @FindBy(id = "auth-continue-button")
    public WebElement authContinueButton;

    @FindBy(css = ".dropdown-menu")
    public WebElement dropDown;

    @FindBy(css = ".temp-alert-top.alert.alert-dismissible.alert-success")
    public WebElement resetEmailSent;

    @FindBy(id = "submit-button")
    public WebElement loginButton;

    @FindBy(id = "auth-submit-button")
    public WebElement threepmloginButton;

    @FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//a[contains(text(),'Terms and Conditions')]")
    public WebElement termsAndCondition;

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    public WebElement support;

    @FindBy(id = "RememberMe")
    public WebElement rememberMeButton;

    @FindBy(linkText = "languageOptionsDropDown")
    public WebElement selectLanguage;

    @FindBy(linkText = "Forgot Password")
    public WebElement forgotPassword;

    @FindBy(className = "dropdown-menu")
    public WebElement allTheLanguages;

    public void check_TermsAndCondition(boolean value) {
        if (value) termsAndCondition.click();
    }

    public void check_privacyPolicy(boolean value) {
        if (value) privacyPolicy.click();
    }

    public void check_support(boolean value) {
        if (value) support.click();
    }

    public LoginPage loginAs(String role, String companyName) {


        WebElement element = wait.waitAndReturnElement(driver, By.id("UserName"));
        element.sendKeys(String.format("%s@%s.com", role.toLowerCase(), companyName.toLowerCase()));
        password.sendKeys("Admin123!!");
        loginButton.submit();

        return new LoginPage();
    }

    public void loginPageIsVisible() {

        wait.waitToGetTitle(driver, "Exiger Insight | Log In");
        System.out.println("The title of this page is: " + driver.getTitle());
    }

    public void check_loginPageFunctionalities() {
        userName.isDisplayed();
        password.isDisplayed();
        rememberMeButton.isDisplayed();
        check_TermsAndCondition(true);
        driver.navigate().back();
        check_support(true);
        driver.navigate().back();
        check_privacyPolicy(true);
    }

    public void loginToOMSPage() throws InterruptedException {
        Environments environments = new Environments();
        //Credentials.Credentials();
    }

//    public void loginTo3PMPage() throws InterruptedException {
//        Environments environments = new Environments();
//        environments.loginThreePMsite();
//        //Credentials.Credentials();
//    }

    public String getEnvironment() {
        String Env = System.getProperty("ENV");

        if (Env == null) {
            Env = "qa";
        }
        switch (Env.toLowerCase()) {

            case "dev":
            case "development":
                Env = "dev";
                break;

            case "qa":
                Env =  "qa";
                break;

            case "prod":
                Env =  "";
                break;

            case "production":
                Env =  "";
                break;

            case "stage":
            case "staging":
                Env =  "staging";
                break;
        }
        return Env;
    }
}

