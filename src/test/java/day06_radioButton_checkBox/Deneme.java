package day06_radioButton_checkBox;

import com.sun.deploy.association.Action;
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

public class Deneme {


    //Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    static WebDriver driver;

    @BeforeClass


    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }
    @AfterClass

    public static void tearDown(){

       driver.close();
    }
//3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin

    @Test
    public void titleTest() {

        String actuatitel=driver.getTitle();
        String expectedtitel="YouTube";

        Assert.assertEquals(expectedtitel,actuatitel);

    }

    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

    @Test
    public void choies() throws InterruptedException {

        Actions action=new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN);

        driver.findElement(By.xpath("//yt-formatted-string[text()='Tümünü kabul et']")).click();

        Thread.sleep(3000);

    }

    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() throws InterruptedException {

        WebElement image=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Thread.sleep(3000);

        Assert.assertTrue(image.isDisplayed());


    }

    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBox(){

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBox.isEnabled());
    }

    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest(){
        String actuatitele=driver.getTitle();
        String expectedtitele="youTube";

        Assert.assertNotEquals("farkli bir sayfa:",expectedtitele,actuatitele);

    }
}
