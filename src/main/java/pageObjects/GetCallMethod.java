package pageObjects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import restCalls.ResponseBody;
import restCalls.RestApiHelper;
import restCalls.RestResponse;

import java.util.LinkedHashMap;
import java.util.Map;

public class GetCallMethod {

    WebDriver driver;
    public GetCallMethod(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    RestResponse response = null;
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.serializeNulls().setPrettyPrinting().create();
    ResponseBody body= null;

    public void testGetPingAlive(String url) {
        response = RestApiHelper.performGetRequest(url,null);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    public void responseContainsString(String expectedString){
        boolean condition = true;
        Assert.assertEquals( condition , response.getResponseBody().contains(expectedString));
    }

    public void validateResponseCode(int responseCode){
        Assert.assertEquals(responseCode, response.getStatusCode());
    }

    public void testPost(String url,String jsonBody) {

        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json");
        response = RestApiHelper.performPostRequest(url, jsonBody, ContentType.APPLICATION_JSON, headers);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
        body = gson.fromJson(response.getResponseBody(), ResponseBody.class);
    }
    
    public void validateResponseTitle(String title){
        Assert.assertEquals(title, body.getTitle());
    }
    
    public void validateResponseBody(String bodyValue){
        Assert.assertEquals(bodyValue, body.getBody());
    }
}
