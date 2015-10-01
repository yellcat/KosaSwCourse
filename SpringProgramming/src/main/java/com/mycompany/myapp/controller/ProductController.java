package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mycompany.myapp.dto.Product;
import com.mycompany.myapp.service.ProductService;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productservice;//객체를 생성해주지 않아도 Autowired를 통해 생성
	
	@RequestMapping("product/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model, HttpSession session){
		logger.info("list()");
		
		session.setAttribute("pageNo",pageNo);
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = productservice.getTotalproductNo();
		
		int totalPageNo = totalBoardNo/rowsPerPage;
		if(totalBoardNo%rowsPerPage != 0){totalPageNo++;}
		
		int totalGroupNo = totalPageNo/pagesPerGroup;
		if(totalPageNo%pagesPerGroup!=0){totalGroupNo++;}
			
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if (groupNo==totalGroupNo) {endPageNo = totalPageNo;}
		
		List<Product> list = productservice.getPage(pageNo, rowsPerPage);
		model.addAttribute("list", list);
		
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);

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
	public String write(Product product, HttpSession session){
		//parameter 명과 매개변수 명이 일치할 때 값이 들어온다
		logger.info("write()");
		
		ServletContext application = session.getServletContext();
		String dirPath = application.getRealPath("/resources/uploadfiles");
		String originalFilename = product.getAttach().getOriginalFilename();
		String filesystemName = System.currentTimeMillis() + "-" + originalFilename;
		String contentType = product.getAttach().getContentType();
		
		if(!product.getAttach().isEmpty()){
			try {
				product.getAttach().transferTo(new File(dirPath+"/"+filesystemName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!product.getAttach().isEmpty()){
			product.setOriginalFilename(originalFilename);
			product.setFilesystemName(filesystemName);
			product.setContentType(contentType);
		}
		productservice.insert(product);
		
		return "redirect:/product/list";
	}
	
	@RequestMapping("product/update")
	public String update(Product product){
		logger.info("update()");
		productservice.update(product);
		return "redirect:/product/detail?productNo="+product.getNo();
	}
	
	@RequestMapping("product/detail")
	public String detail(int productNo, HttpServletRequest request){
		logger.info("detail()");
		Product product = productservice.getProduct(productNo);
		request.setAttribute("product", product);
		return "product/detail";
	}
	
	@RequestMapping("product/delete")
	public String delete(int productNo, HttpServletRequest request){
		logger.info("detail()");
		productservice.delete(productNo);
		return "redirect:product/list";
	}
}
