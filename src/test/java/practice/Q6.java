package practice;

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
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Q6 extends TestBase {
    /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");

        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Books");

        List<WebElement> liste = select.getOptions();

        for (WebElement each : liste
        ) {
            System.out.println(each.getText());

        }
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        System.out.println(sonuc.getText());

        String sonucYazisi = sonuc.getText();

        String sonucrakami = sonucYazisi.substring(sonucYazisi.indexOf("of") + 2, sonucYazisi.indexOf("results"));

        System.out.println(sonucrakami);

        String expectedTitle = "Les Miserables";

        String actualTitle = sonuc.getText();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("testimiz Passed");
        }

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}