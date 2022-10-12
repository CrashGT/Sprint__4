package elements.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderForWhomPage {
    private WebDriver driver;

    public OrderForWhomPage(WebDriver driver) {
        this.driver = driver;
    }

    public By nameOrder = By.xpath(".//input[@placeholder='* Имя']"); 
    public By surnameOrder = By.xpath(".//input[@placeholder='* Фамилия']"); 
    public By addressOrder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); 
    public By stationOrder = By.xpath(".//input[@placeholder='* Станция метро']"); 
    public By telephoneOrder = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); 
    public By nextOrderButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"); 
    public By whenOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); 
    public By dateOrder = By.xpath(".//div[contains(@class, 'react-datepicker__day') and (@tabindex='0')]"); 
    public By dateNextMonthOrder = By.xpath(".//button[@aria-label ='Next Month']"); 
    public By periodOrder = By.className("Dropdown-placeholder"); 
    public By commentOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public By yesButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and (text()='Да'))]"); 
    public By finishModalWindow = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']"); 


    public void clickOnOrderButton(By buttonOrder) {
        standBy(buttonOrder);
        scrollToElement(buttonOrder);
        driver.findElement(buttonOrder).click();
    }

    private void standBy(By element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    private void scrollToElement(By button) {
        WebElement desiredElement = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", desiredElement);
    }

    public void setField(By field, String str) { 
        driver.findElement(field).sendKeys(str);
    }

    public void setStationOrder(By station) {   
        driver.findElement(stationOrder).click();
        driver.findElement(station).click();
    }

    public void setOrderForWhom(String name, String surname, String address, String number) {
        setField(nameOrder, name); 
        setField(surnameOrder, surname); 
        setField(addressOrder, address); 
        setField(telephoneOrder, number); 
    }

    public void clickNextOrderButton() {    
        driver.findElement(nextOrderButton).click();
    }

    public void setNextMonthDateButton(int month) {  
        driver.findElement(whenOrder).click();
        for (int j = 0; j < month; j++) {
            driver.findElement(dateNextMonthOrder).click();
        }
        driver.findElement(dateOrder).click();
    }

    public void setPeriod(int period) { 
        driver.findElement(periodOrder).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option'][" + period + "]")).click();
    }

    public void setColorScooter(By color) { 
        driver.findElement(color).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentOrder).sendKeys(comment);
    }

    public void yesButtonClick() {  
        driver.findElement(yesButton).click();
    }

    public String getTextOfWindowOfSuccessfulOrder() { 
        return driver.findElement(finishModalWindow).getText();
    }
}
