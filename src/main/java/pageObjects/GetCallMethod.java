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
        //String url = "http://localhost:8080/laptop-bag/webapi/api/ping/hello";
        response = RestApiHelper.performGetRequest(url,null);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        System.out.println(response.getStatusCode());
//        Assert.assertEquals("Hi! hello", response.getResponseBody());
        System.out.println(response.getResponseBody());
    }

    public void responseContainsString(String expectedString){
        expectedString = expectedString.replace("DoubleQuote","\"");
        boolean condition = true;
        Assert.assertEquals( condition , response.getResponseBody().contains(expectedString));
    }

    public void validateResponseCode(int responseCode){

        Assert.assertEquals(responseCode, response.getStatusCode());

    }

    public void testPost(String url,String jsonBody) {

        jsonBody= jsonBody.replace("D_Q","\"");
//        String jsonBody = "{" +
//                "\"BrandName\": \"Dell\"," +
//                "\"Features\": {" +
//                "\"Feature\": [\"8GB RAM\"," +
//                "\"1TB Hard Drive\"]"+
//                "}," +
//                "\"Id\": " + id + "," +
//                "\"LaptopName\": \"Latitude\"" +
//                "}";

        Map<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-Type", "application/json");
        response = RestApiHelper.performPostRequest(url, jsonBody, ContentType.APPLICATION_JSON, headers);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
        System.out.println("response body====================================="+response.getResponseBody());

        body = gson.fromJson(response.getResponseBody(), ResponseBody.class);


    }

    public void validateResponseTitle(String title){

        Assert.assertEquals(title, body.getTitle());

    }

    public void validateResponseBody(String bodyValue){

        Assert.assertEquals(bodyValue, body.getBody());

    }

//    public void testGetFindwithId() {
//        String url = "http://localhost:8080/laptop-bag/webapi/api/find/127";
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Accept", "application/json");
//        RestResponse response = RestApiHelper.performGetRequest(url,headers);
//        Assert.assertTrue("Expected status Code not found",(HttpStatus.SC_OK == response.getStatusCode()) || (HttpStatus.SC_NOT_FOUND == response.getStatusCode()));
//        //System.out.println(response.getResponseBody());
//        /**
//         * Step 1 :- Use the GSON builder class to get the instance of GSON class
//         * Step 2 :- Use the Gson object to deseralize the json
//         * */
//        if(HttpStatus.SC_NOT_FOUND != response.getStatusCode()){
//            GsonBuilder builder = new GsonBuilder();
//            Gson gson = builder.serializeNulls().setPrettyPrinting().create();
//            ResponseBody body = gson.fromJson(response.getResponseBody(), ResponseBody.class);
//            Assert.assertEquals("Dell", body.getBrandName());
//            Assert.assertEquals("127", body.getId());
//            Assert.assertEquals("Latitude", body.getLaptopName());
//        }



}
