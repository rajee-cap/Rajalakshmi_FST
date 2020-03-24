package org.springmvc.Dao;

import java.util.ArrayList;

import org.springmvc.model.Login;
import org.springmvc.model.User;

public class UserDaoImpl implements UserDao {
	
	public static ArrayList<User> userList= new ArrayList<User>();

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		userList.add(user);
		System.out.println(userList.size()+": USER LIST ");
		return 0;
	}

	@Override
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		for(User user: userList) {
			System.out.println(user.getUsername()+" : "+user.getPassword());
			System.out.println(login.getUsername()+" : "+login.getPassword());
			if(login.getUsername().equals(user.getUsername()) && login.getPassword().equals(user.getPassword())) {
				return user;
			}else
				return null;
		}
		return null;
	}

}
