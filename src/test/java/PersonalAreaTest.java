import Resources.UserAPI;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;

public class PersonalAreaTest {

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
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick();
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.setLoginField("autotestvasilevss@yandex.ru","q1w2e3r4t5"); //Заполняем поля
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
        UserAPI.deleteUser("autotestvasilevss@yandex.ru","q1w2e3r4t5");
    }

}
