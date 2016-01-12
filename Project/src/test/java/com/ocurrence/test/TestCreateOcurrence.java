package com.ocurrence.test;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.software.project.entities.adapter.Attributes;
import com.software.project.entities.adapter.Entity;
import com.software.project.entities.adapter.Metadata;
import com.software.project.service.adapter.AdapterOcurrence;


public class TestCreateOcurrence {

/*	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateNew()  {
		  String result = "";  
			String line = "";
			String id = String.valueOf("66960489");
		    Entity entity = new Entity();
			List<Attributes> attributes = new ArrayList<Attributes>();
			attributes.add(new Attributes("title", "String", "CPA", null));
			List<Metadata> metadatas = new ArrayList<Metadata>();
			metadatas.add(new Metadata("location", "String", "WGS84"));
			attributes.add(new Attributes("GPSCoord","coords","-8.057205964543307, -34.87112045288086",metadatas));
			attributes.add(new Attributes("endereco", "String", "Endereco qualquer", null));
			attributes.add(new Attributes("dataOcorrencia", "String",AdapterOcurrence.df.format(Calendar.getInstance().getTime()),null)); 
			attributes.add(new Attributes("userId", "String", "1",null)); 
			
			entity.setType("Ocurrence");
			entity.setId(id);
			entity.setAttributes(attributes);

			Gson gson;
			String uri = "http://148.6.80.19:1026/v1/contextEntities";
			
			
			int responseCode = 0;

			try {
				HttpClient client = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(uri);
			    httppost.setHeader("Accept", "application/json");
				gson = new Gson();
				StringEntity entityPost = new StringEntity(gson.toJson(entity));
				entityPost.setContentType("application/json");
				
				
				httppost.setEntity(entityPost);

				int executeCount = 0;
				HttpResponse response;
				do {
					executeCount++;
					//Log.v("TENTATIVA", "tentativa número:" + executeCount);

					// Execute HTTP Post Request
					response = client.execute(httppost);
					responseCode = response.getStatusLine().getStatusCode();						

				} while (executeCount < 5 && responseCode == 408);

				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

				while ((line = rd.readLine()) != null){
					result += line.trim();
				}

			      
			} catch (Exception e) {
				responseCode = 408;
				e.printStackTrace();
				fail("Not yet");
			}
			
			
	    String s = "{ \"type\" : \"Position\",\"isPattern\" : \"false\", " +
	    		"\"id\" : \"358972063059834\",\"contextResponses\" : " +
	    		"[{\"attributes\" : [{\"name\" : \"latitude\",\"type\" : " +
	    		"\"String\",\"value\" : \"\"},{\"name\" : \"longitude\"," +
	    		"\"type\" : \"String\",\"value\" : \"\"}],\"statusCode\" : " +
	    		"{\"code\" : \"200\",\"reasonPhrase\" : \"OK\"}}]}";
	    
	    
	}*/


}
