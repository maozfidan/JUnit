package day07_assertions;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SoruCozum {


    //Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;

    @BeforeClass

    public static void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @AfterClass

    public static void tearDown() {
        // driver.close();

    }

    @Test

    public void test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45

        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(ddm);

        int actualSize=select.getOptions().size();
        int expectedSize=45;

        Assert.assertTrue("Katagori sayisi 45 degildir: ",expectedSize==actualSize);

    }

    @Test
    public void test02(){

        //1. Kategori menusunden Books secenegini secin
        //2. Arama kutusuna Java yazin ve aratin
        //3. Bulunan sonuc sayisini yazdirin
        //4. Sonucun Java kelimesini icerdigini test edin

        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(ddm);

        select.selectByVisibleText("Books");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucSayi=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));

        String sonuc=sonucSayi.getText();

     WebElement javaYazi=driver.findElement(By.xpath("//*[text()='\"Java\"']"));

     String java=javaYazi.getText();

     Assert.assertTrue(java.contains("Java"));
    }
}
