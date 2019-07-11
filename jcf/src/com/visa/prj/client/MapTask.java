package com.visa.prj.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.visa.prj.entity.Product;

public class MapTask {

	public static void main(String[] args) {
		Product p = new Product(5, "Samsung", 55555.00, "Mobile", 5);
		Map<String, Object> map = storeInfo(p);
		// System.out.println(map);
		map.forEach((k, v) -> System.out.println(k + " " + v));

	}

	private static Map<String, Object> storeInfo(Product p) {

		Map<String, Object> map = new HashMap<>();

		Class<? extends Product> c = p.getClass();
		Method[] m = c.getMethods();
		for (Method method : m) {
			if (method.getName().startsWith("get") && method.getName().equals("getClass") != true) {
				// System.out.println(method.getName());
				String s = method.getName().substring(3).toUpperCase();
				try {
					map.put(s, method.invoke(p));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map;
	}

}
