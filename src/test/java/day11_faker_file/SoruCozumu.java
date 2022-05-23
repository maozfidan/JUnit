package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class SoruCozumu extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //
    //- https://the-internet.herokuapp.com/download adresine gidelim.
    //
    //- code.txt dosyasını indirelim
    //
    //4. Ardından isExist( ) methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void downloadTestTsst() {

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.xpath("//a[text()='HelloWorld.pdf']")).click();

   }

   @Test
   public void isExistTest() {

        System.out.println(System.getProperty("user.home"));

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\HelloWorld.pdf";

        String dosyayolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));


    }
}
