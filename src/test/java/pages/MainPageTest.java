package pages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MainPageTest extends base.BaseTest {

    private final int listIndex;
    private final String textAnswerExpected;

    public MainPageTest(int listIndex, String textAnswerExpected) {
        this.listIndex = listIndex;
        this.textAnswerExpected = textAnswerExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setUp() {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void IsEqualsTextWhenClickedButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        MainPage obMainPage = new MainPage(driver);
        obMainPage.openScooterPage();
        obMainPage.acceptCookies();

        // Явное ожидание перед нажатием на кнопку
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@class='Button_Button__ra12g']")));
        obMainPage.clickButtonsImportantQuestions(listIndex);

        String actualTextAnswer = obMainPage.getAnswersImportantQuestions(listIndex);
        assertEquals("Текст ответа не совпадает. Вопрос: [" + listIndex + "].", textAnswerExpected, actualTextAnswer);
    }
}
