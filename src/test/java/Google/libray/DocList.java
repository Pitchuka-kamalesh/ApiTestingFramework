package Google.libray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class DocList {

    public static Properties properties;
    private static final String conFigPath = "configuration/Testing.properties";


    @BeforeTest
    public void config() throws Throwable{
        properties = new Properties();
        InputStream ip = new FileInputStream(conFigPath);
        properties.load(ip);
        ip.close();

    }
    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));
        assertEquals(listOfDropdownElements(driver,properties.getProperty("Nav_Clinics")).toArray(),properties.getProperty("Nav_Clinics_Values").split(","));
        assertEquals(listOfDropdownElements(driver, properties.getProperty("Nav_For_Patients")).toArray(), properties.getProperty("Nav_For_Patients_Values").split(","));
//        assertEquals(listOfDropdownElements(driver, properties.getProperty("Nav_Our_Specialities")).toArray(),properties.getProperty("Nav_Our_Specialities_Values").split(","));
        assertEquals(listOfDropdownElements(driver, properties.getProperty("Nav_Departments")).toArray(),properties.getProperty("Nav_Departments_Values").split(","));
        assertEquals(listOfDropdownElements(driver, properties.getProperty("Nav_Corporate")).toArray(),properties.getProperty("Nav_Corporate_Values").split(","));
        assertEquals(listOfDropdownElements(driver, properties.getProperty("Nav_Health_Checkup")).toArray(),properties.getProperty("Nav_Health_Checkup_Values").split(","));
//        System.out.println(properties.getProperty("Nav_Clinics_values"));
//        Assert.assertEquals(properties.getProperty("Nav_Clinics_values").split(","),eles.toArray());
//        WebElement name = driver.findElement(By.xpath("//section//child::input[@id = 'name' and @placeholder ='Name']"));
//        new Actions(driver).moveToElement(name).click().keyDown(Keys.SHIFT).sendKeys("helloworld").build().perform();
        driver.quit();
    }

    public List<String> listOfDropdownElements(WebDriver driver, String name){

        WebElement specialist = driver.findElement(By.xpath("//nav//a[normalize-space()='"+name+"']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(specialist).build().perform();
        List<WebElement> elements = driver.findElements(By.xpath("//nav//child::a[normalize-space()='"+name+"']//parent::li//ul"));
        List<String> eles = new ArrayList<>();
        for (WebElement ele:elements){
            eles.add(ele.getText());
            System.out.println(ele.getText());
        }

        return eles;

    }

    @AfterTest
    public void closedIntegraction() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(conFigPath);
        properties.store(outputStream,null);


    }
}
