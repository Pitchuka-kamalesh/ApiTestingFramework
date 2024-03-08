package Google.libray;

import com.excel.examples.ReadData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utills.BaseClass;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.excel.examples.ReadData.excelProp;


public class Search extends BaseClass {
    ReadData data;
    List<String> values;
    @BeforeTest
    public void setUp(){

        data = new ReadData();

    }
    @Test
    public void testSearch(){

        launchApp(null,null);
        List<WebElement> footer = driver.findElements(By.xpath("//ul[@id = 'menu-footer-menu']//descendant::ul[@class='sub-menu']//a"));

        values = new ArrayList<>();
        for (WebElement els:footer){
            values.add(els.getText());
            System.out.println(values);
        }


    }


    @AfterMethod
    public void teardown(ITestResult result) {

        driver.quit();
        try {
            data.setData(values, status(result.getStatus()),excelProp.getProperty("Excel_Sheet_Name"), Integer.parseInt(excelProp.getProperty("Valid_Col")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



}
