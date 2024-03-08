package utills;


import com.varibles.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import static com.varibles.ConfigProperties.properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties excel_properties,locators_properties;

    public BaseClass(){
        ConfigProperties.initializePropertiesFile();
        excel_properties = ConfigProperties.initializePropertiesFile(properties.getProperty("Excel_Property_File"));
        locators_properties = ConfigProperties.initializePropertiesFile(properties.getProperty("Locators_Property_File"));
    }


    public static void launchApp(String browserName, String url) {
        switch (browserName) {
            case "chrome":
                System.out.println("We are in the " + " " + browserName + "browser");
                driver = new ChromeDriver();
                setup(url);
                break;
            case "edge":
                System.out.println("We are in the " + " " + browserName + "browser");
                driver = new EdgeDriver();
                setup(url);
                break;
            case "firefox":
                System.out.println("We are in the " + " " + browserName + "browser");
                driver = new FirefoxDriver();
                setup(url);
                break;
            case "ie":
                System.out.println("We are in the " + " " + browserName + "browser");
                driver = new InternetExplorerDriver();
                setup(url);
                break;

            default:
                System.out.println("There is no implementation for the given browser" + " :" + browserName);
                break;

        }


    }

    static void setup(String url) {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }

    public static void closeApp() {
        driver.close();
//        driver.quit();
    }

    public static String status(int status) {

        switch (status){

            case -1:
                return "CREATED";
            case  1:
                return "Pass";
            case  2:
                return "Fail";
            case  3:
                return "skip";
        }

        return null;
    }


}
