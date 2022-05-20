package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class SoruCozumu extends TestBase {

    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test

    public  void test01 (){

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));

        Actions actions =new Actions(driver);

        actions.contextClick(ciziliAlan).perform();


        String extend="You selected a context menu";
        String actual=driver.switchTo().alert().getText();

        Assert.assertEquals(extend, actual);

        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String ilkSayfaHandle=driver.getWindowHandle();



        WebElement link=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        actions.click(link).perform();

        Set<String> liste=driver.getWindowHandles();

        String ikinciHandle="";


        for (String each:liste
             ) {
            if (!each.equals(ilkSayfaHandle)){

                ikinciHandle=each;
            }
        }
            driver.switchTo().window(ikinciHandle);

        WebElement yazi=driver.findElement(By.xpath("//h1"));

        String extendd="Elemental Selenium";
        String actuall=yazi.getText();

        Assert.assertEquals(extendd, actuall);
    }
}
