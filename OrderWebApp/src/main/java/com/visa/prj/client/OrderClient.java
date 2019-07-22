package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.service.OrderService;

public class OrderClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ApplicationContext ctx = new ClassPathXmlBeanApplicationContext();
		ctx.scan("com.visa");
		ctx.refresh();
		
		
//		  String[] names = ctx.getBeanDefinitionNames(); 
//		  for(String name : names) {
//			  	System.out.println(name); 
//		  }
//		  OrderService service = ctx.getBean("orderService",OrderService.class); 
//		Product p = new Product(0,"Camlin Whiteboard Marker","stationary",120,5000);
//		  service.addProduct(p);
//		  
//		  List<Product> products = service.getProducts(); 
//		  for(Product prd : products) {
//		  System.out.println(prd.getName()); 
//		  }
		
		Customer c = new Customer();
		c.setEmail("c1@visa.com"); //Should get it from session
		Order o = new Order();
		o.setCustomer(c); // Order is by customer a@visa.com
		
		OrderService service = ctx.getBean("orderService",OrderService.class);
		Product p1 = service.getProduct(1);
		Product p2 = service.getProduct(2);
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(1);
		i1.setAmount(p1.getPrice() * i1.getQty());

		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(3);
		i2.setAmount(p2.getPrice() * i2.getQty());
		
		o.getItems().add(i1);
		o.getItems().add(i2);
		service.executeOrder(o);
		
		

	}

}
