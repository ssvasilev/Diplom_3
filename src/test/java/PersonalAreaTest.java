import Resources.InitializeDriver;
import Resources.UserAPI;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;

public class PersonalAreaTest extends InitializeDriver {


    @Before
    public void initialize() {

        //Создаём тестового пользователя
        UserAPI.createUser(UserAPI.testUserEmail, UserAPI.testUserName, UserAPI.testUserPassword);
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick();
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.setLoginField(UserAPI.testUserEmail,UserAPI.testUserPassword); //Заполняем поля
        loginPage.loginButtonClick();


    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void loginMainPage(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем кнопку "Личный кабинет"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Сохранить')]")));
        //Сравниваем текущий URL с адресом личного кабинета
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile",driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор»")
    public void fromLkToConstructor(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем кнопку "Личный кабинет"
        ProfilePage profilePage = new ProfilePage(driver); //Создаём объект страницы личного кабинета
        profilePage.constructorButtonClick(); //Нажимаем на кнопку Конструктор
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/",driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логитип Stellar Burgers")
    public void fromLkToConstructorLogo(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем кнопку "Личный кабинет"
        ProfilePage profilePage = new ProfilePage(driver); //Создаём объект страницы личного кабинета
        profilePage.logoButtonClick(); //Нажимаем на кнопку Конструктор
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Оформить заказ')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/",driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете.")
    public void logOutfromLk(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем кнопку "Личный кабинет"
        ProfilePage profilePage = new ProfilePage(driver); //Создаём объект страницы личного кабинета
        WebElement dynamicElementLogout = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Выход')]")));
        profilePage.logoutButtonClick(); //Нажимаем на кнопку Выход
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Войти')]")));
        //Сравниваем текущий URL с адресом главной страницы
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login",driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
        //Удали тестового пользователя
        UserAPI.deleteUser(UserAPI.testUserEmail,UserAPI.testUserPassword);
    }

}
