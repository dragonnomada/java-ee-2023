package com.example.async;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VisitHistorial {

	Map<Date, Integer> visits = new HashMap<Date, Integer>();
	
	public void addVisit(Date date, int count) {
		visits.put(date, count);
	}
	
	public String report() {
		Set<Date> dates = visits.keySet();
		
		String report = "";
		
		for (Date date : dates) {
			int count = visits.get(date);
			
			report += date + " - " + count + "\n";
		}
		
		return report;
	}

	@Override
	public String toString() {
		return "VistHistorial [visits=" + report() + "]";
	}
	
}
