import elements.page.MainPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestQuestionsAboutImportantTexts {
    public static By[] questionLocator= {By.xpath(".//div[@aria-controls='accordion__panel-0']") , By.xpath(".//div[@aria-controls='accordion__panel-1']"), By.xpath(".//div[@aria-controls='accordion__panel-2']"), By.xpath(".//div[@aria-controls='accordion__panel-3']"), By.xpath(".//div[@aria-controls='accordion__panel-4']"), By.xpath(".//div[@aria-controls='accordion__panel-5']"), By.xpath(".//div[@aria-controls='accordion__panel-6']"), By.xpath(".//div[@aria-controls='accordion__panel-7']")};
    public static String[] questionText = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
    public static By[] textLocator = {By.id("accordion__panel-0"), By.id("accordion__panel-1"), By.id("accordion__panel-2"), By.id("accordion__panel-3"), By.id("accordion__panel-4"), By.id("accordion__panel-5"), By.id("accordion__panel-6"), By.id("accordion__panel-7")};
    private final By questionButton;
    private final String textQuestion;
    private final By locatorText;

    private WebDriver driver;

    public TestQuestionsAboutImportantTexts(By questionButton, String textQuestion, By locatorText) {
        this.questionButton = questionButton;
        this.textQuestion = textQuestion;
        this.locatorText = locatorText;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {questionLocator[0], questionText[0], textLocator[0]},
                {questionLocator[1], questionText[1], textLocator[1] },
                {questionLocator[2], questionText[2], textLocator[2] },
                {questionLocator[3], questionText[3], textLocator[3] },
                {questionLocator[4], questionText[4], textLocator[4] },
                {questionLocator[5], questionText[5], textLocator[5] },
                {questionLocator[6], questionText[6], textLocator[6] },
                {questionLocator[7], questionText[7], textLocator[7] },
        };
    }

    @Test
    public void QuestionsOne() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        mainPage.openDomen();
        mainPage.clickOnQuestionButton(questionButton);
        mainPage.standBy(locatorText);
        assertEquals(textQuestion, driver.findElement(locatorText).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
