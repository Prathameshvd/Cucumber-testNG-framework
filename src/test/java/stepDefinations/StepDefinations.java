package stepDefinations;

import io.cucumber.java.en.Given;
import pageFactory.PageElements;
import stepDefinationsImplementation.StepDefinationImplementation;
import supportingClasses.DatabaseMethods;

import java.sql.ResultSet;

public class StepDefinations {

    public StepDefinationImplementation stepDefinationImplementation = new StepDefinationImplementation();
    public PageElements pageElements = new PageElements();
    public DatabaseMethods databaseMethods = new DatabaseMethods();

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

    @Given("user click on Elements")
    public void user_click_on_elements() {
        pageElements.clickOnTabElements();
    }
    @Given("user click on WebTables")
    public void user_click_on_web_tables() {
        pageElements.clickOnOptionWebTables();
    }

    @Given("user add a record in WebTable and store Email value into {string}")
    public void user_add_a_record_in_web_table_and_store_email_value_into(String string) {
        pageElements.clickOnbtnAdd();
        pageElements.fillRegistrationForm(string);
    }

    @Given("user search record for value {string}")
    public void user_edit_searched_record(String string) {
        pageElements.searchRecord(string);
    }

    @Given("user edit searched record")
    public void user_edit_searched_record() {
        pageElements.editRecord();
    }

    @Given("user store data into database for newly created record")
    public void user_store_data_into_database_for_newly_created_record() {
        pageElements.saveRecord();
        System.out.println("Yet to implement");
    }

    @Given("user fetch DB export for the newly created customer")
    public void user_fetch_DB_export_for_the_newly_created_customer() {
        ResultSet rs = databaseMethods.getWebTableRecordDataFromDatabase();
        databaseMethods.storeDataIntoExcelFile(rs);
        System.out.println("Yet to implement");
    }


    @Given("user delete record for value {string}")
    public void user_delete_record_for_value(String string) {
        pageElements.deleteRecord(string);
        System.out.println("Yet to implement");
    }
}
