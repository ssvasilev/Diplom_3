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

    //Кнопка личного кабинета
    private By LkButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //Локатор кнопки "Личный кабинет

    public void LkButtonClick() {
        WebElement element = driver.findElement(LkButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(LkButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(LkButton).click(); //Нажми на элемент
    }





    //private By OrderHeadButton = By.className("Button_Button__ra12g"); //Локатор кнопки "Заказать" в шапке

    //private By OrderMiddleButton =  By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"); //Локатор кнопки "Заказать №2"




}
