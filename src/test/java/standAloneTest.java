import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.ldap.LdapReferralException;
import java.time.Duration;
import java.util.List;

public class standAloneTest {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://naveenautomationlabs.com/opencart/");

        //account creation -------------
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Arnold");
        driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("termin");
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("arnold7@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("arnold7333");
        driver.findElement(By.id("input-confirm")).sendKeys("arnold7333");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();

        //login---------

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        driver.findElement(By.id("input-email")).sendKeys("testtst");
        driver.findElement(By.id("input-password")).sendKeys("hsdhashd");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

        //category selection ------

        // 1. Capture all top-level main menu elements
        List<WebElement> categories = driver.findElements(By.xpath("//*[@id='menu']/div[2]/ul/li/a"));

        // Define what you want to select
        String targetCategory = "Components";
        String targetSubMenu = "Monitors"; // Set this to "Show All Components" if you want the bottom option

        int index = 1;

        for (WebElement category : categories) {
            String categoryText = category.getText();

            if (categoryText.equalsIgnoreCase(targetCategory)) {
                // 2. Click the parent component to open and lock the dropdown menu
                category.click();

                // 3. Decide based on your target choice
                if (targetSubMenu.startsWith("Show All")) {
                    // Targets your "Show All" XPath: //*[@id="menu"]/div[2]/ul/li[index]/div/a
                    String showAllXPath = "//*[@id='menu']/div[2]/ul/li[" + index + "]/div/a";
                    driver.findElement(By.xpath(showAllXPath)).click();
                }
                else {
                    // Targets your Submenu List XPath: //*[@id="menu"]/div[2]/ul/li[index]/div/div/ul/li/a
                    // We fetch all sub-items inside this specific dropdown
                    String subMenuItemsXPath = "//*[@id='menu']/div[2]/ul/li[" + index + "]/div/div/ul/li/a";
                    List<WebElement> subMenuItems = driver.findElements(By.xpath(subMenuItemsXPath));

                    // Loop through the sub-items to find your match
                    for (WebElement subItem : subMenuItems) {
                        if (subItem.getText().trim().equalsIgnoreCase(targetSubMenu)) {
                            subItem.click();
                            break;
                        }
                    }
                }
                // Exit the main loop after handling the target category
                break;
            }
            index++;
        }



    //Item addition to cart


    }
}
