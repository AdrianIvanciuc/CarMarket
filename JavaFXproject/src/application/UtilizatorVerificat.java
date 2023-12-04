package application;

public class UtilizatorVerificat extends Utilizator{
	String id;
	String user;
	String pass;
	String telefon;
	String email;
	
	public UtilizatorVerificat (String id, String user, String pass, 
			String telefon, String email) {
		super(id, user, pass, telefon, email);
	}
}
