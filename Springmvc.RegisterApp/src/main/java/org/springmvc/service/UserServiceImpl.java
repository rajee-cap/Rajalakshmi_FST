package org.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springmvc.Dao.UserDao;
import org.springmvc.Dao.UserDaoImpl;
import org.springmvc.model.Login;
import org.springmvc.model.User;

public class UserServiceImpl implements UserService {

//	  @Autowired
	  public UserDao userDao=new UserDaoImpl();

	  public int register(User user) {
	    return userDao.register(user);
	  }

	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }

	}
