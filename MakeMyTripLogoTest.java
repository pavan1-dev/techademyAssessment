import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripLogoTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");
        Thread.sleep(3000);

        WebElement logo = driver.findElement(By.cssSelector(".mmtLogo"));

        if (logo.isDisplayed()) {
            System.out.println("MakeMyTrip Logo is Present");
        } else {
            System.out.println("MakeMyTrip Logo is NOT Present");
        }

        driver.quit();
    }
}
