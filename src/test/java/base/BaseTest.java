package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public Properties props;

    @BeforeClass
    public void setup() {
        props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = new ChromeDriver();
        System.out.println("chromedriver started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();
        System.out.println("window is maximized");
        driver.get("https://www.amazon.in/");
        System.out.println("url is get");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

