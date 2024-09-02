package stepDefinations;

import io.cucumber.java.en.Given;
import pageFactory.PageBookStoreApplication;

import pageFactory.PageElementsButtons;
import pageFactory.PageElementsWebTables;
import pageFactory.PageForms;
import supportingClasses.DatabaseMethods;

import java.sql.ResultSet;

public class StepDefinations {

    public PageBookStoreApplication pageBookStoreApplication = new PageBookStoreApplication();
    public PageForms pageForms = new PageForms();
    public PageElementsWebTables pageElementsWebTables = new PageElementsWebTables();
    public PageElementsButtons pageElementsButtons = new PageElementsButtons();
    public DatabaseMethods databaseMethods = new DatabaseMethods();

    @Given("user navigate to the website DemoQA")
    public void user_navigate_to_the_website_demo_qa() {
        pageBookStoreApplication.openURL();
        System.out.println("User navigate to the website DemoQA - Completed");
    }

    @Given("user login to the website")
    public void user_login_to_the_website() {
        pageBookStoreApplication.loginUser();
        System.out.println("User login to website - Completed");
    }

    @Given("user click on Form")
    public void user_click_on_form() {
        pageForms.clickOnFormsTab();
    }

    @Given("user click on Practice Form")
    public void user_click_on_practice_form() {
        pageForms.clickOnPracticeFormOption();
    }

    @Given("user fill all the form and click on the submit button")
    public void user_fill_all_the_form_and_click_on_the_submit_button() throws InterruptedException {
        pageForms.fillAndSubmitForm();
    }

    @Given("user click on Elements")
    public void user_click_on_elements() {
        pageElementsWebTables.clickOnTabElements();
    }
    @Given("user click on WebTables")
    public void user_click_on_web_tables() {
        pageElementsWebTables.clickOnOptionWebTables();
    }

    @Given("user add a record in WebTable and store Email value into {string}")
    public void user_add_a_record_in_web_table_and_store_email_value_into(String string) {
        pageElementsWebTables.clickOnbtnAdd();
        pageElementsWebTables.fillRegistrationForm(string);
    }

    @Given("user search record for value {string}")
    public void user_edit_searched_record(String string) {
        pageElementsWebTables.searchRecord(string);
    }

    @Given("user edit searched record")
    public void user_edit_searched_record() {
        pageElementsWebTables.editRecord();
    }

    @Given("user store data into database for newly created record")
    public void user_store_data_into_database_for_newly_created_record() {
        pageElementsWebTables.saveRecord();
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
        pageElementsWebTables.deleteRecord(string);
    }

    @Given("user click on Buttons")
    public void user_click_on_buttons() {
        pageElementsButtons.clickOnOptionButtons();
    }

    @Given("verify Double Click Me button is working")
    public void verify_double_click_me_button_is_working() {
        pageElementsButtons.clickOnbtnDoubleClickMe();
    }

    @Given("verify Right Click Me button is working")
    public void verify_right_click_me_button_is_working() {
        pageElementsButtons.clickOnbtnRightClickMe();
    }

    @Given("verify Click Me button is working")
    public void verify_click_me_button_is_working() {
        pageElementsButtons.clickOnbtnClickMe();
    }
}
