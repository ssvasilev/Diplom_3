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

    private By loginButton = By.xpath(".//button[contains(text(),'Войти')]");

    //public static By loingTitle = By.xpath(".//div[@class='Auth_login__3hAey']/h2");

    public void regLinkButtonClick() {
        WebElement element = driver.findElement(regLinkButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(regLinkButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(regLinkButton).click(); //Нажми на элемент
    }

}
