package LearnSelenium.Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class TableLearning {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void learnTable() {
        driver.get("http://www.leafground.com/pages/table.html");

        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> row = table.findElements(By.tagName("td"));

       for(int i=2;i<row.size()-1;i++) {
           List<WebElement> allcol = row.get(i).findElements(By.tagName("td"));
           for(int j=0;j<allcol.size();j++){
               String text = allcol.get(j).getText();
               System.out.println(text);
           }
       }

    }

}
