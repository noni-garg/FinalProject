package com.sunlife.epoc.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sunlife.epoc.entity.Cart;
import com.sunlife.epoc.entity.OrderHistory;
import com.sunlife.epoc.entity.Product;
import com.sunlife.epoc.service.OrderService;
import com.sunlife.epoc.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired 
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value= {"/order"})
	public ModelAndView editProduct(HttpSession session) {
		ModelAndView model = new ModelAndView("orderCategoryMenu");
		List<String> categoryList = productService.getCategories();
		model.addObject("categoryList", categoryList);
		return model;
	}
	
	@RequestMapping(value= {"/ordersubcategory"})
	public ModelAndView getSubcategory(HttpServletRequest req,HttpSession session) {
		ModelAndView model = new ModelAndView("orderSubcategoryMenu");
		String categoryName = req.getParameter("categoryName");
		session.setAttribute("categoryName", categoryName);
		List<String> subcategoryList = productService.getSubcategories();
		model.addObject("subcategoryList", subcategoryList);
		return model;
	}
	
	
	@RequestMapping(value= {"/orderfindproduct"})
	public ModelAndView getProduct(HttpServletRequest req,HttpSession session) {
		ModelAndView model=new ModelAndView("orderProduct");
		String subcategoryName = req.getParameter("subcategoryName");
		session.setAttribute("subcategoryName", subcategoryName);
		List<Product> productList = productService.getProducts((String)session.getAttribute("categoryName"), subcategoryName);
		model.addObject("productList",productList);
		return model;
	}
	
	@RequestMapping(value= {"/addTocart"})
	public ModelAndView addTocart(HttpServletRequest req,HttpSession session) {
		ModelAndView model=new ModelAndView();
		int id = Integer.parseInt(req.getParameter("productId"));
		Product product = productService.getProductbyId(id);
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		if(product.getProductStock()<quantity) {
			model.setViewName("orderProduct");
			model.addObject("message","Product quantity cannot be more than stock");
			return model;
		}
		boolean flag = orderService.addProductToOrder(product, quantity);
		if(flag) {
			model.setViewName("cartChoice");
			model.addObject("message",product.getProductName()+" added succesfully");
		}
		else {
			model.setViewName("orderProduct");
			model.addObject("message","Product couldn't be added");
		}
		return model;
	}
	
	@RequestMapping(value= {"/checkout"})
	ModelAndView checkout() {
		ModelAndView model = new ModelAndView("checkout");
		List<Cart> cartList = orderService.getCart();
		model.addObject("cartList",cartList);
		return model;
	}
	
	@RequestMapping(value= {"/currency"})
	ModelAndView checkCurrency(HttpServletRequest req,HttpSession session) {
		ModelAndView model = new ModelAndView("currencyResult");
		List<Cart> cartList = orderService.getCart();
		model.addObject("cartList",cartList);
		String currency = req.getParameter("currency");
		model.addObject("currency",currency);
		float amount = (float) session.getAttribute("totalAmount");
		float total = orderService.currencyConverter(currency, amount);
		session.setAttribute("convertedAmount", amount);
		session.setAttribute("currency", currency);
		model.addObject("totalAmount",total);
		return model;
	}
	
	@RequestMapping(value= {"chkoutResult"})
	ModelAndView chkoutResult(HttpServletRequest req,HttpSession session) {
		ModelAndView model = new ModelAndView();
		List<Cart> cartList = orderService.getCart();
		OrderHistory order = new OrderHistory();
		order.setCartList(cartList);
		order.setTotal((float)session.getAttribute("totalAmount"));
		boolean flag = orderService.saveOrder(order);
		orderService.changeFlag(cartList);
		
		model.addObject("cartList",cartList);
		String currency = (String) session.getAttribute("currency");
		model.addObject("currency",currency);
		float convertedAmount = (float) session.getAttribute("convertedAmount");
		model.addObject("totalAmount",convertedAmount);
		float customerAmount = Integer.parseInt(req.getParameter("customerAmount"));
		model.addObject("customerAmount",customerAmount);
		if(customerAmount<convertedAmount) {
			model.addObject("message","Amount cannot be less than total");
			model.setViewName("currencyResult");
		}
		else {
			model.addObject("balance",customerAmount-convertedAmount);
			model.setViewName("invoice");
		}
		return model;
	}
	@RequestMapping(value= {"/history"})
	ModelAndView orderHistory() {
		ModelAndView model = new ModelAndView("history");
		List<OrderHistory> orderHistory = orderService.orderHistory();
		model.addObject("orderHistory",orderHistory);
		return model;
	}
}
