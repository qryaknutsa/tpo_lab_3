package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static java.lang.Thread.sleep;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        String url = "https://drive.google.com/";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String menuBtn = "//button[@class='glue-header__drawer-toggle-btn']";
        String docs = "#features";
        driver.findElement(By.xpath(menuBtn)).click();
        driver.findElement(By.xpath("//a[@href='" + docs + "']")).click();
    }
}