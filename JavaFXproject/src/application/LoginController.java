package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class LoginController {
	@FXML
	private TextField userField;
	@FXML
	private TextField passField;
	@FXML
	private Button okButton;
	@FXML
	private Button registerButton;
	public static String user;
	public static String pass;
	//go to panel
	@FXML
	public void okButtonClick(ActionEvent event) throws IOException {
		user = userField.getText();
		pass = passField.getText();
		if (Main.findUser(user, pass)) {
			for (Utilizator utilizator : Main.utilizatori) {
				if (utilizator.user.equals(user) && utilizator.pass.equals(pass)) {
					Main.currentUser=utilizator;
				}
			}
			Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			Main.currentScene = scene;
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Market");
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		}
		else {
			Main.errorTxt = "User sau parola incorecta!";
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
	//go to register screen
	@FXML
	public void registerButtonClick(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		Main.currentScene = scene;
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Car Market");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
}
