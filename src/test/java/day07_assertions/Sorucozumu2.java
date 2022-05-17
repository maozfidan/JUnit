package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Sorucozumu2 {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
    WebDriver driver;

    @Before

    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com/");
    }

    @After

    public void tearDown() {

        driver.close();
    }

    @Test

    public void test01() {


        WebElement sign = driver.findElement(By.xpath("//button[@id='signin_button']"));

        sign.click();


        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        driver.findElement(By.xpath("//input[@name='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        WebElement ddm = driver.findElement(By.xpath("//select[@id='pc_currency']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Eurozone (euro)");

        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("15");

        WebElement dolar = driver.findElement(By.id("pc_inDollars_true"));

        Assert.assertFalse(dolar.isSelected());

        driver.findElement(By.id("pc_inDollars_false")).click();

        driver.findElement(By.id("pc_calculate_costs")).click();

        driver.findElement(By.id("purchase_cash")).click();

        WebElement sonuc = driver.findElement(By.xpath("//div[@id='alert_content']"));

        String sonucYazis = sonuc.getText();

        Assert.assertTrue(sonuc.isDisplayed());

    }
}
