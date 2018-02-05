package com.weightwatchers.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.*;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {
   private WebDriver driver;

   //samplePage html

   @FindBy(how = How.XPATH, using = "//span[contains(text(),'Applesauce, unsweetened')]")
   private WebElement thirdFoodName;

   @FindBy(how = How.XPATH, using = "//span[contains(text(),'Juice, Cranberry-apple drink')]")
   private WebElement fifthFoodName;

   @FindBy(how = How.XPATH, using = "//div[@class='itemContent']/span")
   private List<WebElement> allItems;


   //Constructor
   public SamplePage(WebDriver driver) {
     this.driver = driver ;
     PageFactory.initElements(driver, this);
   }

   public String getElementTextForThirdFoodName() {
     return thirdFoodName.getText();
   }

   public String getElementTextForFifthFoodName() {
     return fifthFoodName.getText();
   }

   public Map<Integer, String> printAllItemText() {
     Map<Integer, String> context = new HashMap<Integer, String>();
     Integer count = 1;
     for (WebElement ele :allItems) {
       context.put(count, ele.getText());
       count++;
     }
     return context;
   }
}
