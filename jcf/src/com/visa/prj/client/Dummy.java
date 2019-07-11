package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dummy {
	
	public static void main(String[] args) {
		List<Integer> il = Arrays.asList(1,66,3,77,2);
		List<String> s1 = Arrays.asList("one","two","three");
		print(il);
		print(s1);
		
		//Copying il ans s1. Pagination. 
		List<Integer> copyInt = new ArrayList<>();
		List<String> copyStr= new ArrayList<>();
		
		//Write a generic pagination code
		copy(copyInt,il);
		copy(copyStr, s1);
		
		
		Object[] elems = new String[3];
		elems[0] = new String("hello");
		//elems[1] = new Date();
	}

	//PECS - Producer Extends , Consumer super
	private static <T> void copy(List<? super T> dest, List<? extends T> src) { 
		for(T o : src) {
			dest.add(o); } 
		}
	
	
	/*
	 * private static <T> void copy(List<T> dest, List<T> src) { for(T o : src) {
	 * dest.add(o); } }
	 */

	private static void print(List<?> il) { // ? - Unknown type. ? allows accesses but not mutation.
		//That is you can't add elements to list il
		for(Object o : il) {
			System.out.println(o);
		}

		
	}

}
