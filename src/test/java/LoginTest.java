import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void loginWithValidCredentials() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("test@testing.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Testing123");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeText = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertEquals("Hello, Test T Test!", welcomeText.getText());
        Assert.assertTrue(welcomeText.isDisplayed());

    }

    @Test
    public void loginWithInvalidPassword() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("test@testing.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("test123");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement errorTextElement = driver.findElement(By.cssSelector(".error-msg span"));
        Assert.assertEquals("Invalid login or password.", errorTextElement.getText());


    }

    @Test
    public void loginWithoutMandatoryFields() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#.skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement emailErrorMessage = driver.findElement(By.id("advice-required-entry-email"));
        Assert.assertEquals("This is a required field.", emailErrorMessage.getText());
        WebElement passwordErrorMessage = driver.findElement(By.id("advice-required-entry-pass"));
        Assert.assertEquals("This is a required field.", passwordErrorMessage.getText());

    }


    @After
    public void close() {
        driver.quit();
    }
}
