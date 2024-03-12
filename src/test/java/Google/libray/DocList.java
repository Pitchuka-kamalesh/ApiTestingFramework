package Google.libray;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DocList {
    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://continentalhospitals.com/request-appointment/");
//        WebElement specialist = driver.findElement(By.xpath("//nav//a[text()='Departments']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(specialist).build().perform();
//        List<WebElement> elements = driver.findElements(By.xpath("//nav//child::a[text()='Departments']//parent::li//ul"));
//
//        for (WebElement ele:elements){
//            System.out.println(ele.getText());
//        }
        WebElement name = driver.findElement(By.xpath("//section//child::input[@id = 'name' and @placeholder ='Name']"));
        new Actions(driver).moveToElement(name).click().keyDown(Keys.SHIFT).sendKeys("helloworld").build().perform();





    }
}
