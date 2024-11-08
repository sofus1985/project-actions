package page_chrome_option;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {


    @FindBy(xpath = "//div[@class ='cell topicons']/a[1]")
    public WebElement buttonModel;


    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    public void clickButtonModel(){
        buttonModel.click();
    }
}
