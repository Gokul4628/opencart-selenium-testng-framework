import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class standAloneTest {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Arnold");
        driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("termin");
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("arnold7@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("arnold7");
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();
    }
}
