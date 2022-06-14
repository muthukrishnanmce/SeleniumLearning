package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.paint.Color;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LearnElementLevelVerifications {

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    @Test
    public void elementValidations() {
        WebDriver driver = initializeDriver();
        driver.get("http://leaftaps.com/opentaps/control/main");

        WebElement usernameElm = driver.findElement(By.xpath("//label[@for='username']"));


        System.out.println(driver.findElement(By.xpath("//label[@for='username']")).getText());
        driver.findElement(By.id("username")).sendKeys("test");
        System.out.println(driver.findElement(By.id("username")).getAttribute("value"));
        System.out.println(driver.findElement(By.tagName("title")).getAttribute("textContent"));

        Point location =  usernameElm.getLocation();
        System.out.println(location.x);

        Dimension size = usernameElm.getSize();
        System.out.println(size);

        System.out.println(usernameElm.getCssValue("background-color"));
        System.out.println(usernameElm.getCssValue("text-align"));

        List<WebElement> allLabels = driver.findElements(By.tagName("label"));

        for(WebElement label:allLabels) {
            System.out.println(label.getSize());
            System.out.println(label.getLocation());
        }
        Actions action = new Actions(driver);


        driver.close();
    }


    @Test
    public void excercise1_Links() {
        WebDriver driver = initializeDriver();

        driver.get("http://www.leafground.com/pages/Link.html");
        driver.findElement(By.linkText("Go to Home Page")).click();
        driver.navigate().back();


        String getLink = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
        driver.get(getLink);
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.findElement(By.linkText("Verify am I broken?")).click();
        String brokenTitle = driver.getTitle();

        if(brokenTitle.indexOf("404")>=0)
            System.out.println("link is broken");
        driver.navigate().back();

        driver.close();

    }

    @Test
    public void exercise2_Buttons() throws IOException {
        WebDriver driver = initializeDriver();
        driver.get("http://www.leafground.com/pages/Button.html");

        driver.findElement(By.id("home")).click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        WebElement positionButton = driver.findElement(By.id("position"));
        System.out.println(positionButton.getLocation());
        WebElement colorButton = driver.findElement(By.id("color"));
        String colorRGB = colorButton.getCssValue("background-color");
        System.out.println(colorRGB);
        colorRGB = colorRGB.replaceAll("[a-z]","");
        System.out.println(colorRGB);
        String[] rgbvalues = colorRGB.split(",");
        System.out.println(Arrays.toString(rgbvalues));
//        Color color = Color.rgb(Integer.parseInt(rgbvalues[0]),Integer.parseInt(rgbvalues[1]),Integer.parseInt(rgbvalues[2]));
//        System.out.println(color);
        WebElement heightButton = driver.findElement(By.id("size"));
        System.out.println(heightButton.getSize());
        File scn = heightButton.getScreenshotAs(OutputType.FILE);
        File dest = new File("ss.png");

        FileUtils.copyFile(dest,scn);

        driver.close();

    }


}
