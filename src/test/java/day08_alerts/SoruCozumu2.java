package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SoruCozumu2 {

    //Bir class olusturun: IframeTest
    //
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //
    //● Bir metod olusturun: iframeTest
    //
    //○ “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //
    //○ Text Box’a “Merhaba Dunya!” yazin.
    //
    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin.

    WebDriver driver;

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @After

    public void tearDown() {
        // driver.close();

    }
    @Test

    public  void iframeTest() {
        //● Bir metod olusturun: iframeTest
        //
        //○ “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        //
        //○ Text Box’a “Merhaba Dunya!” yazin.
        //
        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin.

     WebElement test=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(test.isDisplayed());



        WebElement text=driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(text);

        WebElement kutucuk=driver.findElement(By.xpath("//body[@id='tinymce']"));

        kutucuk.clear();
        kutucuk.sendKeys("Merhaba Dunya");
driver.switchTo().defaultContent();

 WebElement baslik =driver.findElement(By.linkText("Elemental Selenium"));

 Assert.assertTrue(baslik.isDisplayed());

    }
}
