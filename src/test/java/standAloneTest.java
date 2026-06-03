import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class standAloneTest {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");

        //account creation -------------
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Arnold");
        driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("termin");
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("arnold7@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-telephone")).sendKeys("arnold7");
        driver.findElement(By.id("input-confirm")).sendKeys("arnold7");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();

        //login---------

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        driver.findElement(By.id("input-email")).sendKeys("testtst");
        driver.findElement(By.id("input-password")).sendKeys("hsdhashd");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
    }
}
