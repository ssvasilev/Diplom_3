package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {



    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Зарегистрироваться" на панели "Вход"
    private By regLinkButton = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");

    //Поле "Email" на панели "Вход"
    private By EmailRegField = By.xpath(".//label[contains(text(),'Email')]/../input");

    //Поле "Пароль" на панели "Вход"
    private By PasswordRegField = By.xpath(".//label[contains(text(),'Пароль')]/../input");

    //Кнопка "Войти"
    private By loginButton = By.xpath(".//button[contains(text(),'Войти')]");

    //Кнопка "Восстановить пароль"
    private By forgotPasswordButton = By.xpath(".//a[contains(text(),'Восстановить пароль')]");


    //public static By loingTitle = By.xpath(".//div[@class='Auth_login__3hAey']/h2");

    public void regLinkButtonClick() {
        WebElement element = driver.findElement(regLinkButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(regLinkButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(regLinkButton).click(); //Нажми на элемент
    }

    //Метод заполнения полей
    public void  setLoginField(String emailSet, String password) {
        driver.findElement(EmailRegField).sendKeys(emailSet); //Введи Email
        driver.findElement(PasswordRegField).sendKeys(password); //Введи пароль
    }

    //Клик по кнопке "Войти"
    public void loginButtonClick(){
        WebElement element = driver.findElement(loginButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(loginButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(loginButton).click(); //Нажми на элемент
    }

    //Клик по кнопке "Восстановить пароль"
    public void forgotPasswordButtonClick(){
        WebElement element = driver.findElement(forgotPasswordButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(forgotPasswordButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(forgotPasswordButton).click(); //Нажми на элемент
    }
}
