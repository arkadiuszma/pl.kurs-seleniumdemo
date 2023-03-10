package Tests;

import Utils.FileHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
public abstract class BaseTest {
    protected WebDriver driver;
    private final String browser = FileHandler.getProperty("browser");
    private final String url = FileHandler.getProperty("url");

    @BeforeEach
    protected void setupDriver() {
        switch (browser) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
            case "EDGE" -> driver = new EdgeDriver();
            case "FIREFOX" -> driver = new FirefoxDriver();
            default -> System.out.println("Wrong browser name");
        }
        runWebsite(url);
    }

    @AfterEach
    protected void tearDown() {
        driver.quit();
        log.info("Test completed. Browser was closed.");
    }

    private void runWebsite(String url) {
        log.info("Browser " + browser + " is running");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}