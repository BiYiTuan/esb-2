package com.esb.maxmind;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.aries.blueprint.utils.ReflectionUtils;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class MaxmindLookupService {
	private LookupService cl;

	public MaxmindLookupService() throws IOException {
		cl = new LookupService("src/main/resources/maxmind/GeoLiteCity.dat",
                LookupService.GEOIP_MEMORY_CACHE );
	}

	public Location lookUp(String hostname){
		return cl.getLocation(hostname);
	}

	public static void main(String[] args) throws IOException {
		MaxmindLookupService maxmindLookupService = new MaxmindLookupService();
		Location lookUp = maxmindLookupService.lookUp("google.co.uk");
		System.out.println(lookUp.countryCode);
	}

}

