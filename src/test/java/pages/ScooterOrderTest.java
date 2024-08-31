package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends base.BaseTest {

    private final String buttonLocation;
    private final String name;
    private final String familyName;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String newDate;
    private final int days;
    private final String scooterColour;
    private final String newComment;

    public ScooterOrderTest(String buttonLocation, String name, String familyName, String address,
                            String subwayStation, String phoneNumber, String newDate, int days,
                            String scooterColour, String newComment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.familyName = familyName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.newDate = newDate;
        this.days = days;
        this.scooterColour = scooterColour;
        this.newComment = newComment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestOrderData() {
        return new Object[][]{
                {"up", "Таня", "Иванова", "Маршала, 18", "Охотный ряд", "+74953333333", "20.09.2024", 5, "серая безысходность", "Напишите перед звонком в дверь"},
                {"middle", "Лена", "Петрова", "Хачатурян 20", "Сходнинская", "+74952222222", "28.09.2024", 1, "черный жемчуг", "Напишите перед звонком в дверь, спасибо"},
        };
    }

    @Before
    public void setUp() {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // создаю объект класса главной страницы
        MainPage obMainPage = new MainPage(driver);
        // открываю главную страницу
        obMainPage.openScooterPage();
        // если кнопка согласия с куками появилась, нажимаю на неё
        obMainPage.acceptCookies();
    }

    @Test
    public void isPopupAppeared() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // создаю объект класса главной страницы
        MainPage obMainPage = new MainPage(driver);
        // выбираю на какую кнопку "Заказать" нажать - на верхнюю или в центре страницы
        obMainPage.chooseOrderButtonAndClick(buttonLocation);
        // создаю объект страницы OrderPage
        PageObject obPageObject = new PageObject(driver);
        // заполняю поля формы
        obPageObject.fillFieldsInFormOrder(name, familyName, address, subwayStation, phoneNumber);
        // нажимаю на кнопку Далее
        obPageObject.clickButtonFurther();
        // заполняю поля формы про аренду
        obPageObject.fillFieldsInFormAboutRent(newDate, days, scooterColour, newComment);
        // нажимаю на кнопку Заказать
        obPageObject.clickButtonOrder();
        // нажимаю на кнопку "Да" в окне подтверждения заказа
        obPageObject.clickYesButton();
        // проверяю, что окно "Оформить заказ" отобразилось на экране
        obPageObject.orderIsProcessedDisplayed();
    }

    // закрываю браузер
    @After
    public void tearDown() {
        driver.quit();
    }
}
