package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoruCozumu3 {

    @Test
    public void test01() throws IOException {

        //Yeni bir test method olusturalim readExcel2( )
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        //- Satir sayisini bulalim
        //- Fiziki olarak kullanilan satir sayisini bulun
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

      String sonuc=  workbook.getSheet("Sayfa1").getRow(0).getCell(2).toString();

        System.out.println(sonuc);

       String baskent= workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();

        Assert.assertTrue(baskent.equals("Kabil"));

      int satiSayi=  workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println(satiSayi);
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String, String> ulkeisimleri=new HashMap<>();

        int sayi=workbook.getSheet("Sayfa1").getLastRowNum();

        String key="";
        String value="";

        for (int i = 0; i <sayi ; i++) {

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkeisimleri.put(key,value);

        }

        System.out.println(ulkeisimleri);

        ulkeisimleri.forEach((k,v)-> System.out.println("ülkeler: "+ k +"                       "+ "Baskent:  "+ v));

    }
}
