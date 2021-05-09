import bussines.concretes.UserCheckManager;
import bussines.concretes.UserManager;
import dataAccess.concretes.HibernateUserDao;
import entity.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "O", "SERBETCI", "omerserbetci@gmail.com", "123456");
		User user2 = new User(2, "OMER", "S", "omerserbetci@gmail.com", "123456");
		User user3 = new User(3, "OMER", "SERBETCI", "omerserbetci@gmail", "123456");
		User user4 = new User(5, "OMER", "SERBETCI", "omerserbetci@gmail.com", "12345");
		User user5 = new User(5, "OMER", "SERBETCI", "omerserbetci@gmail.com", "123456");
		User user6 = new User(5, "OMER", "IKI", "omerserbetci@gmail.com", "123456");
		
		UserManager userManager = new UserManager(new UserCheckManager(), new HibernateUserDao());
		
		userManager.signUp(user1);
		System.out.println("--------------------------");
		userManager.signUp(user2);
		System.out.println("--------------------------");
		userManager.signUp(user3);
		System.out.println("--------------------------");
		userManager.signUp(user4);
		System.out.println("--------------------------");
		userManager.signUp(user5);
		System.out.println("--------------------------");
		
		userManager.clickVerificationLink(user5);
		System.out.println("--------------------------");		
		
		userManager.signUp(user6);
		System.out.println("--------------------------");
		
		userManager.signUpWithGoogleAccount("omerserbetci.com", "12345");
		System.out.println("--------------------------");
		userManager.signUpWithGoogleAccount("furkanserbetci@gmail.com", "1313");
		System.out.println("--------------------------");
		
		userManager.signIn("omerserbetciii@gmail.com", "123456");
		System.out.println("--------------------------");
		userManager.signIn("omerserbetci@gmail.com", "12345");
		System.out.println("--------------------------");
		userManager.signIn("omerserbetci@gmail.com", "123456");
		System.out.println("--------------------------");
		userManager.signIn("furkanserbetci@gmail.com", "1313");
		System.out.println("--------------------------");
		
		
		
	}

}
