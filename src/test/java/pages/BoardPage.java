package pages;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import testBase.BasePage;

public class BoardPage extends BasePage{
	
	protected String boardID="";
	
	public void createBoard(String boardName){
        JSONObject params = new JSONObject();
        params.put("key", KEY);
        params.put("token", TOKEN);
        params.put("name", boardName);
        httpRequest = RestAssured.given();
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(params.toString());
        response = httpRequest.request(Method.POST,"/boards");
        boardID = response.jsonPath().getString("id");
    }
	
	 public void deleteBoard(){
	        JSONObject params = new JSONObject();
	        params.put("key", KEY);
	        params.put("token",TOKEN);
	        httpRequest.header("Content-type", "application/json");
	        httpRequest.body(params.toString());
	        response = httpRequest.request(Method.DELETE,"/boards/" + boardID);
	    }
}
