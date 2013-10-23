package com.boohoo.esb.maxmind;

import java.io.IOException;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class MaxmindLookupService {
	private LookupService cl;
	
	public MaxmindLookupService() throws IOException {
		LookupService cl = new LookupService("src/main/resources/maxmind/GeoLiteCity.dat",
                LookupService.GEOIP_MEMORY_CACHE );
		 Location l1 = cl.getLocation("212.25.232.151");
		 System.out.println(l1.countryName);
	}
	
	public static void main(String[] args) throws IOException {
		new MaxmindLookupService();
	}
	 
}

