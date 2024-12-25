package test_home_page;

import Base.Base;
import org.testng.annotations.Test;
import page_chrome_option.DropDown;

public class TestDropDownNotVisible extends Base {

    DropDown dropDown;
    @Test
    public void testSubjectDropDown(){
        dropDown= new DropDown();
        System.out.println("the element is displayed : " +dropDown.subjectDropDown.isDisplayed());

        // Call the method to assert element visibility
         assertElementIsVisible(dropDown.subjectDropDown);

        dropDown.selectSubject();

    }


}
