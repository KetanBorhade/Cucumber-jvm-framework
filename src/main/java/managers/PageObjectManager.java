package managers;


import org.openqa.selenium.WebDriver;
import pageObjects.GetCallMethod;
import pageObjects.TodoLhpPOM;

public class PageObjectManager {
    private WebDriver driver;


    private TodoLhpPOM todoLhpPOM;
    private GetCallMethod getCallMethod;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public GetCallMethod getGetMethodPOM(){
        return (getCallMethod == null) ? getCallMethod = new GetCallMethod(driver) : getCallMethod;
    }

    public TodoLhpPOM getTodoLhpPOM(){
        return (todoLhpPOM == null) ? todoLhpPOM = new TodoLhpPOM(driver) : todoLhpPOM;
    }

}

