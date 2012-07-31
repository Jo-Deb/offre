package com.sfeir.labs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class RequeteClient {
	private static final String JSON_URL = GWT.getModuleBaseURL()+"A compléter";
	private String url = URL.encode(JSON_URL);
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,url);
	
	public RequeteClient(String mois, int year){
		try{
			builder.sendRequest(null, new RequestCallback() {
				
				public void onResponseReceived(Request request, Response response) {
					// TODO Auto-generated method stub
					if (200==response.getStatusCode()){
						String fromServlet = response.getText();
						JSONValue jsonValue = JSONParser.parseStrict(fromServlet);
						JSONArray jsonArray = jsonValue.isArray();
						JsArray<JavaScriptObject> data = jsonArray.getJavaScriptObject().cast();
					}
				}
				
				public void onError(Request request, Throwable exception) {
					System.out.println("Couldn't retrieve JSON");
					
				}
			});
		}catch (RequestException e) {
			System.out.println("Couldn't retrieve JSON");
		}
	}
}
