package page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By lkButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //Локатор кнопки "Личный кабинет

    private By loginButtonMainPage = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");

    private By orderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");

    public void lkButtonClick() {
        WebElement element = driver.findElement(lkButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(lkButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(lkButton).click(); //Нажми на элемент
    }

    public void loginButtonMainPageClick(){
        WebElement element = driver.findElement(loginButtonMainPage); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(loginButtonMainPage).isEnabled()); //Убедись, что он доступен
        driver.findElement(loginButtonMainPage).click(); //Нажми на элемент
    }



    //private By OrderHeadButton = By.className("Button_Button__ra12g"); //Локатор кнопки "Заказать" в шапке

    //private By OrderMiddleButton =  By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"); //Локатор кнопки "Заказать №2"




}
