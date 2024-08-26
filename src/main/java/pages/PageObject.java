package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageObject {

    private WebDriver driver;

    //поле "Имя"
    private By name = By.xpath(".//input[@placeholder='* Имя']");

    //поле "Фамилия"
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле "Адрес"
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле "Метро"
    private By underground = By.xpath(".//input[@placeholder='* Станция метро']");

    //поле "Телефон"
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private By onward = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    //поле "Дата, когда мне привезут самокат"
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле "Срок аренды"
    private By rentalPeriod = By.className("Dropdown-placeholder");
    private By rentOneDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    //иконки "Цвет самоката"
    private By blackPearl = By.id("black");
    private By greyHopelessness = By.id("grey");

    //поле "Комментарий для курьера"
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка "Заказать"
    private By order = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //кнопка "Да" в окне "Вы хотите оформить заказ?"
    private By yes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //поле заголовка успешного оформления заказа
    private By titleOfSuccessfulOrder = By.xpath(".//div[text()='Заказ оформлен']");

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    //Ввод имени
    public void setUserName(String userName){
        driver.findElement(name).sendKeys(userName);
    }

    //Ввод фамилии
    public void setUserSurname(String userSurname){
        driver.findElement(surname).sendKeys(userSurname);
    }

    //Ввод адреса
    public void setUserAddress(String userAddress){
        driver.findElement(address).sendKeys(userAddress);
    }

    //Выбор первой станции метро
    public void setUserUnderground(){
        driver.findElement(underground).click();
        driver.findElement(By.className("select-search__select")).findElement(By.xpath("./ul/li[1]")).click();
    }

    //Ввод номера телефона
    public void setUserPhoneNumber(String userPhoneNumber){
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
    }

    //Нажимаем кнопку "Далее"
    public void clickOnward(){
        driver.findElement(onward).click();
    }

    //Ввод всех данных о пользователе
    public void enteringPersonalUserData(String userName, String userSurname,
                                         String userAddress, String userPhoneNumber) {
        setUserName(userName);
        setUserSurname(userSurname);
        setUserAddress(userAddress);
        setUserUnderground();
        setUserPhoneNumber(userPhoneNumber);
        clickOnward();
    }

    //Ввод даты аренды
    public void setDateRental(String dateRental){
        driver.findElement(date).sendKeys(dateRental);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    //Выбор суточной аренды
    public void setRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentOneDay).click();
    }

    //Выбор цвета самоката
    public void colorSelection(String scooterColor){
        if(scooterColor.equals("Черный")){
            driver.findElement(blackPearl).click();
        }else {
            driver.findElement(greyHopelessness).click();
        }

    }

    //Пишем комментарий для курьера
    public void setUserComment(String userComment){
        driver.findElement(comment).sendKeys(userComment);
    }

    //Нажимаем "Заказать"
    public void clickOrder(){
        driver.findElement(order).click();
    }

    //Заполнение формы аренды самоката
    public void enterFieldsForRent(String dateRental,String scooterColor, String userComment){
        setDateRental(dateRental);
        setRentalPeriod();
        colorSelection(scooterColor);
        setUserComment(userComment);
        clickOrder();
    }

    //Нажимаем "Да"
    public void clickYes(){
        driver.findElement(yes).click();
    }

    //Получаем количество заголовков "Заказ оформлен"
    public int getCountTitleOfSuccessfulOrder(){
        return driver.findElements(titleOfSuccessfulOrder).size();
    }

}