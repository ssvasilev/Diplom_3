package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//p[contains(text(),'Конструктор')]");

    //Кнопка Логитип Stellar Burger
    private By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    //Кнопка "Выход" в личном кабинете
    private By logoutButton = By.xpath(".//button[contains(text(),'Выход')]");

    public void constructorButtonClick(){
        WebElement element = driver.findElement(constructorButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(constructorButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(constructorButton).click(); //Нажми на элемент
    }

    public void logoButtonClick(){
        WebElement element = driver.findElement(logoButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(logoButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(logoButton).click(); //Нажми на элемент
    }

    public void logoutButtonClick(){
        WebElement element = driver.findElement(logoutButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(logoutButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(logoutButton).click(); //Нажми на элемент
    }

}
