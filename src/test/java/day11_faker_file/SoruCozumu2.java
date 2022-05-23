package day11_faker_file;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class SoruCozumu2 extends TestBase {

    @Test
    public void test01() {

        //Notes: It may also be necessary to write code to accept the accept cookies warning.
        //1. Go to 'https://www.amazon.com.tr/'
        //2. Search iPhone13 512
        //3. Check that the results are listed
        //4. Click iPhone13 at the top of the list
        //5. Log the following values for each size
        //.Size information .Price .Color .Stock status


        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Ipohone13 512"+ Keys.ENTER);

        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        System.out.println(sonuc.getText());

        List<WebElement> liste=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base a-text-normal']"));

        List<String> bosliste=webdenCikar(liste);
        yazdir(bosliste);

        System.out.println(liste.size());
        for (WebElement each: liste
             ) {
            System.out.println(each.getText());
        }
        liste.stream().skip(1).limit(2).forEach(t-> t.click());

      // WebElement yazi=driver.findElement(By.id("productTitle"));

      // System.out.println(yazi.getText());

      // WebElement renk=driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name"));

      // System.out.println(renk.getText());

      // WebElement fiyat=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']"));

      // System.out.println(fiyat.getText());

      // WebElement stok=driver.findElement(By.xpath(" //span[@class='a-size-base a-color-price a-text-bold']"));

      // System.out.println(stok.getText());


    }

    public void yazdir(List<String> list) {
        for (String each : list
        ) {
            System.out.println(each.substring(each.indexOf(""), each.indexOf(", ")));
        }
    }
    public List<String> webdenCikar(List<WebElement> webElements) {
        List<String> dieWArenListe = new ArrayList<>();
        for (WebElement each : webElements
        ) {
            if (!each.getText().contains("Gesponsert")) {
                dieWArenListe.add(each.getText());
            }
        }
        return dieWArenListe;
    }
}
