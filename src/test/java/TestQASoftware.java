import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestQASoftware {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        //webdrivermanager for chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(opt);

        //navigate to url
        String url = "https://stage.mobipaid.com/en/register";
        driver.get(url);
    }

    @Test
    public void userCanAccessTheWebsiteURL() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Register");
    }
    @Test
    public void userSuccessRegisterWithValidCredential()throws InterruptedException{
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
        firstName.sendKeys("Am");
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last name']"));
        lastName.sendKeys("Tester");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("amtester@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Tester123#");
        WebElement companyName = driver.findElement(By.xpath("//input[@placeholder='Company name']"));
        companyName.sendKeys("Pranala Ragam Karya");
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='tel']"));
        phoneNumber.sendKeys("82212345678");
        WebElement country =driver.findElement(By.xpath("//select[@id='country']"));
        country.click();
        WebElement selectCountry=driver.findElement(By.xpath("(//option[@value='2'])[2]"));
        selectCountry.click();
        WebElement checkbox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement netxbtn = driver.findElement(By.xpath("(//button[@id='btn-register'])[1]"));
        netxbtn.click();
    }
    @AfterTest
    public void tearDown(){
        //close the browse
        driver.close();
    }
}