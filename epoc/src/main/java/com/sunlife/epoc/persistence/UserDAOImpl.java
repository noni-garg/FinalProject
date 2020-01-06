package com.sunlife.epoc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sunlife.epoc.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	HibernateTemplate template;
	
//	public void setTemplate(HibernateTemplate template) {  
//	    this.template = template;  
//	}  
//	
	@Override
	public User getPassword(String name) {
		User user=template.get(User.class, name);
		return user;
	}

}
