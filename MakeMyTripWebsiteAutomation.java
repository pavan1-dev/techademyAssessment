import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class MakeMyTripWebsiteAutomation {

    static WebDriver driver;

    public static void launchBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public static void main(String[] args) throws InterruptedException {

        launchBrowser("https://www.makemytrip.com/");

        // Close login popup if needed or opening in new webpage
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".commonModal__close")).click();

        driver.findElement(By.xpath("//span[text()='Flights']")).click();

        driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();

        driver.findElement(By.id("fromCity")).click();
        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromInput.sendKeys("Cuddapah");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[contains(text(),'Cuddapah')]")).click();

        driver.findElement(By.id("toCity")).click();
        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toInput.sendKeys("Sweden");

        Thread.sleep(2000);
        driver.findElement(By.className("revampedCityName")).click();
     

        Thread.sleep(3000);
        driver.quit();
    }
}

