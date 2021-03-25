package com.example.MyWebScraper.base;


//import jdk.internal.loader.Resource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.example.MyWebScraper.utils.Utilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
   // public static Resource resource;


    /*  test base class contructor : Used to initialize the properties object to
        fetch config (env) variables from config.prop file
    */
    public TestBase() {


//
//
//        try {
//            prop = new Properties();
//            ClassLoader classLoader = getClass().getClassLoader();
//            //File file = new File("C:\\etshwane_automation\\src\\main\\resources\\config.prop");
//
//           // FileInputStream ip = new FileInputStream(file);
//
//           // prop.load(ip);
//
//        } catch (FileNotFoundException fnf) {
//            fnf.printStackTrace();
//        } catch (IOException ioe) {
//
//            ioe.printStackTrace();
//        }
//
//
//
//    }

    }

    // initialize the web browser based on the config.prop file
    public  void Initialize() {

        //ChromeOptions chrome = new ChromeOptions();
        //  chrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        String browserName = "chrome";

        if (browserName.equalsIgnoreCase("chrome")) {

            ClassLoader cl = getClass().getClassLoader();
            File file = new File(cl.getResource("chromedriver.exe").getFile());

            ;

           // this.getClass().getResource("chromedriver.exe");
            //  String browserName = "chrome";
            System.setProperty("webdriver.chrome.driver",cl.getResource("chromedriver.exe").getFile());
            ChromeOptions option = new ChromeOptions();
            option.addArguments("headless");
            option.addArguments("ignore-certificate-errors");


            driver = new ChromeDriver(option);

        }
//        // still need to install the IE exe and FireFox exe
//    git     else if (browserName.equalsIgnoreCase("IE")) {
//            System.setProperty(prop.getProperty("InternetExpLocation"));
//            driver = new InternetExplorerDriver();
//        } else if (browserName.equalsIgnoreCase("firefox")){
//            System.setProperty(prop.getProperty("fireFoxLocation"))
//        driver = new FirefoxDriver();}
//


        //manage driver
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Utilities.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        driver.get("https://www.sportsmanswarehouse.co.za/product/avalanche-reflex-pro-29-mountain-bike");


    }
}