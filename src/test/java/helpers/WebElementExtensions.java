package helpers;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pageobjects.LoginPage;
import step_definitions.BaseClass;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by tdatta on 7/14/17.
 */
public class WebElementExtensions extends BaseClass {
    private Wait wait = new Wait();
    private LoginPage loginPage = new LoginPage();


    public WebElement findElementByDataBind(String binding, String dataBindProperty) {
        WebElement element;
        element = driver.findElement(By.cssSelector(String.format("[data-bind='%s: %s']", binding, dataBindProperty)));
        wait.waitUntilPresent(element);
        return element;
    }

    public List<WebElement> findElementsByDataBind(String binding, String dataBindProperty) {
        List<WebElement> elements;
        elements = driver.findElements(By.cssSelector(String.format("[data-bind='%s: %s']", binding, dataBindProperty)));
        //wait.waitUntilPresent(elements);
        return elements;
    }

    public boolean verifyElementnotPresent(WebElement element) {
        boolean isElementPresent = false;
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            isElementPresent = true;
        } catch (ElementNotVisibleException e) {
            isElementPresent = true;
        }
        return isElementPresent;
    }

    public Boolean checkIfTextDisplayed(By by, String expected) {
        String actualText = driver.findElement(by).getText();
        assertEquals(actualText, expected);
        return null;
    }

    public WebElement findByCSS(String tagName, String attribute, String attributeName) {
        WebElement element = driver.findElement(By.cssSelector(String.format("%s[%s='%s']",
                tagName, attribute, attributeName)));
        return element;
    }

    public List <WebElement> multipleElementsByCSS(String tagName, String attribute, String attributeName) {
        List<WebElement> elements = driver.findElements(By.cssSelector(String.format("%s[%s='%s']",
                tagName, attribute, attributeName)));
        return elements;
    }

    public void loginWithGivenCredentials(DataTable userCredentials){
        List<List<String>> data = userCredentials.raw();
        //This is to get the first data of the set (First Row + First Column)
        loginPage.userName.sendKeys(data.get(0).get(0));
        //This is to get the first data of the set (First Row + Second Column)
        loginPage.password.sendKeys(data.get(0).get(1));
        loginPage.loginButton.click();
    }
    public void clearAndSendKeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);

    }

    public void clickLinkByHref(String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }

    public WebElement findByPartofTextinAID(String tagName, String partOFText) {
        WebElement element;
        element = driver.findElement(By.cssSelector(String.format("%s[id*='%s']", tagName, partOFText)));
        return element;
    }

    public List<WebElement> findElementsByCSS(String tagName, String attribute, String attributeValue) {

        List<WebElement> element;
        element = driver.findElements(By.cssSelector(String.format("%s[%s='%s']",
                tagName, attribute, attributeValue)));
        return element;
    }

    public List<WebElement> findAllElementsByXpath(String xpath) {

        List<WebElement> element;
        element = driver.findElements(By.xpath(xpath));
        return element;
    }

    public List<String> findAllElementsTextByXpath(String xpath) {

        List<WebElement> elements;
        elements = driver.findElements(By.xpath(xpath));
        List<String> textList = elements.stream().map(u -> u.getText())
                        .collect(Collectors.toList());
        return textList;
    }

    public WebElement findElementByXpath(String xpath) {

        WebElement element;
        element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public By getBy(WebElement element){
        By by = null;
//        System.out.println(element.toString());
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");
        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }
}