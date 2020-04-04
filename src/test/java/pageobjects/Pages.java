package pageobjects;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;
import util.Credentials;

public class Pages extends BaseClass {

    public Credentials credentials;

    public Actions actions;

    public LoginPage loginPage;


    public Pages(){

        credentials = new Credentials();

        actions = new Actions(driver);

        loginPage = new LoginPage();

        PageFactory.initElements(driver,this);
    }

//    public Wait wait() {
//        //System.out.println(driver);
//        return wait;
//    }


    public LoginPage loginPage() {
        //System.out.println(driver);
        return loginPage;
    }


    public Actions actions() {
        //System.out.println(driver);
        return actions;
    }

    public Credentials credentials() {
        //System.out.println(driver);
        return credentials;
    }

}
