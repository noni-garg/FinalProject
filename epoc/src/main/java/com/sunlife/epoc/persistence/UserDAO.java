package com.sunlife.epoc.persistence;

import com.sunlife.epoc.entity.User;

public interface UserDAO {
	
	User getPassword(String name);
	
}
