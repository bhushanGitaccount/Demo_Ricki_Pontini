package step_definitions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import util.Environments;

public class BaseClass {
    public WebDriver driver = Hooks.driver;
    public String url = Hooks.url;
	public static Cookie cook;
    static long globalTime = 0;

    public void navigateToDiligenceLoginPage() {
		Environments env = new Environments("mrt");
	}
	public void navigateToMotoLoginPage() {
		Environments env = new Environments("moto");
	}
	public void navigateToSpeckLoginPage() {
		Environments env = new Environments("speck");
	}

	public void navigateToMrtLoginPage() {
		Environments env = new Environments("mrt");
	}

	public void navigateToQualcommLoginPage() {
		Environments env = new Environments("qualcomm");
	}

	public void navigateToPulseLoginPage() {
		Environments env = new Environments("pulse");
	}

	public void navigateToBridgestoneLoginPage() {
		Environments env = new Environments("bridgestone");
	}


	public void navigateToInsightAdminLoginPage() {
		Environments env = new Environments("admin");
	}

	public void navigateTo3PMLoginPage() {
        System.out.println("In base");
		Environments env = new Environments("3pm");
	}

	public void navigateToMotoURL() {
		Environments env = new Environments();
	}
}