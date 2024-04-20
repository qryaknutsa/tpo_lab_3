import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

import static java.lang.Thread.sleep;

public class ToRegistrationTest {
    public static String url = "https://drive.google.com/";
    public static WebDriver driver;

    public static String mainWindow;

    String menuBtn = "//button[@class='glue-header__drawer-toggle-btn']";
    String signInBtn = "//a[@class='glue-button glue-button--medium-emphasis']";

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.get(url);
        mainWindow = driver.getWindowHandle();
    }


    @AfterEach
    public void quit() throws InterruptedException {
        sleep(3000);
        driver.quit();
    }


    @Test
    public void registerTest() {
        String signin = "https://accounts.google.com/v3/signin";
        driver.findElement(By.xpath(signInBtn)).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Google Диск: вход в систему"))
                break;
        }
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(driver.getCurrentUrl().startsWith(signin));
    }


    @Test
    public void gmailTest() {
        String gmail = "https://www.google.com/gmail/about/?hl=ru";
        driver.findElement(By.xpath(menuBtn)).click();

        driver.findElement(By.xpath("//a[@href='https://www.google.com/gmail/about/?hl=ru']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals(gmail))
                break;
        }
        Assertions.assertEquals(gmail, driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void meetTest() {
        String meetings = "https://apps.google.com/meet/?hl=ru";
        driver.findElement(By.xpath(menuBtn)).click();

        driver.findElement(By.xpath("//a[@href='" + meetings + "']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().startsWith("Google Meet"))
                break;
        }
        Assertions.assertTrue(driver.getTitle().startsWith("Google Meet"));
    }


    @Test
    public void possibilitiesTest() {
        String possibilities = "#features";
        driver.findElement(By.xpath(menuBtn)).click();
        driver.findElement(By.xpath("//a[@href='" + possibilities + "']")).click();
    }



}
