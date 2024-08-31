package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    private final WebDriver driver;
    //локатор для поля имя
    private final By nameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");
    //локатор для поля фамилия
    private final By familyNameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");
    //локатор для поля Адрес: куда привезти заказ
    private final By addressField = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");
    //Локатор для поля Станция метро
    private final By subwayStationField = By.className("select-search__input");
    //Локатор выбора станции из выпадающего списка
    private final By varsSubwayStationField = By.className("select-search__select");
    //Локатор для поля телефон
    private final By phoneField = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");
    //Локатор для кнопки Далее
    private final By buttonFurther = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    // локатор для поля про аренду "Когда привезти самокат"
    private final By whenDeliverScooterField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //локатор для поля Срок аренды сутки
    private final By periodForRentOneDay = By.xpath(".//*[@class='Dropdown-option'][1]");
    //локатор для поля Срок аренды 2 суток
    private final By periodForRentTwoDay = By.xpath(".//*[@class='Dropdown-option'][2]");
    //локатор для поля Срок аренды 3 суток
    private final By periodForRentThreeDays = By.xpath(".//*[@class='Dropdown-option'][3]");
    //локатор для поля Срок аренды 4 суток
    private final By periodForRentFourDays = By.xpath(".//*[@class='Dropdown-option'][4]");
    //локатор для поля Срок аренды 5 суток
    private final By periodForRentFiveDays = By.xpath(".//*[@class='Dropdown-option'][5]");
    //локатор для поля Срок аренды 6 суток
    private final By periodForRentSixDays = By.xpath(".//*[@class='Dropdown-option'][6]");
    //локатор для поля Срок аренды 7 суток
    private final By periodForRentSevenDays = By.xpath(".//*[@class='Dropdown-option'][7]");
    //локатор поля Срок аренды
    private final By periodForRentField = By.className("Dropdown-control");
    //локатор для  Цвет самоката Черный жемчуг
    private final By colourScooterBlackPearl = By.xpath(".//input[@id='black']");
    //локатор для ъЦвет самоката Серая безысходность
    private final By colourScooterGreyHopelessness = By.xpath(".//input[@id='grey']");
    //Локатор для поля Комментарий для курьера
    private final By commentFotCourierField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор для кнопки Заказать
    private final By buttonOrder = By.xpath(".//button[@Class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Локатор для всплывающего окна "Хотите оформить заказ?"
    private final By agreeOrderPopup = By.xpath(".//div[text()='Хотите оформить заказ?']");
    //Локатор для кнопки "Да" в окне "Хотите оформить заказ?"
    private final By yesButton = By.xpath(".//button[text()='Да']");
    //локатор для всплывающего окна "Заказ оформлен"
    private final By orderIsProcessed = By.xpath(".//div[text()='Заказ оформлен']");
    //локатор для ошибки поля Имя
    private final By nameFieldMistake = By.cssSelector("div#root div.Order_Form__17u6u > div:nth-child(1) > div");
    //локатор для ошибки поля Фамилия
    private final By familyNameFieldFieldMistake = By.cssSelector("div#root div.Order_Form__17u6u > div:nth-child(2) > div");
    //локатор для ошибки поля Адрес
    private final By addressFieldFieldMistake = By.cssSelector("div#root div.Order_Form__17u6u > div:nth-child(3) > div");
    //локатор для ошибки поля Станция метро
    private final By subwayStationFieldMistake = By.cssSelector("div#root div.Order_MetroError__1BtZb");
    //локатор для ошибки поля Телефон
    private final By phoneFieldMistake = By.cssSelector("div#root div.Order_Form__17u6u > div:nth-child(5) > div");
    public PageObject (WebDriver driver) {
        this.driver = driver;
    }
    //метод для ввода имени в поле "Имя"
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //метод для ввода фамилии в поле "Фамилия"
    public void enterFamilyName(String familyName) {
        driver.findElement(familyNameField).sendKeys(familyName);
    }
    //метод для ввода адреса в поле "Адрес"
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //метод для выбора станции в поле "Станция метро"
    public void chooseSubwayStation(String subwayStation) {
        driver.findElement(subwayStationField).click();
        driver.findElement(subwayStationField).sendKeys(subwayStation);
        driver.findElement(varsSubwayStationField).isDisplayed();
        driver.findElement(subwayStationField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    //Метод для ввода телефона в поле "Телефон"
    public void enterPhoneNumber(String phoneNumber) {

        driver.findElement(phoneField).sendKeys(phoneNumber);
    }
    //Метод заполнения всех полей формы
    public void fillFieldsInFormOrder(String name, String familyName, String address, String subwayStation, String phoneNumber) {
        enterName(name);
        enterFamilyName(familyName);
        enterAddress(address);
        chooseSubwayStation(subwayStation);
        enterPhoneNumber(phoneNumber);
    }

    //Метод клика по кнопке Далее
    public void clickButtonFurther() {
        driver.findElement(buttonFurther).click();

    }
    //метод получения текста из ошибки поля Имя формы "Для кого самокат"
    public String getTextFromNameFieldMistake() {
        return driver.findElement(nameFieldMistake).getText();
    }
    //метод получения текста из ошибки поля Фамилия формы "Для кого самокат"
    public String getTextFromFamilyNameFieldMistake() {
        return driver.findElement(familyNameFieldFieldMistake).getText();
    }
    //метод получения текста из ошибки поля Адрес формы "Для кого самокат"
    public String getTextFromAddressFieldMistake() {
        return driver.findElement(addressFieldFieldMistake).getText();
    }
    //метод получения текста из ошибки поля Станция Метро формы "Для кого самокат"
    public String getTextFromSubwayStationFieldMistake() {
        return driver.findElement(subwayStationFieldMistake).getText();
    }
    //метод получения текста из ошибки поля Телефон формы "Для кого самокат"
    public String getTextFromPhoneFieldMistake() {
        return driver.findElement(phoneFieldMistake).getText();
    }
    //проверка, что текстовое описание ошибки появилось

    //метод для выбора даты в поле Когда привезти самокат
    public void enterDate(String newDate) {
        driver.findElement(whenDeliverScooterField).sendKeys(newDate);
        driver.findElement(whenDeliverScooterField).sendKeys(Keys.ENTER);
    }
    //метод для выбора количества дней аренды
    public void chooseRentPeriod(int days) {
        driver.findElement(periodForRentField).click();
        if (days == 1) {
            driver.findElement(periodForRentOneDay).click();
        } else if (days == 2) {
            driver.findElement(periodForRentTwoDay).click();
        } else if (days == 3) {
            driver.findElement(periodForRentThreeDays).click();
        } else if (days == 4) {
            driver.findElement(periodForRentFourDays).click();
        } else if (days == 5) {
            driver.findElement(periodForRentFiveDays).click();
        } else if (days == 6) {
            driver.findElement(periodForRentSixDays).click();
        } else if (days == 7) {
            driver.findElement(periodForRentSevenDays).click();
        }
    }
    // метод выбора самоката в цвете Черный жемчуг
    public void chooseBlackPearlColour() {

        driver.findElement(colourScooterBlackPearl).click();
    }
    // метод выбора самоката в цвете Серая безысходность
    public void chooseGreyHopelessnessColour() {

        driver.findElement(colourScooterGreyHopelessness).click();
    }
    //метод выбора цвета самоката
    public void chooseScooterColour(String scooterColour){
        if (scooterColour.equals("черный жемчуг")) {
            chooseBlackPearlColour();
        } else if (scooterColour.equals("серая безысходность")) {
            chooseGreyHopelessnessColour();
        }
    }
    //метод заполнения поля Комментарий для курьера
    public void enterCommentForCourier (String newComment) {
        driver.findElement(commentFotCourierField).sendKeys(newComment);
    }
    //объединенный метод заполнения полей формы окна Про Аренду
    public void fillFieldsInFormAboutRent(String newDate, int days, String scooterColour, String newComment) {
        enterDate(newDate);
        chooseRentPeriod(days);
        chooseScooterColour(scooterColour);
        enterCommentForCourier(newComment);
    }
    //метод для клика по кнопке Заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    //метод ожидания окна и клика по кнопке Да в попапе согласия с заказом
    public void clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(15)) // Используйте Duration здесь
                .until(ExpectedConditions.visibilityOfElementLocated(agreeOrderPopup));
        driver.findElement(yesButton).click();
    }

    //метод проверки окно Заказ оформлен отображено на экране
    public boolean orderIsProcessedDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(15)) // Используйте Duration здесь
                .until(ExpectedConditions.visibilityOfElementLocated(orderIsProcessed));
        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}