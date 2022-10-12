package elements.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private String domen = "https://qa-scooter.praktikum-services.ru/";
    public void openDomen() {  //Открываем сайт
        driver.get(domen);
    }

    public void scrollToElement(By element) { //скроллим до необходимого элемента
        WebElement desiredElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", desiredElement);
    }

    public void standBy(By element) { //Ожидание
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void clickOnQuestionButton(By button) {
        standBy(button);
        scrollToElement(button);
        driver.findElement(button).click();
    }
}
