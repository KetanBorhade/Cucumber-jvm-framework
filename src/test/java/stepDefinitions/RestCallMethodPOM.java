package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.GetCallMethod;

public class RestCallMethodPOM {

    TestContext testContext;
    GetCallMethod getCallMethodPOM;

    public RestCallMethodPOM(TestContext context) {
        testContext = context;
        getCallMethodPOM = testContext.getPageObjectManager().getGetMethodPOM();
    }

    @Given("^user perform get call on \"([^\"]*)\" url$")
    public void user_perform_get_call_on(String url){
        getCallMethodPOM.testGetPingAlive(url);

    }

    @Then("^verify response contains \"([^\"]*)\" string$")
    public void verify_response_contains_string(String value){
        getCallMethodPOM.responseContainsString(value);

    }

    @Given("^user perform get post call on \"([^\"]*)\" url with \"([^\"]*)\" json$")
    public void user_perform_post_call_with_json(String url,String json){
        getCallMethodPOM.testPost(url,json);

    }

    @Then("^verify response \"([^\"]*)\" code$")
    public void verify_response_contains_string(int value){
        getCallMethodPOM.validateResponseCode(value);

    }

    @Then("^verify post call \"([^\"]*)\" body value$")
    public void verify_post_call_body_value(String value){
        getCallMethodPOM.validateResponseBody(value);

    }

    @Then("^verify post call \"([^\"]*)\" title value$")
    public void verify_post_call_title_value(String value){
        getCallMethodPOM.validateResponseTitle(value);
    }

}
