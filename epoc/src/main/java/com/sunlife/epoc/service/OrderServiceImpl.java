package com.sunlife.epoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunlife.epoc.entity.Cart;
import com.sunlife.epoc.entity.OrderHistory;
import com.sunlife.epoc.entity.Product;
import com.sunlife.epoc.persistence.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Override
	public boolean addProductToOrder(Product p, int quantity) {
		return orderDao.addProductToOrder(p, quantity);
	}

	@Override
	public List<Cart> getCart() {
		List<Cart> cartList = orderDao.getCart();
		return cartList;
	}

	@Override
	public boolean saveOrder(OrderHistory order) {
		return orderDao.saveOrder(order);
	}

	@Override
	public float currencyConverter(String currency, float amount) {
		if(currency.equals("INR")) {
			amount=amount*74;
		}
		return amount;
	}

	@Override
	public boolean changeFlag(List<Cart> cartList) {
		return orderDao.changeFlag(cartList);
	}

	@Override
	public List<OrderHistory> orderHistory() {
		return orderDao.orderHistory();
	}
}
