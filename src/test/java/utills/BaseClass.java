package utills;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    protected static Properties properties;


    public static void loadProperties(String fileName){
        try {
            properties = new Properties();
            properties.load(new FileReader(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public static String getValues(String key) throws Exception {

        String value = properties.getProperty(key);
        if (value == null){
            throw new Exception("the given key '"+key+"' is not present in the properties file");
        }else {
            return value;
        }

    }


}
