package com.visa.prj.client;

import java.lang.ref.SoftReference;

public class ReferenceExample {

	public static void main(String[] args) {
		
		//CAN USE FOR TEMPORARY STORAGE OR CACHING
		//Weak - 
		//Soft - Object will be there until heap memory becomes full. It is an excellent
		//candidate for caching.
		
		//WeakReference<String> wr = new WeakReference<String>(new String("Hello"));
		//WeakHashMap uses Weak Reference
		SoftReference<String> wr = new SoftReference<String>(new String("Hello"));
		System.out.println(wr.get());
		
		System.gc();
		//gc sweeps the weak referEnce
		
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(wr.get());

	}

}
