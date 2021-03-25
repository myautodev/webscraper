package com.example.MyWebScraper.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utilities {

    // set page load and implicit wait times
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT_TIMEOUT = 20;


    // take screen shot on failure
    public static String getScreenShot(WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);

        try {

            FileUtils.copyFile(src, destination);
        } catch (IOException ioe) {

            System.out.print("Capture failed " + ioe.getMessage());
        }

        return path;

    }

    //sleep call
    public static void sleep(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }


    }
}