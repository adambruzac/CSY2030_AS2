package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainController {
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private Label lblError;

	
	public void Login(ActionEvent event) throws Exception {
		if (txtUsername.getText().equals("user") && txtPassword.getText().equals("user"));
			//lblError.setText("Please enter a valid username and password");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	}
}
