package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandleLearning {

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
    public void testWindowTab() {

        driver.get("http://www.leafground.com/pages/Window.html");
        driver.findElement(By.id("home")).click();
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Set<String> windows =  driver.getWindowHandles();
        for(String window:windows) {
            System.out.println(window);
        }

        List<String> windowList = new ArrayList<>(windows);
        driver.switchTo().window(windowList.get(1));
        driver.findElement(By.linkText("Button")).click();
        System.out.println(driver.getTitle());
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());

        Iterator<String> it = windowList.iterator();

        while(it.hasNext()) {
            if(!parent.equals(it.next())) {

                System.out.println(driver.getTitle());
            }
        }
    }

}
