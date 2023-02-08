import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import Resources.UserAPI;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.ForgotPassword;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initialize() {

        //Создаём тестового пользователя
        UserAPI.createUser("autotestvasilevss@yandex.ru", "Сергей", "q1w2e3r4t5");
        // создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переходим на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.loginButtonMainPageClick();
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.setLoginField("autotestvasilevss@yandex.ru","q1w2e3r4t5"); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/",driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginLkPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick();
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.setLoginField("autotestvasilevss@yandex.ru","q1w2e3r4t5"); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/",driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем на кнопку "Личный кабинет
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.regLinkButtonClick(); //Нажимаем на слово "Зарегистрироваться"
        RegisterPage registerPage = new RegisterPage(driver); //Создаём объект страницы регистрации
        registerPage.logButtonClick();
        loginPage.setLoginField("autotestvasilevss@yandex.ru","q1w2e3r4t5"); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/",driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем на кнопку "Личный кабинет
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.forgotPasswordButtonClick(); //Нажимаем на кнопку "Всстановить пароль"
        ForgotPassword forgotPassword = new ForgotPassword(driver); //Создаём объект страницы восстновления пароля
        forgotPassword.LoginButtonClick(); //Нажимаем на кнопку "Войти"
        loginPage.setLoginField("autotestvasilevss@yandex.ru","q1w2e3r4t5"); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/",driver.getCurrentUrl());
    }

     @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
        //Удали тестового пользователя
        UserAPI.deleteUser("autotestvasilevss@yandex.ru","q1w2e3r4t5");
    }

}
