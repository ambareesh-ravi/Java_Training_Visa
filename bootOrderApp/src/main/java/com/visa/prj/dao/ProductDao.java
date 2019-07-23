package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	List<Product> findByCategory(String ccategory);//select * from products where category=ccategory
	List<Product> findByCategoryAndPrice(String category, double price);//select * from products where category = ? and price=?
	//start by findBy only when you want to do exact matching of columns
	
	@Query("from Product p where p.price between :low and :high")
	List<Product> getByPriceRange(@Param("low")double lower,@Param("high")double higher);
	

}
