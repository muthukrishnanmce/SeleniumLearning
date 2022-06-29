package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CDPCommandLearning {

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
//        driver.quit();
    }

    @Test
    public void testCDP() {
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String,Object> gl = new HashMap<>();
        gl.put("longitude",40.7128);
        gl.put("latitude",74.0060);
        gl.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride",gl);
        driver.get("https://www.amazon.com/");
    }

}
