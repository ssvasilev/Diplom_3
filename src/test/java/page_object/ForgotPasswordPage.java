package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

    private static WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    //Кнопка "Войти"
    private By loginButton = By.xpath(".//a[contains(text(),'Войти')]");

    //Клик по кнопке "Войти"
    public void LoginButtonClick(){
        WebElement element = driver.findElement(loginButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(loginButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(loginButton).click(); //Нажми на элемент
    }

}
