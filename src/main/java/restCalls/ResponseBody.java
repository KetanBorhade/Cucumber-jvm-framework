package restCalls;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBody {
    private String title;
    private String id;
    private String userId;
    private String body;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String titleSet) {
        title = titleSet;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    public void setId(String idSet) {
        id = idSet;
    }
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userIdSet) {
        userId = userIdSet;
    }
    @JsonProperty("body")
    public String getBody() {
        return body;
    }
    public void setBody(String bodySet) {
        body = bodySet;
    }


}
