package stepDefinations;

import io.cucumber.java.en.Given;
import stepDefinationsImplementation.StepDefinationImplementation;

public class StepDefinations {

    StepDefinationImplementation stepDefinationImplementation = new StepDefinationImplementation();
    @Given("user navigate to the website DemoQA")
    public void user_navigate_to_the_website_demo_qa() {
        stepDefinationImplementation.openURL();
        System.out.println("User navigate to the website DemoQA - Completed");
    }

    @Given("user login to the website")
    public void user_login_to_the_website() {
        stepDefinationImplementation.loginUser();
        System.out.println("User login to website - Completed");
    }

    @Given("user click on Form")
    public void user_click_on_form() {
        stepDefinationImplementation.clickOnFormsTab();
    }

    @Given("user click on Practice Form")
    public void user_click_on_practice_form() {
        stepDefinationImplementation.clickOnPracticeFormOption();
    }

    @Given("user fill all the form and click on the submit button")
    public void user_fill_all_the_form_and_click_on_the_submit_button() throws InterruptedException {
        stepDefinationImplementation.fillAndSubmitForm();
    }

}
