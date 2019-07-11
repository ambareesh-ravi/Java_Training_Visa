package com.visa.prj.client;

import java.util.Arrays;
//import java.util.Comparator;

public class ArrayClient {

	public static void main(String[] args) {
		
		String[] names = {"John" , "Reese" , "Khaleesi" , "Brad" };
		
		//Arrays.sort(names);
		/*
		 * Arrays.sort(names, new Comparator<String>() {
		 * 
		 * @Override public int compare(String n1,String n2) { return n1.length() -
		 * n2.length() ; } });
		 */
		
		Arrays.sort(names, (o1,o2) -> o1.length() - o2.length());

		
		for ( String n : names) {
			System.out.println(n);
		}

	}

}
