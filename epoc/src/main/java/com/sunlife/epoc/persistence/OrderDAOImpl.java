package com.sunlife.epoc.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sunlife.epoc.entity.Cart;
import com.sunlife.epoc.entity.OrderHistory;
import com.sunlife.epoc.entity.Product;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	HibernateTemplate template;
	
	@Override
	public boolean addProductToOrder(Product p, int quantity) {
		Cart cart = new Cart();
		cart.setProduct(p);
		cart.setQuantity(quantity);
		template.saveOrUpdate(cart);
//		SessionFactory sessionFactory = template.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction=session.beginTransaction();
//		session.saveOrUpdate(cart);
//		transaction.commit();
//		session.close();		
		return true;
	}

	@Override
	public List<Cart> getCart() {
		List<Cart> cartList = (List<Cart>) template.find("from Cart where flag=false");
		return cartList;
	}
	

	@Override
	public boolean saveOrder(OrderHistory order) {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(order);
		transaction.commit();
		session.close();		
		return true;
	}

	@Override
	public boolean changeFlag(List<Cart> cartList) {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();	
		int id=0;
		for (Cart cart : cartList) {
			cart.setFlag(true);
			session.saveOrUpdate(cart);
		}
		transaction.commit();
		session.close();	
		return true;
	}

	@Override
	public List<OrderHistory> orderHistory() {
		return (List<OrderHistory>) template.find("from OrderHistory");
	}

}
