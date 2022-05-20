package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SoruCozumu3 extends TestBase {

    @Test

    public  void test01 () {

        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);

        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropp=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragMe,dropp).perform();

        WebElement sonuc=driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertTrue(sonuc.isDisplayed());


    }
}
