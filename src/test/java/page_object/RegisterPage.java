package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле "Имя" на панели "Регистрация"
    private By NameRegField = By.xpath(".//label[contains(text(),'Имя')]/../input");

    //Поле "Имя" на панели "Регистрация"
    private By EmailRegField = By.xpath(".//label[contains(text(),'Email')]/../input");

    //Поле "Имя" на панели "Регистрация"
    private By PasswordRegField = By.xpath(".//label[contains(text(),'Пароль')]/../input");

    //Кнопка "Заргистрироваться" на панели "Регистрация"
    private By RegButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");

    
    //Метод заполнения полей
    public void  setRegisterField(String nameSet, String emailSet, String password) {
        driver.findElement(NameRegField).sendKeys(nameSet); //Введи имя
        driver.findElement(EmailRegField).sendKeys(emailSet); //Введи Email
        driver.findElement(PasswordRegField).sendKeys(password); //Введи пароль
    }

    public void  regButtonClick(){
        WebElement element = driver.findElement(RegButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(RegButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(RegButton).click(); //Нажми на элемент
    }
}
