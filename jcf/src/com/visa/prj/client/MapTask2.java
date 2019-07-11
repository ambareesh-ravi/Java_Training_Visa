package com.visa.prj.client;

import java.util.HashMap;
import java.util.Map;

public class MapTask2 {

	public static void main(String[] args) {

		Map<String,Integer> m = getWordFrequency(args);
		m.forEach((k,v) -> System.out.println(k+" "+v));
		
	}

	private static Map<String, Integer> getWordFrequency(String[] args) {

		Map<String, Integer> m = new HashMap<>();
		for (String string : args) {
			if(m.get(string)==null)
				m.put(string,1);
			else
				m.put(string,m.get(string)+1);
		}
		return m;
	}

}
