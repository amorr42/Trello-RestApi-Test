package pages;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import io.restassured.http.Method;

public class CardPage extends BoardPage {
	
	public List<String> cardID= new ArrayList<>();
	
	public void createCard(String cardName ){
        JSONObject params = new JSONObject();
        params.put("key", KEY);
        params.put("token",TOKEN);
        params.put("name", cardName);
        params.put("idList", boardID);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(params.toString());
        response = httpRequest.request(Method.POST,"/cards");
        cardID.add(response.jsonPath().getString("id"));
    }

    public void updateCard(String cardName, int random){

        String id = cardID.get(random);
        JSONObject params = new JSONObject();
        params.put("key", KEY);
        params.put("token",TOKEN);
        params.put("name", cardName);
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(params.toString());
        response = httpRequest.request(Method.PUT,"/cards/" + id);

    }

	public void deleteCard(int index) {
		
		 String id = cardID.get(index);
		 JSONObject params = new JSONObject();
		 params.put("key", KEY);
		 params.put("token",TOKEN);
	     httpRequest.header("Content-type", "application/json");
	     httpRequest.body(params.toString());
	     response = httpRequest.request(Method.DELETE,"/cards/" + id);
		
	}

	
}
