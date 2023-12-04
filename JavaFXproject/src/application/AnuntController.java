package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AnuntController implements Initializable{
	@FXML
	private Label textLabel;
	@FXML
	private Button okButton;

	// Event Listener on Button[#okButton].onAction
	@FXML
	public void okButtonClick(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Car Market");
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textLabel.setText(ListController.anuntSelectat.toString());
	}
}
