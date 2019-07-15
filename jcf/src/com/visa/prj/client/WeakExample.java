
package com.visa.prj.client;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakExample {

	public static void main(String[] args) {
		
		//Map<String,Double> m = new HashMap<>();
		Map<String,Double> m = new WeakHashMap<>();
		String s = new String("Java");
		//Not s = "Java" . Because literals are in string pool and not garbage collected.
		m.put(s,534.44);
		//IN WEAKHASHMAP WHEN YOU DELETE THE STRING , THE RESRPECTIVE ENTRY IS DELEETD.
		s = null;
		
		System.gc();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println(m.get("Java"));

	}

}
