package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SoruCozumu4 extends TestBase {


    @Test

    public  void test01 () {

        // https://www.carettahotel.com/ adresine git.

        driver.get("https://www.carettahotel.com/");

        Actions actions=new Actions(driver);

      WebElement kayit=  driver.findElement(By.xpath("//a[text()='Contact']"));

      actions.click(kayit).perform();

      WebElement form=driver.findElement(By.name("NameSurname"));

      actions.click(form).sendKeys("Arif Özfidan").sendKeys(Keys.TAB).sendKeys("asdre@gmail.com").
              sendKeys(Keys.TAB).sendKeys("1223433").sendKeys(Keys.TAB).sendKeys("oda kayit").
              sendKeys(Keys.TAB).sendKeys("balayi icin kral odasini bosaltin").sendKeys(Keys.CLEAR).perform();
    }
}
