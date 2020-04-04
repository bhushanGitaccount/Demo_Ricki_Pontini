package step_definitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.Arrays;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;
import static org.openqa.selenium.ie.InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY;
public class Hooks {

    public static WebDriver driver;
    public static String url="https://www.google.com/";

    private static String driverDirectory = System.getProperty("user.dir") + "/WebDrivers/usr/bin";
    private static String downloadFilepath = System.getProperty("user.dir") + "/testData/Download";
    private ChromeOptions chromeOptions = new ChromeOptions();
    private InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
    private DesiredCapabilities capabilities = new DesiredCapabilities();
//    String os = System.getProperty("os.name").toLowerCase();
    String os = "win";
    private static int failureCount = 0;
    private static int executionCount = 0;
    private static Cookie cook;


    @Before
    public void openBrowser(Scenario scenario) throws Exception {
        executionCount++;

        String browser1 = System.getProperty("BROWSER");
        String browser ="chrome";
        if (browser == null) {
            browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "chromeheadless";
            }

        }
        switch (browser.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                if (os.contains("win")) {
                    System.out.println("******************INSID SWITCH CASE ***************"+url);
                    System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                } else {
                    System.setProperty(CHROME_DRIVER_EXE_PROPERTY, driverDirectory + "/chrome/chromedriver");
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                }
                break;

            case "firefox":
                if (os.contains("win")) {
                    System.setProperty(GECKO_DRIVER_EXE_PROPERTY, driverDirectory + "/geckoFirefox/geckodriver.exe");
                    driver = new FirefoxDriver();
                } else {
                    System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }
                break;

            case "firefoxheadless":
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);

                if (os.contains("win")) {
                    System.setProperty(GECKO_DRIVER_EXE_PROPERTY, driverDirectory + "/geckoFirefox/geckodriver.exe");
                    driver = new FirefoxDriver(options);
                } else {
                    System.setProperty(GECKO_DRIVER_EXE_PROPERTY, driverDirectory + "/geckoFirefox/geckodriver");
                    driver = new FirefoxDriver(options);
                    driver.manage().window().maximize();
                }
                break;
            case "ie":
                System.setProperty(IE_DRIVER_EXE_PROPERTY, driverDirectory + "/IEDriver/IEDriverServer.exe");
                InternetExplorerOptions ieOptions = new InternetExplorerOptions().requireWindowFocus();
                ieOptions.destructivelyEnsureCleanSession();
                driver = new InternetExplorerDriver(ieOptions);
                break;
        }
    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) throws Exception {
        System.out.println(executionCount + ": " + Arrays.asList(scenario.getSourceTagNames()).toString() + " ---- " + scenario.getStatus());
        if (scenario.isFailed()) {
            failureCount++;
            System.out.println("No. of failures: \t" + failureCount);
            try {
                scenario.write("Current Page URL is " + new URL(driver.getCurrentUrl()));
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }

}