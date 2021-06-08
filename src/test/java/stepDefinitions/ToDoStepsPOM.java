package stepDefinitions;


import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.TodoLhpPOM;

import java.util.List;



public class ToDoStepsPOM {

    TestContext testContext;
    TodoLhpPOM todoLhpPOM;

    public ToDoStepsPOM(TestContext context) {
        testContext = context;
        todoLhpPOM = testContext.getPageObjectManager().getTodoLhpPOM();
    }

    @Given("^user is on todo Home Page$")
    public void user_is_on_Home_Page(){
        todoLhpPOM.navigateTo_HomePage();
    }

    @When("^user enters text \"([^\"]*)\" in todo list$")
    public void user_enters_text_in_todo_list(String value)  {
        todoLhpPOM.EnterValueToList(value);
    }

    @Then("list values are as followed \"([^\"]*)\" in todo list$")
    public void list_values_are_as_followed(List<String> options)  {
            todoLhpPOM.list_values_are_as_followed(options);
    }

    @When("user click on link \"([^\"]*)\" in todo list$")
    public void user_click_on_link(String linkValue)  {
        todoLhpPOM.SelectLink(linkValue);
    }

    @Then("value \"([^\"]*)\" is added in todo list$")
    public void value_is_added_to_list(String option)  {
        todoLhpPOM.option_is_displayed_in_list(option);
    }

    @Then("value \"([^\"]*)\" is not displayed in todo list$")
    public void value_is_not_displayed_in_todo_list(String option)  {
        todoLhpPOM.option_is_not_displayed_in_list(option);
    }

    @When("select \"([^\"]*)\" from todo list$")
    public void select_item_from_todo_list(String option)  {
        todoLhpPOM.selectItemFromTodoList(option);
    }

    @When("^click button \"([^\"]*)\" from todo list$")
    public void click_button_from_todo_list(String option)  {
        todoLhpPOM.clickOnClearButton(option);
    }

    @When("^remove value \"([^\"]*)\" from todo list$")
    public void remove_value_from_todo_list(String option)  {
        todoLhpPOM.RemoveElementFromList(option);
    }
}
