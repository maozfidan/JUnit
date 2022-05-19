package day09_handleWindowa_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class SoruCozumu {

    //Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    //doğrulayın.


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        //● Click Here butonuna basın.
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.

        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement baslik = driver.findElement(By.xpath("//h3"));

        String actualText = baslik.getText();

        String expectedText = "Opening a new window";

        Assert.assertEquals(expectedText, actualText);

        String ilkSayfaHandel = driver.getWindowHandle();

        String actualTitle=driver.getTitle();

        String expectedTitle="The Internet";

        Assert.assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.linkText("Click Here")).click();

//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

       driver.switchTo().newWindow(WindowType.WINDOW);

        driver.navigate().to("https://the-internet.herokuapp.com/windows/new");

        System.out.println(driver.getWindowHandle());

        // Set<String> handels=driver.getWindowHandles();

     // String ikincisayfaHandel="";

     //  for (String each: handels
     //        ) {
     //      if (!each.equals(ilkSayfaHandel)){

     //          ikincisayfaHandel=each;
     //      }
     //      System.out.println(ikincisayfaHandel);
       // }
     //driver.switchTo().window(ikincisayfaHandel);

        String actualIkinciTitle=driver.getTitle();

        String expectedIkinciTitle="New Window";

        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.
       driver.switchTo().window(ilkSayfaHandel);
        actualTitle=driver.getTitle();
        expectedTitle="The Internet";

        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
