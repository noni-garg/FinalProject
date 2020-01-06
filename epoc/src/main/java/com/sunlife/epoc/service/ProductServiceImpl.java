package com.sunlife.epoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunlife.epoc.entity.Product;
import com.sunlife.epoc.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;

	@Override
	public boolean addProduct(Product p) {
		return productDao.addProduct(p);
	}
	
	@Override
	public List<String> getCategories(){
		return productDao.getCategories();
	}
	
	@Override
	public List<String> getSubcategories(){
		return productDao.getSubcategories();
	}

	@Override
	public List<Product> getProducts(String category, String subcategory) {
		return productDao.getProducts(category, subcategory);
	}

	@Override
	public Product getProductbyId(int productId) {
		return productDao.getProductbyId(productId);
	}

	@Override
	public boolean editProduct(Product p) {
		return productDao.editProduct(p);
	}
	
	@Override
	public boolean deleteProduct(Product p) {
		return productDao.deleteProduct(p);
	}
}
