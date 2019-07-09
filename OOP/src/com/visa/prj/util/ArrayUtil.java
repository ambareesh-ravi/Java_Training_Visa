package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {
	public static int getSum(int[] data) {
		int sum = 0;
		for(int a : data)
			sum+=a;
		return sum;
	}
	
	public static void sort(int[] elems) {
		Arrays.sort(elems);
	}
	
	//CLOSED FOR A CHANGE AND OPEN FOR EXTENSION. OCP PRINCIPLE
	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				if(elems[i].compareTo(elems[j]) > 0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
					
			}
		}
	}
	/**
	 * METHOD TO RETURN NUMBER OF OCCURENCE OF "NO" IN AN ARRAY
	 * @param elems
	 * @param no
	 * @return
	 */
	public static int getCount(int[] elems) {
		return elems.length;
	}
	
	public static int[] convert(int[][] data) {
		int[] res = new int[data.length * data[0].length];
		int i=0;
		for(int[] d : data)
		{
			for(int d1 : d)	
			{
				res[i]=d1;
				i++;
			}
		}
		return res;
		
}
}