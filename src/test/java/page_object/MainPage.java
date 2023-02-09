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

    //Кнопка секции "Булки"
    private By sectionBunButton = By.xpath(".//span[contains(text(),'Булки')]");

    //Кнопка секции "Соусы"
    private By sectionSauceButton = By.xpath(".//span[contains(text(),'Соусы')]");

    //Кнопка секции "Начинки"
    private By sectionIngredientsButton = By.xpath(".//span[contains(text(),'Начинки')]");


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

    public void sectionBunButtonClick(){
        WebElement element = driver.findElement(sectionBunButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(sectionBunButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(sectionBunButton).click(); //Нажми на элемент
    }

    public void sectionSauceButtonClick(){
        WebElement element = driver.findElement(sectionSauceButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(sectionSauceButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(sectionSauceButton).click(); //Нажми на элемент
    }

    public void sectionIngredientsButtonClick(){
        WebElement element = driver.findElement(sectionIngredientsButton); //Найди элемент
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Проскроль до него
        Assert.assertTrue(driver.findElement(sectionIngredientsButton).isEnabled()); //Убедись, что он доступен
        driver.findElement(sectionIngredientsButton).click(); //Нажми на элемент
    }


}
