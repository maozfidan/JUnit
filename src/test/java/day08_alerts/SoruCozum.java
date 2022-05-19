package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SoruCozum {

    //● Bir class olusturun: IframeTest02
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız
    WebDriver driver;

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techproeducation.com");
    }

    @After

    public void tearDown() {
        // driver.close();
    }

    @Test

    public void test01() {
        //● Bir class olusturun: IframeTest02
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        //2) sayfadaki iframe sayısını bulunuz.
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
     // driver.findElement(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']")).click();
//
     // List<WebElement> liste=driver.findElements(By.className("iframe"));
//
     //   System.out.println(liste.size());
    }
}
