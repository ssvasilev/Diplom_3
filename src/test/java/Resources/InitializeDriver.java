package Resources;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitializeDriver {

    public WebDriver driver;

    @Before
    public void initializeDriver() {

        // создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        // переходим на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");

    }
}
