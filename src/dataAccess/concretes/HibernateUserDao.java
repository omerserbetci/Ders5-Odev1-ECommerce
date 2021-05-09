package dataAccess.concretes;

import java.util.ArrayList;

import dataAccess.abstracts.UserDao;
import entity.concretes.User;

public class HibernateUserDao implements UserDao{
	
	public HibernateUserDao() {
		User.users = new ArrayList<User>();
	}
	
	@Override
	public void signUp(User user) {
		User.users.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " sisteme kaydedildi.");
	}

	
	
		
}
