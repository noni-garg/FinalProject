package com.sunlife.epoc.persistence;

import java.util.List;

import com.sunlife.epoc.entity.Cart;
import com.sunlife.epoc.entity.OrderHistory;
import com.sunlife.epoc.entity.Product;

public interface OrderDAO {
	boolean addProductToOrder(Product p,int quantity);
	List<Cart> getCart();
	boolean saveOrder(OrderHistory order);
	boolean changeFlag(List<Cart> cartList);
	List<OrderHistory> orderHistory();
}

