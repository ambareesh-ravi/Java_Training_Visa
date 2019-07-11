package com.visa.prj.client;

import java.util.Set;
import java.util.TreeSet;

import com.visa.prj.entity.Product;

public class SetExample {

	public static void main(String[] args) {
		//Set<Product> products = new HashSet<>(100);//Always store a number(100) because when 70% of the bucket is filled
		//It doubles the total bucket slots and rehashes for all the existing object.
		//Set<Product> products = new TreeSet<>();
		
		Set<Product> products = new TreeSet<>((p1,p2) -> {
			int diff = Double.compare(p1.getPrice(), p2.getPrice());
			if(diff == 0) {
				diff = p1.getId() - p2.getId();
			}
			return diff;
		});
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer", 100));
		products.add(new Product(224, "iPhone", 98000.00, "mobile", 500));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer", 300));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv", 900));
		products.add(new Product(912, "One Plus", 32000.00, "mobile", 100));
		products.add(new Product(88, "HP Printer", 19000.00, "computer", 100));
		products.add(new Product(88, "HP Printer", 19000.00, "computer", 100));
		
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
