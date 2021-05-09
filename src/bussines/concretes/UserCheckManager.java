package bussines.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bussines.abstracts.UserCheckService;
import entity.concretes.User;

public class UserCheckManager implements UserCheckService {

	@Override
	public boolean checkEmailFormat(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

	@Override
	public boolean isEmailAvaible(String email) {
		if (User.users != null & !User.users.isEmpty()) {
			for (User user : User.users) {
				if (user.geteMailAdress() == email) {
					return false;
				}
			}
		}
		return true;
	}

	
	
}
