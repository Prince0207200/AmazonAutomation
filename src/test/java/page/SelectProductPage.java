package page;

import java.time.Duration;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectProductPage {

	

    public WebDriver driver;
    public Properties props;

    public SelectProductPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
    }

    public void selectFirstProduct() {
    	System.out.println("select page ");
    
    	
    	String currentWindow = driver.getWindowHandle();
    	System.out.println("current window:"+currentWindow);
    	
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-6-announce\"]")));

        // Scroll into view with JS instead of Actions
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        System.out.println("scroll");
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
 	 
        String currentWindow1 = driver.getWindowHandle();
    	System.out.println("current window1:"+currentWindow1);
        
        System.out.println("selected product");
        
     
        
        
    }
}
