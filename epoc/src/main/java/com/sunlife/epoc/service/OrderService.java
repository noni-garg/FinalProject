package com.sunlife.epoc.service;

import java.util.List;

import com.sunlife.epoc.entity.Cart;
import com.sunlife.epoc.entity.OrderHistory;
import com.sunlife.epoc.entity.Product;

public interface OrderService {

	boolean addProductToOrder(Product p,int quantity);
	List<Cart> getCart();
	boolean saveOrder(OrderHistory order);
	float currencyConverter(String currency,float amount);
	boolean changeFlag(List<Cart> cartList);
	List<OrderHistory> orderHistory();
}
