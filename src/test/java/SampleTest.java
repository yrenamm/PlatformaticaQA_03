import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void setDown(){
        driver.quit();
    }

    @Test
    public void searchesTest(){
        driver.get("https://www.webstaurantstore.com/");
        driver.findElement(By.xpath("//input[@id='searchval']")).sendKeys("table\n");
        List<WebElement> itemList = driver.findElements(By.xpath("//div[@id='details']/a[@data-testid='itemDescription']"));

        for(int i = 0; i < itemList.size(); i++){
            Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("table"));
        }
    }
}



















