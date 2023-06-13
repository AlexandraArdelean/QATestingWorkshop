import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void registerWithValidCredentials() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title = 'Register']")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Test");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Test");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("test120@test.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("1234567");
        driver.findElement(By.cssSelector(".control label")).click();
        driver.findElement(By.cssSelector(".buttons-set button")).click();
        WebElement registerMessage = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertEquals("Thank you for registering with Madison Island.", registerMessage.getText());
    }

    @After
    public void close() {
        driver.quit();
    }

}
