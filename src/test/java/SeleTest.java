import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleTest {
    WebDriver driver=new ChromeDriver();

    @Test
    void setup() {
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.quit();
    }


}
