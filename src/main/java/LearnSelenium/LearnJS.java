package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class LearnJS {
    ChromeDriver driver;

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
    public void JSTest() throws AWTException {
        driver.get("https://jqueryui.com/resizable/");
        Robot ro = new Robot();
        ro.keyPress(KeyEvent.VK_CONTROL);
        ro.keyPress(KeyEvent.VK_ADD);
        ro.keyRelease(KeyEvent.VK_ADD);
        ro.keyRelease(KeyEvent.VK_CONTROL);


    }

    @Test
    //Page status
    public void PageTest() {
        driver.get("https://jqueryui.com/resizable/");
        String status = driver.executeScript("return document.readyState").toString();
        System.out.println(status);

    }

}
