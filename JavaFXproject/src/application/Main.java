package application;
	
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {
	
	//variabile globale
	public static List<Anunt> anunturi = new ArrayList<Anunt>();
	public static List<Utilizator> utilizatori = new ArrayList<Utilizator>();
	public static Utilizator currentUser;
	public static Scene currentScene;
	public static String errorTxt;
	
	//find user function
	public static boolean findUser (String user, String pass) {
		for (Utilizator utilizator : utilizatori) {
			if (utilizator.user.equals(user) && utilizator.pass.equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	//main function
	public static void main(String[] args) {
		//MYSQL connection
	    try {
	    	String url = "jdbc:mysql://localhost:3306/carmarket";
		    String username = "root";
		    String password = "fritz555ADC";
	        Connection con = DriverManager.getConnection(url, username, password);
	        java.sql.Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM utilizatori");
	        while (rs.next()) {
	        	Integer id = rs.getInt("id");
	        	String user = rs.getString("user");
	        	String pass = rs.getString("pass");
	        	String telefon = rs.getString("telefon");
	        	String email = rs.getString("email");
	        	if (id == 0) {
					utilizatori.add(new Utilizator(id.toString(), user, pass, telefon, email));
				} else if (id == -1) {
					utilizatori.add(new Admin(id.toString(), user, pass, telefon, email));
				}
				else {
					utilizatori.add(new UtilizatorVerificat(id.toString(), user, pass, telefon, email));
				}
	        }
	        rs = st.executeQuery("SELECT * FROM anunturi");
	        while (rs.next()) {
	        	Integer id = rs.getInt("id");
	        	String nume = rs.getString("nume");
	        	String descr = rs.getString("descr");
	        	Integer km = rs.getInt("km");
	        	Integer pret = rs.getInt("pret");
	        	String telefon = rs.getString("telefon");
	        	String email = rs.getString("email");
	        	anunturi.add(new Anunt(id.toString(),nume,descr,km,pret,telefon,email));
	        }
	        st.close();
	        } catch (SQLException ex) {
	          throw new Error("Error ", ex);
	          } 
		//launch app
		launch(args);
	}
	
	//start function
	@Override
	public void start(Stage Stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			Main.currentScene = scene;
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage.setTitle("Car Market");
			Stage.setScene(scene);
			Stage.setResizable(false);
			Stage.centerOnScreen();
			Stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//stop function
	@Override
	public void stop() {
		//MYSQL connection
		try {
			String url = "jdbc:mysql://localhost:3306/carmarket";
		    String username = "root";
		    String password = "fritz555ADC";
	        Connection con = DriverManager.getConnection(url, username, password);
	        java.sql.Statement st = con.createStatement();
	        st.executeUpdate("TRUNCATE TABLE utilizatori");
	        st.executeUpdate("TRUNCATE TABLE anunturi");
	        for (Utilizator utilizator : utilizatori) 
	        	st.executeUpdate("REPLACE INTO utilizatori VALUES"
	        			+"("+Integer.parseInt(utilizator.id)+", '"
	        			+utilizator.user+"', '"
	        			+utilizator.pass+"', '"
	        			+utilizator.telefon+"', '"
	        			+utilizator.email+"')");
	        for (Anunt anunt : anunturi) 
	        	st.executeUpdate("REPLACE INTO anunturi VALUES"
	        			+"("+Integer.parseInt(anunt.id)+", '"
	        			+anunt.nume+"', '"
	        			+anunt.desc+"', "
	        			+anunt.km+", "
	        			+anunt.pret+", '"
	        			+anunt.telefon+"', '"
	        			+anunt.email+"')");
	        st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}