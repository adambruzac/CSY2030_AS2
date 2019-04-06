package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController implements Initializable {

	   @FXML
	    private Button btn_department;

	    @FXML
	    private Button btn_adddepartment, btn_showDepartment;

	    @FXML
	    private Pane pane_dashboard;

	    @FXML
	    private Button btn_logoutdepartment;
	    
	    @FXML
	    private Button btn_logoutdashboard;

	    @FXML
	    private Button btn_back;

	    @FXML
	    private Pane pane_department;

	    @FXML
	    private Button btn_lecturers;
	    
	    @FXML 
	    public TextField txt_departmentID;

		@FXML
		public  TextField txt_departmentName;

		department d = new department();
	
		@Override
		public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
			// TODO Auto-generated method stub
	
		}
	
		public void readFile() {
    		department d = null;
    		List<department> xList;
    		try {
    			
    			FileInputStream fileIn = new FileInputStream("department.dat");
    	        ObjectInputStream in = new ObjectInputStream(fileIn);
    			d = (department) in.readObject();
    			in.close();
    			fileIn.close(); 
    		} catch(IOException i) {
    			i.printStackTrace();
    			return;
    		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
		public void handleClicks(ActionEvent event) throws ClassNotFoundException, IOException{
			
			ArrayList<department> departmentList = new ArrayList<department>();
			
    	
	    	if(event.getSource() == btn_department) {
	    		System.out.println("Deparment panel");
	    		pane_department.toFront();
	    	}
	    	
	    	
	    	else if(event.getSource() == btn_adddepartment ) {
	    	
	    	d.setDepartmentID(txt_departmentID.getText());
			d.setDepartmentName(txt_departmentName.getText());
	    	departmentList.add(d);
	    	
	    	try {
	    		
	    		FileOutputStream fos = new FileOutputStream("department.dat", true);
	    		ObjectOutputStream oos = new ObjectOutputStream(fos);
	    		oos.writeObject(departmentList);
	    		oos.close();
	    		
	    	} catch(IOException ex) {
	    		ex.printStackTrace();
	    	}
	    	System.out.println("Department ID saved is: " + d.getDepartmentID());
	    	System.out.println("Department Name saved is: " + d.getDepartmentName());
	    	
	    	
	    	}
	    	
	    	else if(event.getSource() == btn_showDepartment ) {
	
	    		readFile();

	    	}
	    	
	    	
	    	else if(event.getSource() == btn_back) {
	    		System.out.println("Dashboard panel");
	    		pane_dashboard.toFront();
	    	}
	    	else if(event.getSource() == btn_logoutdashboard) {
	    		System.out.println("Application closed!");
	    		System.exit(0);
	    		
	    	}
	    	

		}
}
		
	    	
	    


