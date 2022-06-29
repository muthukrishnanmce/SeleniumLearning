package LearnSelenium.Week4Assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;

public class Assesments {

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
    public void test() {
        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

//        Actions build = new Actions(driver);
//        WebElement toggle = driver.findElement(By.xpath("//span[text()='App Launcher']/.."));
//        build.click(toggle);
        driver.findElement(By.xpath("//span[text()='App Launcher']/..")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();

        WebElement element = driver.findElement(By.xpath("//p[text()='User Provisioning Requests']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();

//        driver.findElement(By.xpath("//p[text()='User Provisioning Requests']")).click();
        driver.findElement(By.xpath("//a[@class='uiOutputURL']")).click();

        Set<String> handles =  driver.getWindowHandles();
        List<String> handleList = new ArrayList<>();

        for(String handle:handles) {
            handleList.add(handle);
        }

        driver.switchTo().window(handleList.get(1));

        driver.findElement(By.xpath("//a[normalize-space()='Create New View']")).click();
        driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Muthu");
        driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("Muthu123");
        driver.findElement(By.xpath("//input[@id='fscope1']")).click();

        Select fieldDropdown = new Select(driver.findElement(By.xpath("//tr[@id='frow1']//select[@id='fcol1']")));
        fieldDropdown.selectByValue("Name");

        Select operatorDropdown = new Select(driver.findElement(By.xpath("//tr[@id='frow1']//select[@id='fop1']")));

        List<WebElement> optionsList =  operatorDropdown.getOptions();

        for(WebElement option:optionsList) {
            System.out.println(option.getText());
        }

        System.out.println("Size of the operator drop down: " + optionsList.size());
        fieldDropdown.selectByValue("CreatedDate");



        Select AvailableFieldsDropDown = new Select(driver.findElement(By.xpath("   //select[@id='colselector_select_0']")));

        List<WebElement> AvailableFieldsDropDownList =  AvailableFieldsDropDown.getOptions();

        System.out.println("Available Field List \n **************************************************************");
        for(WebElement availableField:AvailableFieldsDropDownList) {
            System.out.println(availableField.getText());
        }

        Select SelectedFieldsDropDown = new Select(driver.findElement(By.xpath("   //select[@id='colselector_select_0']")));

        List<WebElement> SelectedFieldsDropDownList =  SelectedFieldsDropDown.getOptions();


        System.out.println("Selected Field List \n **************************************************************");
        for(WebElement selectedField:SelectedFieldsDropDownList) {
            System.out.println(selectedField.getText());
        }

        System.out.println("********************************************************");

        AvailableFieldsDropDown.selectByValue("ScheduleDate");
        driver.findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@title='Add']")).click();


        boolean fieldfound = false;
        SelectedFieldsDropDown = new Select(driver.findElement(By.xpath("   //select[@id='colselector_select_1']")));
        List<WebElement> selectedFieldList = SelectedFieldsDropDown.getOptions();
        for(WebElement selected: selectedFieldList) {
            System.out.println(selected.getText());
            if(selected.getText().equals("Scheduled Provisioning Time"))  {
                fieldfound=true;
                break;
            }
        }
        System.out.println(fieldfound ? "field is found": "field is not found");
        Assert.assertTrue(fieldfound);

        driver.findElement(By.xpath("//input[@id='fsharefshareall']")).click();
        driver.findElement(By.xpath("(//input[@name='save'])[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Muthu']")).isDisplayed());

        System.out.println(driver.getTitle());
    }
}
