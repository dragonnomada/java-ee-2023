package com.example.ws;

//import java.util.ArrayList;
//import java.util.List;

//import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

//import com.example.model.Fruta;
//import com.example.services.FrutaService;

@WebService(serviceName="FrutaWS")
public class FrutaWebService {

	//@Inject
	//FrutaService frutaService;
	
	@WebMethod
	public String getFrutas() {
		return "Hola";
//		return new ArrayList<Fruta>();
		//return frutaService.getFrutas();
	}
	
}
