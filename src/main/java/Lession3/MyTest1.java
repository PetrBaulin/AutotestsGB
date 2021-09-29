package Lession3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyTest1 {
    private static WebDriver driver;
    private static final String CRM_URL = "https://afisha.ru";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);



        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
                "//*[@placeholder='Событие, актер, место']"))));
        driver.findElement(By.xpath("//*[@placeholder='Событие, актер, место']")).sendKeys(
                "тоторо");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
                "//*[text()='Мой сосед Тоторо']//ancestor::a"))));
        driver.findElement(By.xpath("//*[text()='Мой сосед Тоторо']//ancestor::a")).click();

        driver.findElement(By.xpath("//*[text()='Купить билеты']//ancestor::a")).click();

        Thread.sleep(10000);


        driver.quit();

    }

}
