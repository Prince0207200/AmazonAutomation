package page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    public WebDriver driver;
    public Properties props;

    public SearchPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
    }

    public void searchProduct() {
    	System.out.println("entered in search product page");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag");
        System.out.println("search input send is bag");
        
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("click on submit after writing search product");
        System.out.println("search done");
    }
}

