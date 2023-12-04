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

public class CreeareAnuntController {
	@FXML
	private TextField numeField;
	@FXML
	private TextField descField;
	@FXML
	private TextField kmField;
	@FXML
	private TextField pretField;
	@FXML
	private Button okButton;
	public static String nume;
	public static String desc;
	public static int km;
	public static int pret;

	// Event Listener on Button[#okButton].onAction
	@FXML
	public void okButtonClick(ActionEvent event) throws IOException{
		nume=numeField.getText();
		desc=descField.getText();
		km=Integer.parseInt(kmField.getText());
		pret=Integer.parseInt(pretField.getText());
		if (nume!=null && desc!=null && km!=0 && pret!=0) {
			Main.anunturi.add(new Anunt(Main.currentUser.id, nume, desc, km, pret,
					Main.currentUser.telefon, Main.currentUser.email));
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
