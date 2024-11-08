package test_home_page;
import Base.Base;
import org.testng.annotations.Test;
import page_chrome_option.HomePage;


public class TestHomePage extends Base {

    HomePage homePage;
    @Test
    public void testHomepage(){

        homePage = new HomePage();
        homePage.clickButtonModel();

//
//      WebElement buttonModel =webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Models']")));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", buttonModel);


    }
}
