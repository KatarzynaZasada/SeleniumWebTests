import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

    public void methodGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Katarzyna\\Desktop\\NewTesterProject\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.pl");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div[3]/button[2]/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("How to test all things in the world?");
        Thread.sleep(2500);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        driver.quit();

    }

}
