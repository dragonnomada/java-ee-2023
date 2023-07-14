package com.example.ws;

import java.util.List;

import javax.inject.Inject;

//import java.util.ArrayList;
//import java.util.List;

//import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.model.Fruta;
import com.example.services.FrutaService;

//import com.example.model.Fruta;
//import com.example.services.FrutaService;

@WebService(serviceName="FrutasWS")
public class FrutasWebService {

	@Inject
	FrutaService frutaService;
	
	@WebMethod
	public List<Fruta> getFrutas() {
		return frutaService.getFrutas();
	}
	
}
