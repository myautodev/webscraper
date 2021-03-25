package com.example.MyWebScraper.pages;


import com.example.MyWebScraper.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bikes extends TestBase {

    @FindBy(xpath = "//div[@class='d-block']//button[@title='Select a size']")
    WebElement selectSizeButton;

    @FindBy(xpath = "//button[@type='button' and@data-target= '#notify-when-available']")
    WebElement  Notifyme;

    @FindBy(xpath = "//label[@for='675']")
    WebElement  largeSizeButton;

    @FindBy(xpath = "//span[contains(@class,'lead currency')]")
    WebElement price;


    //label[@for='675']

    public  Bikes(){
        PageFactory.initElements(driver,this);

    }

    public Boolean getBike(){

        //  System.out.print(price.getText());

        if (price.getText().equalsIgnoreCase("R10 499.90 - Out of stock")){
            return false;}
        else {
            return true;
        }


    }

}
