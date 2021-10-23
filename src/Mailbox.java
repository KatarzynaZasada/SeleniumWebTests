import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class Mailbox {

    public void onetMailMethod() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Katarzyna\\Desktop\\NewTesterProject\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://konto.onet.pl/signin?client_id=poczta.onet.pl.front.onetapi.pl");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[6]/button[2]")).click();
        driver.findElement(By.name("email")).sendKeys("testerselenium@onet.pl");
        driver.findElement(By.name("email")).sendKeys(Keys.ENTER);
        Thread.sleep(2500);
        driver.findElement(By.id("password")).sendKeys("tester.selenium1");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        sendingEmail(driver);
        makingScreenshots(driver);

    }

    // sending Email

    private void sendingEmail(WebDriver driver) throws InterruptedException {
        String mailTitle;
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.xpath("/html/body/main/div/div[8]/div[4]/aside/div[1]/div/span")).click();
            Thread.sleep(5000);
            driver.findElement(By
                    .xpath("/html/body/main/div/div[8]/div[4]/div/div[1]/section/div[2]/div[2]/div/div/div/div/input"))
                    .sendKeys("testerselenium@onet.pl");
            driver.findElement(By
                    .xpath("/html/body/main/div/div[8]/div[4]/div/div[1]/section/div[2]/div[2]/div/div/div/div/input"))
                    .click();
            Thread.sleep(2500);
            mailTitle = "Title " + i;
            Thread.sleep(2500);
            driver.findElement(
                    By.xpath("/html/body/main/div/div[8]/div[4]/div/div[1]/section/div[2]/div[3]/div/div/div/input"))
                    .sendKeys(mailTitle);
            Thread.sleep(2500);
            driver.switchTo().frame("CONTENT_TEXTAREA_ID_ifr");
            Thread.sleep(2500);
            driver.findElement(By.id("tinymce")).sendKeys("Treść maila");
            Thread.sleep(4000);
            driver.switchTo().defaultContent();
            Thread.sleep(2500);
            driver.findElement(
                    By.xpath("/html/body/main/div/div[8]/div[4]/div/div[1]/section/div[1]/div/ul[1]/li[2]/button"))
                    .click();
            Thread.sleep(2500);
        }
    }

    // making screenshots
    private void makingScreenshots(WebDriver driver) throws InterruptedException, IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("C:\\screenshot\\screen.png"));
    }
}
