package stepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.testng.annotations.BeforeClass;

public class StepDefinations {

    @BeforeClass
    public void fun()
    {
        System.out.println("Before Class");
    }

    @Given("user navigate to the website DemoQA")
    public void user_navigate_to_the_website_demo_qa() {
        System.out.println("User navigate to the website DemoQA");
    }
    @Given("user login to website")
    public void user_login_to_website() {
        System.out.println("User login to website");
    }
}
