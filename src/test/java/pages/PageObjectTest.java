package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class PageObjectTest {

    private WebDriver driver;
    private final String orderButton;
    private final String userName;
    private final String userSurname;
    private final String dateRental;
    private final String userComment;
    private final String scooterColor;

    public PageObjectTest(String orderButton, String userName, String userSurname, String dateRental, String userComment, String scooterColor) {
        this.orderButton = orderButton;
        this.userName = userName;
        this.userSurname = userSurname;
        this.dateRental = dateRental;
        this.userComment = userComment;
        this.scooterColor = scooterColor;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Верхняя кнопка", "Таняодин", "Таняфамил", "26.08.2024", "Домофон не работает", "Черный"},
                {"Нижняя кнопка", "Танядва", "Ленафамил", "24.08.2024", "" , "Серый"},
        };
    }

        @Test
    public void scooterOrderTest() {
        String browser = System.getProperty("browser", "chrome");
        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnOrderButton(orderButton);

        PageObject orderPage = new PageObject(driver);
        orderPage.enteringPersonalUserData(userName, userSurname, "Адрес адрес22", "78787879999");
        orderPage.enterFieldsForRent(dateRental, scooterColor, userComment);
        orderPage.clickYes();

        Assert.assertEquals("Текст 'Заказ оформлен' на странице не найден.", 3, orderPage.getCountTitleOfSuccessfulOrder());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
