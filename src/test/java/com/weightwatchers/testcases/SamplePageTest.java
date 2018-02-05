package com.weightwatchers.testcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.*;
import com.weightwatchers.webpages.SamplePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SamplePageTest {
   WebDriver driver;
   SamplePage samplePage;

  private static String user_dir = System.getProperty("user.dir");
  private static String Page_URL = "file:///" + user_dir + "/src/main/java/SamplePage.html";


   @BeforeTest
   public void setup() throws Exception {
     //Firefox
   // System.setProperty("webdriver.gecko.driver", user_dir+ "/src/test/java/com/weightwatchers/util/geckodriver");
    System.setProperty("webdriver.chrome.driver", user_dir + "/src/test/java/com/weightwatchers/util/chromedriver");
    // driver = new FirefoxDriver();
     driver = new ChromeDriver();
     driver.get(Page_URL);
     driver.manage().window().maximize();
     samplePage = new SamplePage(driver);
   }

   @AfterTest
   public void tearDown() {
     driver.quit();
   }

   @Test
   public void getElementText() {
     try {

       System.out.println(samplePage.getElementTextForThirdFoodName());
       System.out.println(samplePage.getElementTextForFifthFoodName());
     } catch (Exception e) {
       System.out.println("We can not print out the element content because of " + e);
     }
   }

   @Test
   public void storeName() {
     try {

       Iterator<Entry<Integer,String>> iterator = samplePage.printAllItemText().entrySet().iterator();
       while (iterator.hasNext()) {
         Map.Entry<Integer,String> entry = iterator.next();
         System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
       }
     } catch (Exception e) {
       System.out.println("We can not store the food name and servings because of " + e);
     }
   }

}
