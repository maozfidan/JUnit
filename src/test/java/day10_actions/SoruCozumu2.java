package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SoruCozumu2 extends TestBase {


    @Test

    public  void test01 () {

        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Actions actions =new Actions(driver);

       WebElement ilkad= driver.findElement(By.name("firstname"));



       actions.
               //contextClick(ilkad).
               sendKeys("Arif").
               sendKeys(Keys.TAB).sendKeys("Özfidan").
               sendKeys(Keys.TAB).sendKeys("assdeer@gmail.com").sendKeys(Keys.TAB).perform();
    }
}
