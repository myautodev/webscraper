package com.example.MyWebScraper.workers;


import com.example.MyWebScraper.base.TestBase;
import com.example.MyWebScraper.pages.Bikes;

public class TheTask extends TestBase implements Runnable  {

    Bikes bk;
    Mailer ml;
    @Override
    public void run() {

        System.out.print("Task is starting");
        Initialize();
        bk = new Bikes();
        ml = new Mailer();


        if (bk.getBike() == true) {
            try {
                ml.sendMail();
            } catch (Exception e) {
                e.getMessage();
            }
        }

        driver.quit();
        {

        }

    }

    }

