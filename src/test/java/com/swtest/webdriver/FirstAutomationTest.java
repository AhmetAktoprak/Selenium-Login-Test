package com.swtest.webdriver;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstAutomationTest {

    //We should add @Test annotation that JUnit will run below method
    @Test
    //Start to write our test method.
    public void swTest() {


        System.setProperty("webdriver.firefox.marionette", "C://Program Files//eclipse//geckodriver-v0.11.1-win64//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();              //open the browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("http://www.google.com");   //open the URL

        System.out.println(driver.getTitle());

        driver.findElement(By.name("username")).sendKeys("Ahmet");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("Test Login")).click();

        String exp_title = "Login example page to test the PHP MySQL online system";
        String act_title = driver.getTitle();                     //return title of page


      /*  if (exp_title.equals(act_title) == true) {
            System.out.println("**Successful Login**");
        } else {
            System.out.println("**Failed Login**");  */
            assertEquals("Login example page to test the PHP MySQL online system",
                    driver.getTitle(), "Title check failed!");


        }
    }

