package webapp.login;

public class LoginService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("gts") && password.equals("1"))
			return true;

		return false;
	}

}
