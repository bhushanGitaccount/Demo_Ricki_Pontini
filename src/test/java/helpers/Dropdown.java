package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by titudatta on 8/19/15.
 */
public class Dropdown extends BaseClass {

    public void selectValueFromUnorderedList(WebElement driver, final String value) {
        List<WebElement> options = driver.findElements(By.tagName("li"));
        for (WebElement option : options) {
//           System.out.println(option.getText());
            if (value.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
    }

    public void selectValuesFromUnorderedListWithCheckbox(WebDriver driver, WebElement optionlistdiv, WebElement button, List<List<String>> values) {
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> inputs = optionlistdiv.findElements(By.tagName("input"));
//        for (WebElement input : inputs) {
//            js.executeScript("arguments[0].setAttribute('style', 'display:none;')",input);
//        }
//        List<WebElement> options = optionlistdiv.findElements(By.tagName("label"));
        for(List value: values){
//            for (WebElement option : options) {
//                if (value.equalsIgnoreCase(option.getText())) {
//                    option.click();
//                    break;
//                }
//            }
            driver.findElement(By.xpath("//label[contains(text(),'" + value.get(0) + "')]/input")).click();
        }

        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));

        button.click();
    }

    public void selectValueFromUnorderedListWithCheckbox(String label, String value) {
        WebElement div = driver.findElement(By.xpath("//*[not(contains(@style,'display: none;'))]//label[.='"+label+"' and not(ancestor::*[contains(@style, 'display: none;')])]/parent::div"));
        WebElement button = div.findElement(By.xpath("./div/button"));
        button.click();
        WebElement checkbox = div.findElement(By.xpath("./div[contains(@class,'open')]/ul/li/a/label[.=' "+value+"']/input"));
        if(!checkbox.isSelected())
        checkbox.click();
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));
        try{
            button.click();
        }catch (Exception e){
            new CssHelpers().HideElement(div.findElement(By.xpath("./div[contains(@class,'open')]")));
        }
    }

    public void deselectValueFromUnorderedListWithCheckbox(String label, String value) {
        WebElement div = driver.findElement(By.xpath("//*[not(contains(@style,'display: none;'))]//label[.='"+label+"' and not(ancestor::*[contains(@style, 'display: none;')])]/parent::div"));
        WebElement button = div.findElement(By.xpath("./div/button"));
        button.click();
        WebElement checkbox = div.findElement(By.xpath("./div[contains(@class,'open')]/ul/li/a/label[.=' "+value+"']/input"));
        if(checkbox.isSelected())
        checkbox.click();
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));
        try{
            button.click();
        }catch (Exception e){
            new CssHelpers().HideElement(div.findElement(By.xpath("./div[contains(@class,'open')]")));
        }
    }

    public String selectRandomValueFromUnorderedListWithCheckbox(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./div/button"));
        button.click();
        int size = div.findElements(By.xpath("./div[contains(@class,'open')]/ul/li/a/label/input")).size();
        int index = new Random().nextInt(size);
        System.out.println("size ==== " + size);
        if(index == 0)
            index = 1;
        WebElement checkbox = div.findElement(By.xpath("./div[contains(@class,'open')]/ul/li["+ index +"]/a/label/input"));
        String labelText = div.findElement(By.xpath("./div[contains(@class,'open')]/ul/li["+ index +"]/a/label")).getText();
        if(!checkbox.isSelected())
        checkbox.click();
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));
        try{
            button.click();
        }catch (Exception e){
            new CssHelpers().HideElement(div.findElement(By.xpath("./div[contains(@class,'open')]")));
        }
        return  labelText;
    }

    public void selectAllValueFromUnorderedListWithCheckbox(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./descendant::div/button"));
        button.click();
        List<WebElement> list = div.findElements(By.xpath("./descendant::div[contains(@class,'open')]/ul/li/a/label/input"));
        /* int index = new Random().nextInt(size);
        System.out.println("size ==== " + size);
        if(index == 0)
            index = 1;
        WebElement checkbox = div.findElement(By.xpath("./div[contains(@class,'open')]/ul/li["+ index +"]/a/label/input"));
        if(!checkbox.isSelected())
        checkbox.click();*/

        for(WebElement element : list)
        {
            if(!element.isSelected())
                element.click();
        }
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));
        try{
            button.click();
        }catch (Exception e){
            new CssHelpers().HideElement(div.findElement(By.xpath("./div[contains(@class,'open')]")));
        }
    }


    public void resetValuesFromUnorderedListWithCheckbox(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./div/button"));
        button.click();
        List <WebElement> checkboxes = div.findElements(By.xpath("./div[contains(@class,'open')]/ul/li/a/label/input"));
        for (WebElement element : checkboxes) {
            if (element.isSelected())
                element.click();
        }
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));
        try{
            button.click();
        }catch (Exception e){
            new CssHelpers().HideElement(div.findElement(By.xpath("./div[contains(@class,'open')]")));
        }
    }

    public void checkDisabledUnorderedListWithCheckbox(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./div/button"));
        Assert.assertTrue(button.getAttribute("disabled")!=null);
    }

    public void selectValueFromUnorderedListWithElement(String xpath, String value) {
        //div[@data-bind='visible: $root.CanViewResearchImprovementArea']/div/button

        List<WebElement> divs = driver.findElements(By.xpath(xpath));
        for(WebElement element:divs){
            element.click();
            driver.findElement(By.xpath("//ul[contains(@style,'block')]/li/a/label[.=' "+value+"']/input")).click();
            element.click();
        }
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));
    }

    public String getValueFromUnorderedListWithCheckbox(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./div/button/span"));
        return button.getText();
    }

    public List<String> getAllValuesFromUnorderedListWithCheckbox(WebDriver driver, WebElement optionlistdiv, WebElement button) {
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> optionList = new ArrayList <>();
        List<WebElement> inputs = optionlistdiv.findElements(By.tagName("input"));
//        for (WebElement input : inputs) {
//            js.executeScript("arguments[0].setAttribute('style', 'display:none;')",input);
//        }
        List<WebElement> options = optionlistdiv.findElements(By.tagName("label"));
        for (WebElement option : options) {
           optionList.add(option.getText().replace(",", "-"));
        }
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));

        button.click();
        return optionList;

    }


    public List<String> getAllValuesFromUnorderedListWithCheckbox(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
//        try{Thread.sleep(1000000);}catch (Exception e){}
        List<String> listString = new ArrayList<>();
        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@style,'block')]/li/a/label"));
        for (WebElement option : list) {
            listString.add(option.getAttribute("innerHTML"));
        }
        element.click();
        return listString;
    }

    public String getAllSelectedValuesFromUnorderedListWithCheckbox(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String  selected = element.findElement(By.xpath("./div/button")).getText();
        return selected;
    }

    public List<String> getAllLanguageValuesFromUnorderedListWithCheckbox(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
//        try{Thread.sleep(1000000);}catch (Exception e){}
        List<String> listString = new ArrayList<>();
//        try{Thread.sleep(5000);}catch (Exception e){};
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"jurisdiction-form-multiselect\"]/div/div/div/ul/li/a/label"));
        System.out.println(list.size());
        for (WebElement option : list) {
            listString.add(option.getText());
        }
        element.click();
        return listString;
    }

    public List<String> getAllLanguageValuesUsingLabelFromUnorderedListWithCheckbox(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./descendant::div/button"));
        button.click();
        List<WebElement> list = div.findElements(By.xpath("./descendant::div[contains(@class,'open')]/ul/li/a/label"));
        List<String> listString = new ArrayList<>();

        for (WebElement option : list) {
            listString.add(option.getText());
        }
        button.click();
        return listString;
    }


    public List<String> getAllSelectedLanguageValuesUsingLabelFromUnorderedList(String label) {
        WebElement div = driver.findElement(By.xpath("//form[not(contains(@style,'display: none;'))]//label[.='"+label+"']/parent::div"));
        WebElement button = div.findElement(By.xpath("./descendant::div/button"));
        button.click();
        List<WebElement> list = div.findElements(By.xpath("./descendant::div[contains(@class,'open')]/ul/li[@class='active']/a/label"));
        List<String> listString = new ArrayList<>();

        for (WebElement option : list) {
            listString.add(option.getText());
        }
        button.click();
        return listString;
    }

    public void assertDefaultValueFromUnorderedListWithCheckbox (WebDriver driver, final String value, WebElement form) {
        List<WebElement> options = form.findElements(By.xpath("//button/span[not(contains(@class, 'caret')) and not(contains(@aria-hidden, 'true'))]"));
        for (WebElement option : options){
            assertEquals(option.getText(), value);
        }
    }

    public void assertCheckedFromUnorderedListWithCheckbox (WebElement form, WebElement button) {
        button.click();
        List<WebElement> options = form.findElements(By.tagName("input"));
        for (WebElement option : options){
            assertFalse(option.isSelected());
        }
        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
            ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));

        button.click();
    }

    public void selectValueFromInput(WebElement optionlistdiv, WebElement button, final String value) {
        button.click();
        List<WebElement> options = optionlistdiv.findElements(By.tagName("input"));
        for (WebElement option : options) {
//            System.out.println(value + " ==--==  " + option.getAttribute("value"));
            if (value.replace(" ","").equalsIgnoreCase(option.getAttribute("value"))) {
                option.click();
                break;
            }
        }

        if(driver.findElements(By.xpath("//*[@class='dropdown-backdrop']")).size()>0)
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'display:none;')",driver.findElement(By.xpath("//*[@class='dropdown-backdrop']")));

        button.click();
    }
}
