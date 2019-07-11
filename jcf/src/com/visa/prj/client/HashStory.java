package com.visa.prj.client;

public class HashStory {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1==s2); // Two different location in new gen
		s1 = "Hello";
		s2 = "Hello";
		System.out.println(s1==s2); //True because s1 and s2 are in String pool
		
		String s3 = new String("Aa");
		String s4 = new String("BB");
		//Two dissimilar can also have similar hashcode.
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());

	}

}
