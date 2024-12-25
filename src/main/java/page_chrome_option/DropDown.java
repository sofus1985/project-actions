package page_chrome_option;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DropDown  extends Base {



        @FindBy(xpath = "//div[@id='subjectsContainer']")
        public WebElement subjectDropDown;

        public DropDown() {
            PageFactory.initElements(driver, this);
        }




    public void selectSubject() {
            // Ensure the dropdown is visible and clickable
         waitForVisibility(subjectDropDown);

        // Scroll into view and click using JavaScript
        scrollToViewAndClick(subjectDropDown);

        // Find input field inside dropdown and type "m"
        WebElement inputField = subjectDropDown.findElement(By.tagName("input")); sendKeysToElement(inputField, "m");

        // Ensure the "Maths" option is visible and clickable
        WebElement mathsOption = driver.findElement(By.xpath("//div[contains(text(), 'Maths')]"));
        waitForVisibility(mathsOption);
        // Scroll into view and click "Maths" option using JavaScript
         scrollToViewAndClick(mathsOption);

         }


//        public void selectSubject() {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
//
//            // Wait for the dropdown to be clickable
//            wait.until(ExpectedConditions.elementToBeClickable(subjectDropDown));
//
//            // Scroll into view and click using JavaScript
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjectDropDown);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subjectDropDown);
//
//            // Type "m" into the input field
//            WebElement inputField = subjectDropDown.findElement(By.tagName("input"));
//            inputField.sendKeys("m");
//
//            // Select "Maths" from the dropdown options
//            WebElement mathsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Maths')]")));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mathsOption);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mathsOption);
//        }

    }



