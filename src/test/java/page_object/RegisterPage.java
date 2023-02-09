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
    private By nameRegField = By.xpath(".//label[contains(text(),'Имя')]/../input");

    //Поле "Email" на панели "Регистрация"
    private By emailRegField = By.xpath(".//label[contains(text(),'Email')]/../input");

    //Поле "Пароль" на панели "Регистрация"
    private By passwordRegField = By.xpath(".//label[contains(text(),'Пароль')]/../input");

    //Кнопка "Заргистрироваться" на панели "Регистрация"
    private By regButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");

    //Кнопка "Войти" на странице регистрации
    private By logButton = By.xpath(".//a[contains(text(),'Войти')]");
    
    //Метод заполнения полей
    public void  setRegisterField(String nameSet, String emailSet, String password) {
        driver.findElement(nameRegField).sendKeys(nameSet); //Введи имя
        driver.findElement(emailRegField).sendKeys(emailSet); //Введи Email
        driver.findElement(passwordRegField).sendKeys(password); //Введи пароль
    }

    public void  regButtonClick(){
        WebElement element = driver.findElement(regButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(regButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(regButton).click(); //Нажми на элемент
    }

    public void  logButtonClick(){
        WebElement element = driver.findElement(logButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(logButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(logButton).click(); //Нажми на элемент
    }
}
