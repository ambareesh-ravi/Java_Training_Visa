package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Product;
import com.visa.service.OrderService;

@Controller
public class ProductController {
	@Autowired
	private ProductValidator validator;
	@Autowired
	private OrderService service;
	
	@RequestMapping("listProducts.do")
	public String getProducts(Model model) {
		//Asking spring to create the model object by dependency injection. Actually returns Model and View
		model.addAttribute("products", service.getProducts());
		return "list.jsp";
	}
	
	@RequestMapping("productForm.do")
	public String getProductForm(Model m) {
		m.addAttribute("product", new Product());
		return "productForm.jsp";
	}
	
	@RequestMapping("addProduct.do")
	public String addProduct(@ModelAttribute("product") Product p, BindingResult errors) {
		//BindingResult binds the error with fields in controller
		validator.validate(p, errors);
		if(errors.hasFieldErrors()) {
			return "productForm.jsp";
		} else {
			service.addProduct(p);
			return "redirect:listProducts.do";//New product is not added when refreshing
			//return "listProducts.do"; -> everytime you refresh a new product gets added 
	  }

}
}
