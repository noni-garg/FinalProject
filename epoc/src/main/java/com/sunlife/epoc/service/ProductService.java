package com.sunlife.epoc.service;

import java.util.List;

import com.sunlife.epoc.entity.Product;

public interface ProductService {
	
	boolean addProduct(Product p);
	boolean editProduct(Product p);
	boolean deleteProduct(Product p);
	List<String> getCategories();
	List<String> getSubcategories();
	List<Product> getProducts(String category,String subcategory);
	Product getProductbyId(int productId);
}
