package com.visa.prj.client;

import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[4]; //Has not created 4 products. Array of 4 product pointers
		products[0] = new Tv(133,"Sony Bravia",29999.00,"LED");
		products[1] = new Mobile(453,"Moto E2",9999.00,"4G");
		products[2] = new Tv(133,"Onida Thunder",24999.00,"CRT");
		products[3] = new Mobile(621,"iPhone XR",99999.00,"4G");
		
		printExpensive(products);
		printInfo(products);
		printInfoOCP(products);
	}

	/*
	 * Print details using Open for extension close for change
	 * Done using Reflection APIs
	 */
	private static void printInfoOCP(Product[] products) {
		for(Product p : products) {
			Class clazz = p.getClass();
			Method[] methods = clazz.getMethods(); //getDeclaredMethods() for only non-inherited methods 
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					System.out.println("Using OCP");
					try {
						Object ret = m.invoke(p); //Reflection APIs
						System.out.println(ret);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static void printInfo(Product[] products) {
		for(Product product : products) {
			System.out.println(product.getName()+" : "+product.getPrice());
			if(product instanceof Tv) {
				Tv t = (Tv) product;
				System.out.println(t.getScreenType());
			}
			if(product.getClass() == Mobile.class) {
				Mobile m = (Mobile) product;
				System.out.println(m.getConnectivity());
			}
			System.out.println("********");
		}
		
	}

	private static void printExpensive(Product[] products) {
		for(Product product : products) {
			if(product.isExpensive()) {
				System.out.println(product.getName() + " is expensive!!!");
			}
		}
	}

}
