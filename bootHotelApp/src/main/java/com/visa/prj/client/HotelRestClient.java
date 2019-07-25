package com.visa.prj.client;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class HotelRestClient {
	
	public static void main(String[] args) {
		String url = "http://localhost:8080/bookings";
		RestTemplate template = new RestTemplate();
		displayAllBookings(template,url);
	}

	private static void displayAllBookings(RestTemplate template, String url) {
		System.out.println("Displaying all Bookings");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = template.getForObject(url, String.class);
		System.out.println(json);
		
	}


}
