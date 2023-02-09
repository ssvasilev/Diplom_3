import Resources.InitializeDriver;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import Resources.UserAPI;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.ForgotPasswordPage;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;

import static org.openqa.selenium.By.xpath;

public class LoginTest extends  InitializeDriver{

    @Before
    public void initialize() {

        //Создаём тестового пользователя
        UserAPI.createUser(UserAPI.testUserEmail, UserAPI.testUserName, UserAPI.testUserPassword);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.loginButtonMainPageClick();
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.setLoginField(UserAPI.testUserEmail,UserAPI.testUserPassword); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled()); //Убедись, что кнопка доступна
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginLkPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick();
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.setLoginField(UserAPI.testUserEmail,UserAPI.testUserPassword); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled()); //Убедись, что кнопка доступна
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
        loginPage.setLoginField(UserAPI.testUserEmail,UserAPI.testUserPassword); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled()); //Убедись, что кнопка доступна
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем на кнопку "Личный кабинет
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.forgotPasswordButtonClick(); //Нажимаем на кнопку "Всстановить пароль"
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver); //Создаём объект страницы восстновления пароля
        forgotPasswordPage.LoginButtonClick(); //Нажимаем на кнопку "Войти"
        loginPage.setLoginField(UserAPI.testUserEmail,UserAPI.testUserPassword); //Заполняем поля
        loginPage.loginButtonClick();
        //После успешного логина должно перенести на главную страницу и появиться кнопка "Оформить заказ"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled()); //Убедись, что кнопка доступна
    }

     @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
        //Удали тестового пользователя
        UserAPI.deleteUser(UserAPI.testUserEmail,UserAPI.testUserPassword);
    }

}
