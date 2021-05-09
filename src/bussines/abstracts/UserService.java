package bussines.abstracts;

import entity.concretes.User;

public interface UserService {

	void signUp(User user);
	void signUpWithGoogleAccount(String email, String emailPassword);
	void signIn(String email, String password);
	void sendverificationEmail(User user);
	void clickVerificationLink(User user);
	
}
