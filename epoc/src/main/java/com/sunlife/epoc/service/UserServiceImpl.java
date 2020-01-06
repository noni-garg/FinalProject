package com.sunlife.epoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunlife.epoc.entity.User;
import com.sunlife.epoc.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public boolean login(User user) {
		User tempUser=userDao.getPassword(user.getUsername());
		if(tempUser!=null) {
			if(tempUser.getUsername().equals(user.getUsername())&&(tempUser.getPassword().equals(user.getPassword()))) {
				return true;
			}
		}
		return false;
	}	
}
