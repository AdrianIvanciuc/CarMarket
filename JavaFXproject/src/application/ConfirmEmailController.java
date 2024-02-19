package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class ConfirmEmailController implements Initializable {
	@FXML
	private TextField codeField;
	@FXML
	private Button confirmButton;
	
	public static Integer random;
	
	@FXML
	public void confirmButtonClick(ActionEvent event) throws IOException {
		if (codeField.getText().compareTo(random.toString()) == 0) {
			Main.errorTxt = "Cont creat cu succes!";
			//go back to login
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			Main.currentScene = scene;
			//go to message
			root = FXMLLoader.load(getClass().getResource("Error.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Market");
			stage.centerOnScreen();
			stage.setScene(scene);
			stage.show();
			//add user
			Integer id = -1;
			for (Utilizator utilizator : Main.utilizatori) {
				if (Integer.parseInt(utilizator.id) > id) {
					id = Integer.parseInt(utilizator.id);
				}
			}
			id += 1; 
			Main.utilizatori.add(new UtilizatorVerificat(id.toString(), RegisterController.user, 
					RegisterController.pass, RegisterController.phone, 
					RegisterController.email));
		}
		else {
			Main.errorTxt = "Cod gresit, incearca din nou!";
			Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Market");
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Random rand = new Random(); 
		random = rand.nextInt(999999-100000)+100000;
		SendMail.send(RegisterController.email, random);
		}
}
