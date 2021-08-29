package testBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Before;

public class BasePage {
	
	public static RequestSpecification httpRequest;
    public static Response response;
    public static final String KEY = "86a1366f2f5eb76e634622567ec9e06b";
    public static final String TOKEN = "fe05e1e7bcecdddd97f00968c9aee6c5debec6c96b5cb782210ad8bf3ae2f0f5";

    @Before
    public void before(){

        RestAssured.baseURI= "https://api.trello.com/1";

    }

}
