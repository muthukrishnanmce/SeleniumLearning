package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ActionsLearning {

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
//        driver.quit();
    }

    @Test
    public void actionsTest() {
        driver.get("http://www.leafground.com/home.html");

        WebElement editLink = driver.findElement(By.xpath("//h5[text()='Edit']"));
        Actions build = new Actions(driver);

        build.moveToElement(editLink).click().perform();

        //drag

        driver.get("http://www.leafground.com/pages/drag.html");
        WebElement dragElm = driver.findElement(By.id("draggable"));
        for (int i=0;i<20;i++)
            build.dragAndDropBy(dragElm,i,i+10).perform();

    }

    @Test
    public void testDrop() {
        driver.get("http://www.leafground.com/pages/drop.html");
        Actions build = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        build.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void SelectableTest1() {
        driver.get("http://www.leafground.com/pages/selectable.html");
        Actions build = new Actions(driver);

        List<WebElement> items = driver.findElements(By.xpath("//li[contains(text(),'Item')]"));

        build.clickAndHold(items.get(0)).moveToElement(items.get(4)).click().release().perform();


    }

    @Test
    public void SelectableTest2() {
        driver.get("http://www.leafground.com/pages/selectable.html");
        Actions build = new Actions(driver);

        List<WebElement> items = driver.findElements(By.xpath("//li[contains(text(),'Item')]"));

        build.keyDown(Keys.LEFT_CONTROL).click(items.get(0)).click(items.get(2)).click(items.get(4)).keyUp(Keys.LEFT_CONTROL).perform();


    }


}
