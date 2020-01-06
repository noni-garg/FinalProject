package com.sunlife.epoc.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sunlife.epoc.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	HibernateTemplate template;

	@Override
	public boolean addProduct(Product p) {
		int id = (int)template.save(p);
		if(id==0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editProduct(Product p) {
//		String hql="Update Product set productName=:name,productStock=:stock,subCategory=:subcat,price=:price,category=:cat where productId=:id";
//		Query query = template.getSessionFactory().openSession().createQuery(hql);
//		query.setParameter("name",p.getProductName());
//		query.setParameter("stock",p.getProductStock());
//		query.setParameter("subcat",p.getSubCategory());
//		query.setParameter("price",p.getPrice());
//		query.setParameter("cat",p.getCategory());
//		int result = query.executeUpdate();
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.update(p);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();		
		return true;
	}

	@Override
	public boolean deleteProduct(Product p) {
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.delete(p);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();	
		return true;
	}

	@Override
	public List<String> getCategories() {
		List<String> categoryList = (List<String>) template.find("select distinct category from Product");
		return categoryList;
	}

	@Override
	public List<String> getSubcategories() {
		List<String> subcategoryList = (List<String>) template.find("select distinct subCategory from Product");
		return subcategoryList;
	}

	@Override
	public List<Product> getProducts(String category, String subcategory) {
		List<Product> productList = (List<Product>) template.findByNamedParam("from Product where category=:catgry and subCategory=:subcatgry", new String[] {"catgry","subcatgry"}, new Object[] {category,subcategory});
		return productList;
	}

	@Override
	public Product getProductbyId(int productId) {
		Product product = template.get(Product.class, productId);
		return product;
	}
	
}
