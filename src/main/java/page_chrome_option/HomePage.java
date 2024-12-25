package page_chrome_option;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {


    @FindBy(xpath = "//input[@name = 'username']")
    public WebElement inputFieldUsername;
    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement inputFieldPassword;
    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement submitButton;

    public HomePage(){

        PageFactory.initElements(driver, this);
    }

//    public void clickButtonModel(){
//        buttonModel.click();
//    }
    public void typeUserName(String user) {

        sendKeysToElement(inputFieldUsername,user);
    }
    public void typePassword(String password) {
        sendKeysToElement(inputFieldPassword,password);
    }

    public void submit() {

        clickOnElementWithScreenShot(submitButton);
    }
    public void mainLogin(){
        typeUserName("Admin");
        typePassword("admin123");
        submit();
    }
}
