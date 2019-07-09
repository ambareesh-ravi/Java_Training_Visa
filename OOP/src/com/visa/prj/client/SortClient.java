package com.visa.prj.client;

import java.util.Iterator;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.ArrayUtil;

public class SortClient {
	
	public static void main(String[] args) {
		String[] names = { "aab" , "sdf" , "ffe" };
		ArrayUtil.sort(names);
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Product[] products = new Product[4]; //Has not created 4 products. Array of 4 product pointers
		products[0] = new Tv(133,"Sony Bravia",29999.00,"LED");
		products[1] = new Mobile(453,"Moto E2",9999.00,"4G");
		products[2] = new Tv(133,"Onida Thunder",24999.00,"CRT");
		products[3] = new Mobile(621,"iPhone XR",99999.00,"4G");
		
		ArrayUtil.sort(products);
		for ( Product product : products) {
			System.out.println(product);
		}
	}

	

}
