package com.ocurrence.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.google.gson.Gson;


public class TesteDeleteOcurrence {
/*
	@Test
	public void delete()  {
		String uri = "http://148.6.80.19:1026/v1/contextEntities/358";
		int responseCode = 0;
		String result = "";  
		String line = "";
		HttpClient client;
		HttpResponse response;
		Gson gson;
		BufferedReader rd;
		try {
			client = new DefaultHttpClient();
			HttpDelete httpdelete = new HttpDelete(uri);
			httpdelete.setHeader("Accept", "application/json");
			httpdelete.setHeader("Content-type", "application/json");
			gson = new Gson();
			int executeCount = 0;
			do {
				executeCount++;
				response = client.execute(httpdelete);
				responseCode = response.getStatusLine().getStatusCode();						
			} while (executeCount < 5 && responseCode == 408);
			      rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = rd.readLine()) != null){
				result += line.trim();
			}	      
		} catch (Exception e) {
			responseCode = 408;
			e.printStackTrace();
		}
	   String s = "{\"code\" : \"200\",\"reasonPhrase\" : \"OK\"}";
	   
	   
	
	}*/

}
