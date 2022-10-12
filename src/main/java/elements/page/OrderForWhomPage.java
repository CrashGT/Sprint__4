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

    public By nameOrder = By.xpath(".//input[@placeholder='* Имя']"); //Поле Имя
    public By surnameOrder = By.xpath(".//input[@placeholder='* Фамилия']"); //Поле Фамилия
    public By addressOrder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле Адрес
    public By stationOrder = By.xpath(".//input[@placeholder='* Станция метро']"); //Поле Метро
    public By telephoneOrder = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Поле телефон
    public By nextOrderButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка Далее
    public By whenOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //Дата заказа
    public By dateOrder = By.xpath(".//div[contains(@class, 'react-datepicker__day') and (@tabindex='0')]"); //Активная дата в календаре
    public By dateNextMonthOrder = By.xpath(".//button[@aria-label ='Next Month']"); //Переход на следующий месяц
    public By periodOrder = By.className("Dropdown-placeholder"); //Срок аренды
    public By commentOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public By yesButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM' and (text()='Да'))]"); //Да в всплывающем диалоге
    public By finishModalWindow = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']"); //Заказ оформлен


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

    public void setField(By field, String str) { //метод заполнения поля
        driver.findElement(field).sendKeys(str);
    }

    public void setStationOrder(By station) {   //метод выбора станции метро
        driver.findElement(stationOrder).click();
        driver.findElement(station).click();
    }

    public void setOrderForWhom(String name, String surname, String address, String number) {
        setField(nameOrder, name); //Заполняем Имя
        setField(surnameOrder, surname); // Заполняем Фамилию
        setField(addressOrder, address); //Заполняем Адресс
        setField(telephoneOrder, number); //Заполняем Номер
    }

    public void clickNextOrderButton() {    //Нажимаем на кнопку Далее
        driver.findElement(nextOrderButton).click();
    }

    public void setNextMonthDateButton(int month) {  //Выбираем n-ый месяц
        driver.findElement(whenOrder).click();
        for (int j = 0; j < month; j++) {
            driver.findElement(dateNextMonthOrder).click();
        }
        driver.findElement(dateOrder).click();
    }

    public void setPeriod(int period) { //Выбираем период аренды
        driver.findElement(periodOrder).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option'][" + period + "]")).click();
    }

    public void setColorScooter(By color) { //Выбираем цвета самоката
        driver.findElement(color).click();
    }

    public void setComment(String comment) { //Пишем комментарий
        driver.findElement(commentOrder).sendKeys(comment);
    }

    public void yesButtonClick() {  //Да, хотим оформить
        driver.findElement(yesButton).click();
    }

    public String getTextOfWindowOfSuccessfulOrder() { //Ищем текст успешного завершения
        return driver.findElement(finishModalWindow).getText();
    }
}
