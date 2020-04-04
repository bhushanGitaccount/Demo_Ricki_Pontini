package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.Pages;
import util.UserNameAndPassword;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class AdminRegression extends Pages {


    @Given("^I click on Internal Users tab$")
    public void iClickOnInternalUsersTab()  {

        System.out.println("INSIDE  STEP DEF");
        loginPage.navigateToDiligenceLoginPage();
    }



    @Given("^I click on Internal Users tab google$")
    public void i_click_on_Internal_Users_tab_google() throws Throwable {
        System.out.println("Inside new test step*******************************");
//        loginPage.navigateToDiligenceLoginPage();
        UserNameAndPassword objuname =  new UserNameAndPassword();
        Map<String,String> up =objuname.userPWD();
        System.out.println("*********** BEST BUY USER NAME IS = "+up.get("Username"));
        System.out.println("*********** BEST BUY USER NAME IS = "+up.get("Password"));
//        loginPage.navigateToMotoLoginPage();

    }


    @And("^I search for Testing$")
    public void iSearchForTesting() throws InterruptedException {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("TESTING");
        Thread.sleep(1000);
    }
}