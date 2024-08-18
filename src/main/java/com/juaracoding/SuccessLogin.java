package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String url = ("https://www.saucedemo.com/");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        delay(3);
        WebElement txtTitle = driver.findElement(By.xpath("//div[@class='login_logo']"));
        System.out.println(txtTitle.getText());

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user"); //actual
        delay(3);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        delay(3);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //scenario test login
        delay(5);
        String txtDashboard1 = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        String expected1 = "Swag Labs";
        customAssertEquals(txtDashboard1, expected1);
        System.out.println(txtDashboard1);

        delay(5);

        String txtDashboard2 = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expected2 = "Products";
        customAssertEquals(txtDashboard2, expected2);
        System.out.println(txtDashboard2);

        delay(5);

        driver.quit();
        System.out.println("Exit Browser");
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik + 1000);
        } catch (InterruptedException var) {
            InterruptedException e = var;
            throw new RuntimeException(e);
        }
    }

    public static void customAssertEquals(String actual, String expected){
        System.out.print("Test Result: ");
        if (actual.equals(expected)){
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }
}
