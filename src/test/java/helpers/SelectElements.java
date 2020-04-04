package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

import java.util.List;
import java.util.Random;

/**
 * Created by tdatta on 6/22/17.
 */
public class SelectElements extends BaseClass {
    private Random random = new Random();
//    private PageHelpers pageHelpers = new PageHelpers();


    public void selectRandomValueDropdown(String ID){
        Select selectItem = new Select(driver.findElement(By.id(ID)));
        int optionIndex = random.nextInt(selectItem.getOptions().size() - 1);
        selectItem.selectByIndex(optionIndex++);
    }

    public void selectRandomOption(Object by){
        Select select = null;
        if(by instanceof WebElement){
            WebElement element = (WebElement) by;
            select = new Select(element);
        }
        else if(by instanceof By){
            By byElement = (By) by;
            select = new Select(driver.findElement(byElement));
        }
        else if(by instanceof Select){
            select = (Select) by;
        }
        List<WebElement> allProducts = select.getOptions();
//        int randomProduct = pageHelpers.randomBetween(1, allProducts.size());
/*
        System.out.println("old random number: " + randomProduct + " ------ size: " + (long)allProducts.size());
        randomProduct = (randomProduct < 0) ? randomProduct + 3 : randomProduct;
        System.out.println("random number: " + randomProduct + " ------ size: " + (long)allProducts.size());
*/
//        allProducts.get(randomProduct).click();
    }

    public List<WebElement> getOptions(WebElement webElement){
        Select oSelect = new Select(webElement);
        List<WebElement> allProducts = oSelect.getOptions();
        return allProducts;
    }

    public Select getSelect(WebElement webElement){
        Select oSelect = new Select(webElement);
        return oSelect;
    }

    public Select getSelect(By by){
        Select oSelect = new Select(driver.findElement(by));
        return oSelect;
    }

    public void selectRandomOptionBesideFirst(By by){
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> allProducts = oSelect.getOptions();
        for (int i = 0; i < allProducts.size(); i++){

            int randomProduct = random.nextInt(allProducts.size());
            allProducts.get(randomProduct).click();
        }
    }
    public void selectByVisibleText(By by, String text){
       new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    public void selectByVisibleText(WebElement element, String text){
        new Select(element).selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String text){
        new Select(element).selectByValue(text);
    }

    public void selectByIndexNumbert(By by, int indexNumber){
        new Select(driver.findElement(by)).selectByIndex(indexNumber);
    }

    public String selectByIndexNumbert(WebElement element, int indexNumber){
        Select select = new Select(element);
        select.selectByIndex(indexNumber);
        return select.getFirstSelectedOption().getText();
    }

    public void selectJavaScriptItems(String selectID, String selectText) throws Exception {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s').attr('style','display:block;');", selectID));
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s option').attr('style','display:block;')", selectID));
        } else {
            throw new Exception("broken");
        }

        WebElement element = driver.findElement(By.id(selectID));
        Select select = new Select(element);
        select.selectByVisibleText(selectText);
    }

    public void selectRandombyElement(WebElement element) {
        Select oSelect = new Select(element);
        List<WebElement> allProducts = oSelect.getOptions();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }
}
