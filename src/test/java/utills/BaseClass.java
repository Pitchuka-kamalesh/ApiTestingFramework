package utills;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public static void launchApp(String browserName, String url) {
    /*    if(browserName.equals("chrome")){
            System.out.println("We are in the " + " " + browserName + "browser");
            driver = new ChromeDriver();
            setup(url);

        }else {
            if(browserName.equals("edge")){
                System.out.println("We are in the " + " " + browserName + "browser");
                driver = new EdgeDriver();
                setup(url);


            }else{
                if(browserName.equals("firefox")){
                    System.out.println("We are in the " + " " + browserName + "browser");
                    driver = new FirefoxDriver();
                    setup(url);


                }else{
                    if(browserName.equals("ie")){
                        System.out.println("We are in the " + " " + browserName + "browser");
                        driver = new InternetExplorerDriver();
                        setup(url);


                    }else{

                        System.out.println("There is no implementation for the given browser" + " :" + browserName);



                    }

                }

            }


        }*/


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
}
