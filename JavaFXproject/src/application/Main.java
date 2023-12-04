package application;
	
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	//variable
	public static List<Anunt> anunturi = new ArrayList<Anunt>();
	public static List<Utilizator> utilizatori = new ArrayList<Utilizator>();
	public static Utilizator currentUser;
	
	public static boolean findUser (String user, String pass) {
		for (Utilizator utilizator : utilizatori) {
			if (utilizator.user.equals(user) && utilizator.pass.equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		//read from file
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\adria\\eclipse-workspace\\JavaFXproject\\src\\application\\database"));
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			String[] str;
			for (int i=0; i<n; i++) {
				line = reader.readLine();
				str = line.split("[/]");
				if (Integer.parseInt(str[0])==0) {
					utilizatori.add(new Utilizator(str[0],str[1],str[2],str[3],str[4]));
				}
				else {
					utilizatori.add(new UtilizatorVerificat(str[0],str[1],str[2],str[3],str[4]));
				}
			}
			line = reader.readLine();
			n = Integer.parseInt(line);
			for (int i=0; i<n; i++) {
				line = reader.readLine();
				str = line.split("[/]");
				anunturi.add(new Anunt(str[0],str[1],str[2],Integer.parseInt(str[3]),Integer.parseInt(str[4]),str[5],str[6]));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//launch app
		launch(args);
	}
	
	//first launch
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Car Market");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop(){
		try {
		      FileWriter myWriter = new FileWriter("C:\\Users\\adria\\eclipse-workspace\\JavaFXproject\\src\\application\\database");
		      myWriter.write(utilizatori.size()+"\n");
		      for (Utilizator utilizator : utilizatori) {
		    	  myWriter.write(utilizator.id+"/"+utilizator.user+"/"
		      +utilizator.pass+"/"+utilizator.telefon+"/"+utilizator.email+"\n");
		      }
		      myWriter.write(anunturi.size()+"\n");
		      for (Anunt anunt : anunturi) {
		    	  myWriter.write(anunt.id+"/"+anunt.nume+"/"+anunt.desc+"/"
		      +anunt.km+"/"+anunt.pret+"/"+anunt.telefon+"/"+anunt.email+"\n");
		      }
		      myWriter.close();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
	}
}
