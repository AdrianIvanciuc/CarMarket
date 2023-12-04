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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StergereAnuntController implements Initializable {
	@FXML
	private ListView<String> listaAnunturi;
	@FXML
	private Button butonSterge;
	@FXML
	private Button butonInapoi;
	public static Anunt anuntSelectat;

	// Event Listener on Button[#butonSterge].onAction
	@FXML
	public void butonStergeClick(ActionEvent event) throws IOException {
		if (listaAnunturi.getSelectionModel().getSelectedItem() != null) {
			for (Anunt anunt : Main.anunturi) {
				if ((anunt.nume+", Pret: "+anunt.pret).equals(listaAnunturi.getSelectionModel().getSelectedItem())) {
					anuntSelectat=anunt;
				}
			}
			Main.anunturi.remove(anuntSelectat);
			Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Market");
			stage.setScene(scene);
			stage.show();
		}
	}
	// Event Listener on Button[#butonInapoi].onAction
	@FXML
	public void butonInapoiClick(ActionEvent event) throws IOException {
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
		for (Anunt anunt : Main.anunturi) {
			if (anunt.id.equals(Main.currentUser.id)) {
				listaAnunturi.getItems().add(anunt.nume+", Pret: "+anunt.pret);
			}
		}
	}
}
