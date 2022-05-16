package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Deneme2 {

    //1-C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6-Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8-Sayfayi kapatin

    static WebDriver driver;

    @BeforeClass


    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");

    }

    @AfterClass

    public static void tearDown() {

       // driver.close();
    }

    //3- cookies uyarisini kabul ederek kapatin

    @Test

    public  void choies(){

        Actions action=new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN);

    driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();
    }

    //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

    @Test

    public  void google(){

        String actuatitel=driver.getTitle();
        String expectedtitel="Google";

        Assert.assertEquals(expectedtitel,actuatitel);

    }

    //5- Arama cubuguna “Nutella” yazip aratin

    @Test

    public  void nutella(){

  //    WebElement nutella= driver.findElement(By.xpath("//input[@name='q']"));
//
  //  nutella.sendKeys("Nutella");

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Nutella" + Keys.ENTER);
    }

    //6-Bulunan sonuc sayisini yazdirin

    @Test

    public  void nutellasonuc(){


    }
}