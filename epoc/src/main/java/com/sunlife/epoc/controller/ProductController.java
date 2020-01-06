package com.sunlife.epoc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sunlife.epoc.entity.Product;
import com.sunlife.epoc.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/add")
	public ModelAndView addProductForm() {
		ModelAndView model = new ModelAndView("addProductForm","product",new Product());
		return model;
	}
	
	@RequestMapping("/addresult")
	public ModelAndView addProduct(HttpServletRequest req,@ModelAttribute("product")Product product) {
		ModelAndView model = new ModelAndView();
		boolean flag = productService.addProduct(product);
		if(flag) {
			model.addObject("productname",product.getProductName());
			model.setViewName("addProductResult");
		}
		else {
			model.addObject("message","Product couldn't be added");
			model.setViewName("addProductResult");
		}
		return model;
	}
	
	@RequestMapping(value= {"/edit/{mode}","/category","/del/{mode}"})
	public ModelAndView editProduct(HttpSession session,@PathVariable("mode")String mode) {
		session.setAttribute("mode", mode);
		ModelAndView model = new ModelAndView("categoryMenu");
		List<String> categoryList = productService.getCategories();
		model.addObject("categoryList", categoryList);
		return model;
	}
	
	@RequestMapping(value= {"/edit/subcategory","/del/subcategory"})
	public ModelAndView getSubcategory(HttpServletRequest req,HttpSession session) {
		ModelAndView model = new ModelAndView("SubcategoryMenu");
		String categoryName = req.getParameter("categoryName");
		session.setAttribute("categoryName", categoryName);
		List<String> subcategoryList = productService.getSubcategories();
		model.addObject("subcategoryList", subcategoryList);
		return model;
	}
	
	@RequestMapping(value= {"/edit/findproduct","/del/findproduct"})
	public ModelAndView getProduct(HttpServletRequest req,HttpSession session) {
		ModelAndView model=new ModelAndView();
		String subcategoryName = req.getParameter("subcategoryName");
		session.setAttribute("subcategoryName", subcategoryName);
		List<Product> productList = productService.getProducts((String)session.getAttribute("categoryName"), subcategoryName);
		model.addObject("productList",productList);
		if(session.getAttribute("mode").equals("edit")) {
			model.setViewName("editProduct");
		}
		else {
			model.setViewName("deleteProduct");
		}
		return model;
	}
	
	@RequestMapping("/edit/editProductForm")
	public ModelAndView editProduct(HttpServletRequest req,HttpSession session) {
		ModelAndView model = new ModelAndView("editProductForm","tempProduct",new Product());
		int id = Integer.parseInt(req.getParameter("productId"));
		Product product = productService.getProductbyId(id);
		session.setAttribute("id", id);
		model.addObject("product",product);
		return model;
	}
	
	@RequestMapping("/edit/editProductResult")
	public ModelAndView editProductResult(HttpSession session,@ModelAttribute("tempProduct")Product product) {
		ModelAndView model = new ModelAndView("editProductResult");
		int id=(int)session.getAttribute("id");
		product.setProductId(id);
		System.out.println(product);
		boolean flag = productService.editProduct(product);
		if(flag) {
			model.addObject("message","Update Successfull");
		}
		else {
			model.addObject("message","Update Failed");
		}
		return model;
	}
	
	@RequestMapping("/del/deleteProductResult")
	public ModelAndView deleteProduct(HttpSession session,HttpServletRequest req) {
		ModelAndView model = new ModelAndView("deleteResult");
		int id=Integer.parseInt(req.getParameter("productId"));
		Product product = productService.getProductbyId(id);
		boolean flag = productService.deleteProduct(product);
		if(flag) {
			model.addObject("message","Delete Successfull");
		}
		else {
			model.addObject("message","Delete Failed");
		}
		return model;
	}
}
