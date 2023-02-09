import Resources.InitializeDriver;
import org.junit.After;
import page_object.LoginPage;
import page_object.RegisterPage;
import Resources.UserAPI;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.MainPage;
import org.junit.Test;

public class RegistrationTest extends InitializeDriver {



    @Test
    @DisplayName("Сценарий успешной регистрации")
    @Description("После успешного завершения, тестовый пользователь удаляется через API")
    public void registrationFlow() throws InterruptedException {
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем на кнопку "Личный кабинет
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.regLinkButtonClick(); //Нажимаем на слово "Зарегистрироваться"
        RegisterPage registerPage = new RegisterPage(driver); //Создаём объект страницы регистрации
        //Заполняем поля
        registerPage.setRegisterField(UserAPI.testUserName,UserAPI.testUserEmail,UserAPI.testUserPassword);
        registerPage.regButtonClick();//Нажимаем на кнопку "Заргеистрироваться"
        //При успехе должно перекинуть на форму логина, ожидаем появления кнопки "Войти"
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(text(),'Войти')]")));
        //Сравниваем текущий URL с адресом логина
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login",driver.getCurrentUrl());

        //Удаляем тестового пользователя
        UserAPI.deleteUser(UserAPI.testUserEmail,UserAPI.testUserPassword);
    }

    @Test
    @DisplayName("Сценарий провала регистрации из за короткого пароля")
    @Description("Минимальное значение пароля - 6 символов")
    public void registrationFailWithShortPassword() throws InterruptedException {
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.lkButtonClick(); //Нажимаем на кнопку "Личный кабинет
        LoginPage loginPage = new LoginPage(driver); //Создаём объект страницы логина
        loginPage.regLinkButtonClick(); //Нажимаем на слово "Зарегистрироваться"
        RegisterPage registerPage = new RegisterPage(driver); //Создаём объект страницы регистрации
        //Заполняем поля
        registerPage.setRegisterField(UserAPI.testUserName,UserAPI.testUserEmail,"12345");
        registerPage.regButtonClick();//Нажимаем на кнопку "Заргеистрироваться"
        //При коротком пароле должна отобразиться ошибка, ждём её
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//p[contains(text(),'Некорректный пароль')]")));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
