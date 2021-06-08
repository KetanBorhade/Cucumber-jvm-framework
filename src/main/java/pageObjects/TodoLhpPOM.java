package pageObjects;

import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class TodoLhpPOM {

    WebDriver driver;
    public TodoLhpPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public String getTodoPageTitle() {
        return driver.getTitle();
    }

    public void EnterValueToList(String listValue){
        String xPath = "//input[@class='new-todo']";
        driver.findElement(By.xpath(xPath)).isDisplayed();
        driver.findElement(By.xpath(xPath)).sendKeys(listValue);
        driver.findElement(By.xpath(xPath)).sendKeys(Keys.ENTER);
    }

    public void SelectLink(String linkValue){
        String xPath = "//ul[@class='filters']//a[contains(text(),'"+linkValue+"')]";
        driver.findElement(By.xpath(xPath)).isDisplayed();
        driver.findElement(By.xpath(xPath)).click();

    }

    public void RemoveElementFromList(String value){
        String xPath = "//label[text()='"+value+"']//following-sibling::button";
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(xPath));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath(xPath))).click().build().perform();
    }

    public void list_values_are_as_followed(List<String> options){

        for (String option : options) {
            option_is_displayed_in_list(option);
        }
    }

    public void option_is_displayed_in_list(String option){

        String xPath = "//label[contains(text(),'"+option+"')]";
        driver.findElement(By.xpath(xPath)).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath(xPath)).isDisplayed());

    }

    public void option_is_not_displayed_in_list(String option){

        String xPath = "//label[contains(text(),'"+option+"')]";

        try {

            Assert.assertFalse(driver.findElement(By.xpath(xPath)).isDisplayed());

        }
        catch (Exception e) {}

    }

    public void selectItemFromTodoList(String option) {
        String xPath = "//label[text()='" + option + "']//preceding::input[1]";
        driver.findElement(By.xpath(xPath)).isDisplayed();
        driver.findElement(By.xpath(xPath)).click();
        driver.findElement(By.xpath(xPath)).isSelected();

    }

    public void clickOnClearButton(String button) {
        String xPath = "//button[contains(text(),'"+button+"')]";
        driver.findElement(By.xpath(xPath)).isDisplayed();
        driver.findElement(By.xpath(xPath)).click();
    }
}
