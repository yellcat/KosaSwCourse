package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Product;
import com.mycompany.myapp.service.ProductService;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	@RequestMapping("product/list")
	public String list(HttpServletRequest request){
		logger.info("list()");
		List<Product> list = productservice.getPage(1, 10);
		request.setAttribute("list", list);
		return "product/list";
	}
	
	@RequestMapping("product/writeForm")
	public String writeForm(){
		logger.info("writeForm()");
		return "product/writeForm";
	}
	
	@RequestMapping("product/updateForm")
	public String updateForm(){
		logger.info("updateForm()");
		return "product/updateForm";
	}
	
	@RequestMapping("product/write")
	public String write(String name, int price){
		//parameter 명과 매개변수 명이 일치할 때 값이 들어온다
		logger.info("write()");
		
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		
		productservice.insert(product);
		
		return "redirect:/product/list";
	}
	
	@RequestMapping("product/update")
	public String update(){
		logger.info("update()");
		return "redirect:/product/list";
	}
	
	@RequestMapping("product/detail")
	public String detail(HttpServletRequest request){
		logger.info("detail()");
		Product product = productservice.getProduct(325);
		request.setAttribute("product", product);
		return "product/detail";
	}
}
