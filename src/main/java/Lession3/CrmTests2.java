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

public class CrmTests2 {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        login();
        

        List<WebElement> navMenuElements = driver.findElements(By.xpath(
                "//div[@id='main-menu']/ul/li/a"));
        WebElement expenceElement = navMenuElements.stream().filter(e -> e.getText().equals(
                "Контрагенты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expenceElement).build().perform();

        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
                "//a[text()='Создать контактное лицо']"))));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_lastName')]")).sendKeys(
                "Фамилия");

        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_firstName')]")).sendKeys(
                "Имя");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();

        driver.findElement(By.xpath("//*[text()='12323142342134']")).click();

        driver.findElement(By.xpath("//input[contains(@id,'crm_contact_jobTitle')]")).sendKeys(
                "Директор");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        driver.quit();

    }

    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
