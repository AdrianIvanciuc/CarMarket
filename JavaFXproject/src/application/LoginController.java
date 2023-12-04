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
	public static String user;
	public static String pass;
	
	// Event Listener on Button[#okButton].onAction
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
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Market");
			stage.setScene(scene);
			stage.show();
		}
	}
}
