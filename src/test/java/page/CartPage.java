package page;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    public WebDriver driver;
    public Properties props;

    public CartPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
    }

    public void addToCartAndCheckout() throws InterruptedException {
    	System.out.println("entered in cart page");
    	
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart")));
    	  String currentWindow = driver.getWindowHandle();
      	System.out.println("current window:"+currentWindow);
        
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

          System.out.println("scroll back");
          ele.click();
          System.out.println("ele.clicked");
    	   
    	 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("desktop-ptc-button-celWidget")));
    	  
    	    element1.click();
    	    System.out.println("proceed to checkout");
    	    String currentWindow2 = driver.getWindowHandle();
        	System.out.println("current window2:"+currentWindow2);
        	driver.findElement(By.xpath("//input[@name='ppw-instrumentRowSelection' and @value='SelectableAddCreditCard']")).click();
        	System.out.println("radio btn");
        	

        	

        	
        	WebElement addCardLink = wait.until(ExpectedConditions.elementToBeClickable(
        	        By.xpath("//a[contains(text(),'Add a new credit or debit card')]")
        	));
        	addCardLink.click();
        	System.out.println("Clicked 'Add a new credit or debit card'");

        	
        	WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
        	        By.cssSelector("iframe.apx-secure-iframe")
        	));
        	driver.switchTo().frame(iframe);
        	System.out.println("Switched to credit card iframe");
        	
        
        	WebElement cardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"addCreditCardNumber\" and @type=\"tel\"]")));
        	cardNumber.sendKeys(props.getProperty("cardNo"));
        	System.out.println("Filled Card credential");
        	
        	WebElement contniueBtn = wait.until(ExpectedConditions.elementToBeClickable(
        	        By.xpath("//span[@class=\"a-button-inner\"]/input[@name=\"ppw-widgetEvent:AddCreditCardEvent\"]")
        	));
        	contniueBtn.click();
        	System.out.println("Clicked on continue");


    	    
    	   
    	 
        	
              
    }
}
