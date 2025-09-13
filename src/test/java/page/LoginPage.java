package page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    public Properties props;

    public LoginPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
    }

    public void login() {
    	driver.findElement(By.xpath("//button[normalize-space(.)=\"Continue shopping\"]")).click();
    	System.out.println("enter in login");
    	
    	driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    	System.out.println("click on sign in here");
    	
        driver.findElement(By.id("ap_email_login")).sendKeys(props.getProperty("email"));
        System.out.println("email recieved is "+props.getProperty("email"));

        driver.findElement(By.xpath("//*[@id=\"continue\"]/span/input")).click();
        System.out.println("click on continue after writing email");

        driver.findElement(By.id("ap_password")).sendKeys(props.getProperty("password"));
        System.out.println("password recieved is "+props.getProperty("password"));
        driver.findElement(By.id("signInSubmit")).click();
        System.out.println("submit btn is clicked and user is now Logged in");
    }
}

