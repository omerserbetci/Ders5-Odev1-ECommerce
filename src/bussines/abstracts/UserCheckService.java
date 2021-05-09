package bussines.abstracts;

public interface UserCheckService {

	boolean checkEmailFormat(String email);
	
	boolean isEmailAvaible(String email);
	
}
