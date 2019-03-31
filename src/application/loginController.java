package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loginController implements Initializable {

	@FXML
	public Button btnLogin;
	@FXML 
	public TextField txtUsername;
	@FXML
	public TextField txtPassword;
	@FXML
	public Label lblWelcome;
	@FXML
	public Label lblError;
	
	
	
	@FXML
	public void button_login(ActionEvent event) throws IOException {
		if(txtUsername.getText().equals("1") && txtPassword.getText().equals("1")) {
			/*((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			*/
			Main.set_pane(1);
			System.out.println("Login succesfull!");
			
		}else {
			txtUsername.clear();
			txtPassword.clear();
			lblError.setText("Please enter a valid Username and password");
			System.out.println("Username or password are incorrect!");
		}
		
	}
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resource) {
		// TODO Auto-generated method stub
		
	}
	
}
