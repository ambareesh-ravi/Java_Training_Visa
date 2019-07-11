package com.visa.prj.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	
	public static void main(String[] args) {
		Map<String,Double> map = new HashMap<>();
		map.put("Java",534.44);
		map.put("Java",531.44);
		map.put("Js",534.44);
		map.put("Oracle",534.44);
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : "+map.get(key));
		}
		System.out.println("********");
		keys.forEach(System.out::println); //CONSUMER
		map.forEach((k,v) -> System.out.println(k+ " : "+v)); //BICONSUMER
	}

}
