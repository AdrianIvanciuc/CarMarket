package application;

public class Anunt {
	String id;
	String nume;
	String desc;
	int km;
	int pret;
	String telefon;
	String email;
	
	public Anunt (String id, String nume, String desc, int km, 
			int pret, String telefon, String email) {
		this.id=id;
		this.nume=nume;
		this.desc=desc;
		this.km=km;
		this.pret=pret;
		this.telefon=telefon;
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "Nume: "+nume+"\n"+"Descriere: "+desc+"\n"+
	"Kilometraj: "+km+"\n"+"Pret (RON): "+pret+"\n"+
				"Nr. Telefon: "+telefon+"\n"+"Email: "+email;
	}
}
