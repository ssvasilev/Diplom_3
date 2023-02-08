import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.MainPage;

public class SectionsTest {

    private WebDriver driver;

    @Before
    public void initialize() {
        // создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переходим на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void sectionBun(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.sectionIngredientsButtonClick(); //Нажимаем на кнопку "Начинки", что бы сделать кнопку "Булки" активной
        mainPage.sectionBunButtonClick(); //Нажимаем на кнопку "Булки"
        //Ждём, пока появится раздел Булки
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//h2[contains(text(),'Булки')]")));
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void sectionSauce(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.sectionSauceButtonClick(); //Нажимаем на кнопку "Соусы"
        //Ждём, пока появится раздел Соусы
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//h2[contains(text(),'Булки')]")));
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void sectionIngredients(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.sectionIngredientsButtonClick(); //Нажимаем на кнопку "Начинки"
        //Ждём, пока появится раздел начинки
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//h2[contains(text(),'Булки')]")));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
