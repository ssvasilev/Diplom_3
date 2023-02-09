import Resources.InitializeDriver;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.MainPage;

import static org.openqa.selenium.By.xpath;

public class SectionsTest extends InitializeDriver {

    private String xpathBun = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[contains(text(),'Булки')]";
    private String xpathSauce = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[contains(text(),'Соусы')]";
    private String xpathIngredients = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[contains(text(),'Начинки')]";


    @Test
    @DisplayName("Переход к разделу Булки")
    public void sectionBun(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.sectionIngredientsButtonClick(); //Нажимаем на кнопку "Начинки", что бы сделать кнопку "Булки" активной
        mainPage.sectionBunButtonClick(); //Нажимаем на кнопку "Булки"
        //Ждём, пока появится раздел Булки
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathBun)));
        Assert.assertTrue(driver.findElement(xpath(xpathBun)).isEnabled()); //Убедись, что элемент доступен
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void sectionSauce(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.sectionSauceButtonClick(); //Нажимаем на кнопку "Соусы"
        //Ждём, пока появится раздел Булки
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathSauce)));
        Assert.assertTrue(driver.findElement(xpath(xpathSauce)).isEnabled()); //Убедись, что элемент доступен
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void sectionIngredients(){
        MainPage mainPage = new MainPage(driver); //Создаём объект главной страницы
        mainPage.sectionIngredientsButtonClick(); //Нажимаем на кнопку "Начинки"
        //Ждём, пока появится раздел Булки
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathIngredients)));
        Assert.assertTrue(driver.findElement(xpath(xpathIngredients)).isEnabled()); //Убедись, что элемент доступен
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
