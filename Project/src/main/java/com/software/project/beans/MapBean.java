package com.software.project.beans;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.software.project.entities.Ocorrencia;
import com.software.project.service.adapter.PersistenceEntity;

@Controller("mapBean")
@Scope("view")
public class MapBean implements Serializable {  
	  
	private MapModel advancedModel;  
	  
    private Marker marker;  
    private Ocorrencia ocorrenciaSelected;
    private Ocorrencia ocorrencia;
    private List<Ocorrencia> ocorrencias;
    private String qtdOcorrencias;
    private PieChartModel pieModel;  
   /* @Autowired
    OcorrenciaBO ocorrenciaBO;*/
    @Autowired
    PersistenceEntity persistenceEntity;
  
    
    public MapBean() {  
        advancedModel = new DefaultMapModel();  
        ocorrencia = new Ocorrencia();
    }  
    
    @PostConstruct
    public void init() throws Exception{
    	
    	qtdOcorrencias = String.valueOf(persistenceEntity.countOcorrencia());
    	
    	ocorrencias = persistenceEntity.getAll();
        if(ocorrencias.size()>0) {
         	 for (Ocorrencia ocorrencia : ocorrencias) {
             	  marker = new Marker(new LatLng(Double.valueOf(ocorrencia.getLat()), Double.valueOf(ocorrencia.getLng())), String.valueOf(ocorrencia.getIdOcorrencia()));  
             	 advancedModel.addOverlay(marker);
     		}
 		}
        createPieModel();
        createPolylines();
 
    }
    
    public void updateMap(){
    	
    	//TODO update markers properly
    	 for (int i = 0; i < advancedModel.getMarkers().size(); i++){
    		 Marker tmp = advancedModel.getMarkers().get(i);
    		 RequestContext.getCurrentInstance().addCallbackParam("marker" + i, tmp);             
    	 }
    }
    
    private void createPolylines(){
		JSONParser parser = new JSONParser();
		try {
			InputStream is = getClass().getResourceAsStream("/ciclo-faixa2-0.geojson");

			Reader reader = new InputStreamReader(is);

			
			Object obj = parser.parse(reader);

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray companyList = (JSONArray) jsonObject.get("features");
			Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
            	Polyline polyline = new Polyline();
            	JSONObject aux = iterator.next();
            	JSONObject geo = (JSONObject) aux.get("geometry");
            	JSONArray arr = (JSONArray) geo.get("coordinates");
            	//System.out.println(arr);
            	
            	Iterator<JSONArray> cordIt = arr.iterator();
                while (cordIt.hasNext()) {
                	JSONArray auxc = cordIt.next();
                	double lat = Double.parseDouble(auxc.get(1).toString());
                	double lng = Double.parseDouble(auxc.get(0).toString());
                	System.out.println(lat+" "+ lng);
                	polyline.getPaths().add(new LatLng(lat, lng));
                } 
                polyline.setStrokeWeight(2);
                polyline.setStrokeColor("#f05f40");
                polyline.setStrokeOpacity(1);
                advancedModel.addOverlay(polyline);
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		
       
    }
	private void createPieModel() throws Exception {  
        pieModel = new PieChartModel();  
  
        pieModel.set("CPA", persistenceEntity.countOcorrenciaByType("CPA"));  
        pieModel.set("COVP",  persistenceEntity.countOcorrenciaByType("COVP"));  
        pieModel.set("CVM2-3R", persistenceEntity.countOcorrenciaByType("CVM2-3R"));  
        pieModel.set("CACC",  persistenceEntity.countOcorrenciaByType("CACC")); 
        pieModel.set("CTPO",  persistenceEntity.countOcorrenciaByType("CTPO"));
        pieModel.set("CTVF",  persistenceEntity.countOcorrenciaByType("CTVF"));
        pieModel.set("COVNM",  persistenceEntity.countOcorrenciaByType("COVNM"));
        pieModel.set("COFE",  persistenceEntity.countOcorrenciaByType("COFE"));
        pieModel.set("ANDT",  persistenceEntity.countOcorrenciaByType("ANDT"));
        pieModel.set("AI",  persistenceEntity.countOcorrenciaByType("AI"));
    }  
    
	
	
    public MapModel getAdvancedModel() {  
        return advancedModel;  
    }  
    private int i = 0;
    public void onMarkerSelect(OverlaySelectEvent event) throws NumberFormatException, ParseException {  
        marker = (Marker) event.getOverlay();  
        ocorrenciaSelected = persistenceEntity.findById(Long.parseLong(marker.getTitle()));
    }  
      
    public Marker getMarker() {  
        return marker;  
    }

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Ocorrencia getOcorrenciaSelected() {
		return ocorrenciaSelected;
	}

	public void setOcorrenciaSelected(Ocorrencia ocorrenciaSelected) {
		this.ocorrenciaSelected = ocorrenciaSelected;
	}

	public String getQtdOcorrencias() {
		return qtdOcorrencias;
	}

	public void setQtdOcorrencias(String qtdOcorrencias) {
		this.qtdOcorrencias = qtdOcorrencias;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}  
    
}  
                      