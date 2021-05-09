package dataAccess.abstracts;

import entity.concretes.User;

public interface UserDao {

	void signUp(User user);
	
}
