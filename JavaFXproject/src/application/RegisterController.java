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

public class RegisterController {
	@FXML
	private TextField emailField;
	@FXML
	private TextField userField;
	@FXML
	private TextField passField;
	@FXML
	private TextField confirmField;
	@FXML
	private TextField phoneField;
	@FXML
	private Button cancelButton;
	@FXML
	private Button confirmButton;
	public static String email;
	public static String user;
	public static String pass;
	public static String confirm;
	public static String phone;
	//cancel button
	@FXML
	public void cancelButtonClick(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		Main.currentScene = scene;
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Car Market");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
	//register button
	@FXML
	public void confirmButtonClick(ActionEvent event) throws IOException {
		email=emailField.getText();
		user=userField.getText();
		pass=passField.getText();
		confirm=confirmField.getText();
		phone=phoneField.getText();
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmEmail.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Car Market");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
}