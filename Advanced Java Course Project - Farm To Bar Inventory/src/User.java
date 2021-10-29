public class User {
	//Used to validate User Login
	 private String username;
	    private String password;

	    User (String username, String password)
	    {
	        this.username = username;
	        this.password = password;
	    }

	    String getUsername() {return username;}
	    String getPassword() {return password;}
}

