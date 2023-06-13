import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addToCart() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("test@testing.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Testing123");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("SILVER DESERT NECKLACE");
        driver.findElement(By.cssSelector("button[title='Search']")).click();
        driver.findElement(By.cssSelector("#product-collection-image-553")).click();
        driver.findElement(By.cssSelector("button[onclick*='productAdd'] ")).click();
        WebElement successMessage = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertEquals("Silver Desert Necklace was added to your shopping cart.", successMessage.getText());

    }

    @After
    public void close() {
        driver.quit();
    }
}
