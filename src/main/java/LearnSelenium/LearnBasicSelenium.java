package LearnSelenium;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class LearnBasicSelenium {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("DemosalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        System.out.println(driver.findElement(By.className("decorativeSubmit")).getText());
        System.out.println(driver.findElement(By.className("decorativeSubmit")).getTagName());
        driver.findElement(By.className("decorativeSubmit")).click();
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompany");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("MuthuKrishnan");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Pandian");
        driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Muthukrishnan");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QE");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QE");
        driver.findElement(By.name("description")).sendKeys("This is a sample description");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@test.com");

        List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
        for(WebElement wb:dropdowns) {
            Select dd = new Select(wb);
            dd.selectByIndex(2);
            if(wb.getAttribute("id").equals("createLeadForm_generalStateProvinceGeoId")) {
                 List<WebElement> stateProvince =  dd.getOptions();
                 for(WebElement states:stateProvince) {
                     System.out.println(states.getText());
                 }
            }

        }

        driver.findElement(By.className("smallSubmit")).click();

        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateLeadForm_description")).clear();
        driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("this is a test");
        driver.findElement(By.name("submitButton")).click();

        System.out.println(driver.getTitle());

        String title1 = driver.getTitle();
        System.out.println(title1);


        driver.close();

    }

    @Test
    public void Excercise3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("DemosalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        System.out.println(driver.findElement(By.className("decorativeSubmit")).getText());
        System.out.println(driver.findElement(By.className("decorativeSubmit")).getTagName());
        driver.findElement(By.className("decorativeSubmit")).click();
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompany");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("MuthuKrishnan");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Pandian");
        driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Muthukrishnan");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QE");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QE");
        driver.findElement(By.name("description")).sendKeys("This is a sample description");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@test.com");

        List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
        for(WebElement wb:dropdowns) {
            Select dd = new Select(wb);
            dd.selectByIndex(2);
            if(wb.getAttribute("id").equals("createLeadForm_generalStateProvinceGeoId")) {
                List<WebElement> stateProvince =  dd.getOptions();
                for(WebElement states:stateProvince) {
                    System.out.println(states.getText());
                }
            }

        }

        driver.findElement(By.className("smallSubmit")).click();

        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateLeadForm_description")).clear();
        driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("this is a test");
        driver.findElement(By.name("submitButton")).click();

        System.out.println(driver.getTitle());

        String title1 = driver.getTitle();
        System.out.println(title1);


        driver.close();
    }

    @Test
    public void excercise2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://www.leafground.com/pages/Link.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        allLinks.get(0).click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        List<WebElement> allLinks2 = driver.findElements(By.tagName("a"));
        System.out.println(allLinks2.size());
        System.out.println(allLinks2.get(2).getAttribute("href"));

        driver.close();

    }

    @Test
    public void Excercise1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("DemosalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        System.out.println(driver.findElement(By.className("decorativeSubmit")).getText());
        System.out.println(driver.findElement(By.className("decorativeSubmit")).getTagName());
        driver.findElement(By.className("decorativeSubmit")).click();
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompany");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("MuthuKrishnan");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Pandian");
        driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Muthukrishnan");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QE");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QE");
        driver.findElement(By.name("description")).sendKeys("This is a sample description");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@test.com");

        List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
        for(WebElement wb:dropdowns) {
            Select dd = new Select(wb);
            dd.selectByIndex(2);
            if(wb.getAttribute("id").equals("createLeadForm_generalStateProvinceGeoId")) {
                List<WebElement> stateProvince =  dd.getOptions();
                for(WebElement states:stateProvince) {
                    System.out.println(states.getText());
                }
            }

        }

        driver.findElement(By.className("smallSubmit")).click();

        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateLeadForm_description")).clear();
        driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("this is a test");
        driver.findElement(By.name("submitButton")).click();

        System.out.println(driver.getTitle());

        String title1 = driver.getTitle();
        System.out.println(title1);


        driver.close();
    }
//
    @Before
    public void initializeDriver(){
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void xpathLearning() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://acme-test.uipath.com/login");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
        driver.close();


    }

    @Test
    public void learnXpath2() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.leafground.com/pages/Edit.html");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[contains(@value,'Append')]")).sendKeys(" appended Text");
        driver.findElement(By.xpath("//input[contains(@value,'Append')]")).sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//input[@name = 'username' and @value='TestLeaf']")).getAttribute("value");
        driver.findElement(By.xpath("//input[@name = 'username' and contains(@value,'Clear') ]")).clear();

        System.out.println(driver.findElement(By.xpath("//input[@type='text' and @disabled='true']")).isEnabled());

        driver.close();

    }

}
