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
import static com.varibles.ConfigProperties.properties;


public class Search extends BaseClass {
    ReadData data;
    List<String> values;
    @BeforeTest
    public void setUp(){

        data = new ReadData();

    }
    @Test
    public void testSearch(){

        launchApp(properties.getProperty("Browser"),properties.getProperty("AppUrl"));
        logger.info("Opening the:"+properties.getProperty("Browser")+" Browser");
        logger.info("The Application url:"+properties.getProperty("AppUrl"));
        List<WebElement> footer = driver.findElements(By.xpath("//ul[@id = 'menu-footer-menu']//descendant::ul[@class='sub-menu']//a"));
        values = new ArrayList<>();
        for (WebElement els:footer){
            values.add(els.getText());
        }


    }


    @AfterMethod
    public void teardown(ITestResult result) {
        driver.quit();
        logger.info("We closed the driver instance");

    }



}
