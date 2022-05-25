package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoruCozumu2 {


    // excel dosyasindaki tum verileri clasimiza alip
    // bir Java objesine store edelim
    // boylece her seferinde excel'e ulasip satir,sutun vs.. ugrasmayalim
    // Database yapisinda olan excel'i
    // koyabilecegimiz en uygun Java objesi map'dir

    @Test

    public  void test01() throws IOException {

        Map<String,String> liste=new HashMap<>();

        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

      int satirSayisi= workbook.getSheet("Sayfa1").getLastRowNum();

      String key="";
      String value="";

        for (int i = 0; i <satirSayisi ; i++) {

            key=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("sayfa1").getRow(i).getCell(1)+","
                    +workbook.getSheet("sayfa1").getRow(i).getCell(2)+","
                    +workbook.getSheet("sayfa1").getRow(i).getCell(3)+",".toString();

            liste.put(key,value);

        }

        System.out.println(liste);

        liste.forEach((k,v) -> System.out.println("ülkeler : "+k + "             "+"degerler : " + v));


    }
}
