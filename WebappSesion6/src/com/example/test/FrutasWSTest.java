package com.example.test;

import java.rmi.RemoteException;

import com.example.ws.Fruta;
import com.example.ws.FrutasWSProxy;

public class FrutasWSTest {

	public static void main(String[] args) throws RemoteException {
		
		FrutasWSProxy frutaWS = new FrutasWSProxy();
		
		frutaWS.addFruta("Mango", 19.66);
		
		for (Fruta fruta : frutaWS.getAllFrutas()) {
			System.out.println(fruta.getDescription());
		}
		
	}
	
}
