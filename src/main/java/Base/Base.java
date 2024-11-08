package Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Arrays;


public class Base {
    public  static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public  static FirefoxOptions firefoxOptions;
    public  static EdgeOptions edgeOptions;
    public static WebDriverWait webDriverWait;
    public static Wait<WebDriver> fluentWait;
    //https://m.rediff.com/ https://the-internet.herokuapp.com/windows

    @Parameters({"driverConfigEnabled", "browser", "url"})
    @BeforeMethod
    public void driverSetup(@Optional("true") String driverConfigEnabled, @Optional("chrome") String browser, @Optional("https://m.rediff.com/") String url) {
        if (Boolean.parseBoolean(driverConfigEnabled)) {
            driverInit(browser);
            driver.get(url);

            driver.manage().deleteAllCookies();

        }
    }

    @Parameters({"driverConfigEnabled"})
    @AfterMethod
    public void cleanUp(@Optional("true") String driverConfigEnabled) {
        if (Boolean.parseBoolean(driverConfigEnabled)) {
            driver.quit();
        }
    }
    private static void driverInit(String browser) {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infoBars"));

        firefoxOptions = new FirefoxOptions();
        chromeOptions.addArguments("--start-maximized");
       // firefoxOptions.addArguments("--incognito");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        edgeOptions = new EdgeOptions();
        chromeOptions.addArguments("--start-maximized");
      // edgeOptions.addArguments("--incognito");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        edgeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infoBars"));

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(edgeOptions);
        } else {
            System.out.println("Browser is not matching");
        }
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);






    }
    // methods
    public void sendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void clickOnElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public boolean validationURL(WebDriver driver, String expURL){

        boolean result = false;
        if (driver.getCurrentUrl().equalsIgnoreCase(expURL)){
            result = true;
        }
        return result;
    }
}