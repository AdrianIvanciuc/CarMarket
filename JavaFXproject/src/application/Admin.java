package application;

public class Admin extends UtilizatorVerificat {
	String id;
	String user;
	String pass;
	String telefon;
	String email;
	
	public Admin (String id, String user, String pass, 
			String telefon, String email) {
		super(id, user, pass, telefon, email);
	}
}
