package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class departmentController implements Initializable {

	public void go_back(ActionEvent event) {
		try {
		Main.set_pane(1);
		System.out.println("Dashboard screen loaded");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	
	public void logout(ActionEvent event) {
		try {
		System.out.println("System logged out succesfully");
		System.exit(0);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	
	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
