package com.ocurrence.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.google.gson.Gson;
import com.software.project.entities.adapter.Entity;
import com.software.project.service.adapter.AdapterOcurrence;


public class TestRetrieveAllOcurrences {

	/*@Test
	public void testGetAll() throws Exception {
		Gson gson;
		String uri = "http://148.6.80.19:1026/v1/contextEntities";
		int responseCode = 0;
		String result = "";  
		String line = "";
		HttpClient client;

		try {
			client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(uri);
		    httpget.setHeader("Accept", "application/json");		
		    httpget.setHeader("Content-type", "application/json");
		    HttpResponse response;
			BufferedReader rd;

			int executeCount = 0;
			do {
				executeCount++;
				response = client.execute(httpget);
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
	   
		List<Entity> listEntity = AdapterOcurrence.parseListEntity(result);
		for (Entity entity : listEntity) {
			System.out.println(entity.getType());
		}
	    
	 //   JSONAssert.assertEquals(s, result, false);
	}
	*/
	

}
