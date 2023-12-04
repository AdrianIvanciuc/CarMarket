package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.fxml.Initializable;

public class ListController implements Initializable {
	@FXML
	private ListView<String> listaAnunturi;
	@FXML
	private Button butonVizualizare;
	@FXML
	private Button butonProfil;
	@FXML
	private Button butonStergere;
	public static Anunt anuntSelectat;
	
	// Event Listener on Button[#butonVizualizare].onAction
	@FXML
	public void butonAnuntClick(ActionEvent event) throws IOException {
		if (listaAnunturi.getSelectionModel().getSelectedItem() != null) {
			for (Anunt anunt : Main.anunturi) {
				if ((anunt.nume+", Pret: "+anunt.pret).equals(listaAnunturi.getSelectionModel().getSelectedItem())) {
					anuntSelectat=anunt;
				}
			}
			Parent root = FXMLLoader.load(getClass().getResource("Anunt.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Car Market");
			stage.setScene(scene);
			stage.show();
		}
	}
	// Event Listener on Button[#butonProfil].onAction
	@FXML
	public void butonProfilClick(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CreeareAnunt.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Car Market");
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void butonStergereClick(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StergereAnunt.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Car Market");
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		butonProfil.setDisable(true);
		butonStergere.setDisable(true);
		if (Main.currentUser instanceof UtilizatorVerificat) {
			butonProfil.setDisable(false);
			butonStergere.setDisable(false);
		}
		for (Anunt anunt : Main.anunturi) {
			listaAnunturi.getItems().add(anunt.nume+", Pret: "+anunt.pret);
		}
	}
}
