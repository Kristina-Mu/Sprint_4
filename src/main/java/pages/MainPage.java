package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    //верхняя кнопка "Заказать"
    private By upperOrderButton = By.className("Button_Button__ra12g");

    //нижняя кнопка "Заказать"
    private By underOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //клик по стрелке с текстом из параметра
    public void clickOnTheArrow(String arrowText) {
        WebElement element = driver.findElement(By.xpath(".//div[text() = '" + arrowText + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

    //получение текста под стрелкой с текстом из параметра
    public String getTextUnderArrow(String arrowText) {
        clickOnTheArrow(arrowText);
        return driver.findElement(By.xpath(".//div[text() = '" + arrowText + "']/parent::div/parent::div//p")).getText();
    }

    //Прокрутка до нижней кнопки заказа и клик на нее
    public void clickOnOrderButton(String orderButton) {
        if (orderButton.equals("Нижняя кнопка")) {
            WebElement element = driver.findElement(underOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

            element.click();
        } else {
            driver.findElement(upperOrderButton).click();
        }
    }

}