package bussines.concretes;

import bussines.abstracts.UserCheckService;
import bussines.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entity.concretes.User;

public class UserManager implements UserService{

	UserCheckService checkService;
	UserDao userDao;
	
	public UserManager(UserCheckService checkService, UserDao userdao) {
		this.checkService = checkService;
		this.userDao = userdao;
	}
	
	@Override
	public void signUp(User user) {
		if(user.getPassword().length() < 6) {
			System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.");
			return;
		}
		
		if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("İsim ve soyisim en az iki karakter içermelidir.");
			return;
		}
		
		if(!checkService.checkEmailFormat(user.geteMailAdress())) {
			System.out.println("E mail adresiniz doğru formatta değil!");
			return;
		}
		
		if (!checkService.isEmailAvaible(user.geteMailAdress())) {
			System.out.println("E mail adres sistemde zaten kayıtlı.");
			return;
		}
		
		sendverificationEmail(user);
		
	}

	@Override
	public void signUpWithGoogleAccount(String email, String emailPassword) {
		if (checkService.checkEmailFormat(email)) {
			userDao.signUp(new User(1,"Email-İsim","Email-Soyisim",email,emailPassword));
		} else {
			System.out.println("Google hesabı doğrulamadı.");
		}
	}

	@Override
	public void signIn(String email, String password) {
		if(User.users != null && !User.users.isEmpty()) {
			for (User user : User.users) {
				if(user.geteMailAdress() == email) {
					if (user.getPassword() == password) {
						System.out.println("Giriş başarılı. " + user.getFirstName() + " " + user.getLastName());
						return;
					} else {
						System.out.println("Şifre hatalı");
						return;
					}
				}
			}
		}
		System.out.println("Kullanıcı sistemde kayıtlı değil.");
	}

	@Override
	public void sendverificationEmail(User user) {
		System.out.println("Doğrulama maili gönderildi. Üyeliği tamamlamak için maildeki linke tıklayınız." +
						   "Mail adresi: " + user.geteMailAdress());	
	}

	@Override
	public void clickVerificationLink(User user) {
		userDao.signUp(user);
	}

	
	
}
