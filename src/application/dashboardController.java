package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

		//private ObjectInputStream ois;

		//private department dept;
	  

		@Override
		public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
	
		public void handleClicks(ActionEvent event) throws IOException, ClassNotFoundException {
	    	
    		
    		ArrayList<department> d = new ArrayList<department>();
			department dept = new department();
    		
    		dept.setDepartmentID(txt_departmentID.getText());
    		dept.setDepartmentName(txt_departmentName.getText());
    		d.add(dept);
	    	
	    	if(event.getSource() == btn_department) {
	    		System.out.println("Deparment panel");
	    		pane_department.toFront();
	    	}
	    	else if(event.getSource() == btn_back) {
	    		System.out.println("Dashboard panel");
	    		pane_dashboard.toFront();
	    	}
	    	else if(event.getSource() == btn_logoutdashboard) {
	    		System.out.println("Application closed!");
	    		System.exit(0);
	    		
	    	}
	    	else if(event.getSource() == btn_adddepartment ) {

	    		for (int i = 0; i< d.size(); i++) {

					try {
						FileOutputStream fileOut = new FileOutputStream("dept.dat", true);
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(d.get(i));
						out.close();
						fileOut.close();
						} catch(IOException x) {
							x.printStackTrace();
						}
	    			System.out.println(d.get(i));

	    		}
	    		
				System.out.println("save details");
				//System.out.println(dept.getDepartmentID());
				//System.out.println(dept.getDepartmentName());

				txt_departmentID.setText("");
				txt_departmentName.setText("");
	    		
	    	}
	    	else if(event.getSource() == btn_showDepartment ) {
		    	ArrayList<department> d1 = new ArrayList<department>();
		    	
	    		//for(int x = 0; x<d.size(); x++) {
		    	
		    		try {
		    			FileInputStream fis = new FileInputStream("dept.dat");
				        ObjectInputStream ois = new ObjectInputStream(fis);
		    			while(((department)ois.readObject()) != null) {		 	   
		    				// for(int x = 0; x<d.size(); x++) {
		    					// d1 =(department)ois.readObject();
		    					// System.out.println(d.get(x));
		    				// }
		    				d1 = (ArrayList<department>)ois.readObject();
		    		    	System.out.println(d1);
		    			}
				        
		    			 ois.close();
		    		    fis.close();
		    			// System.out.println(dept.getDepartmentID());
		    		    	   }

				    		 catch (IOException i) {
				    			i.printStackTrace();
				    			return;
				    		} catch(ClassNotFoundException c) {
				    			System.out.println("Department class not found");
				    			c.printStackTrace();
				    			return;
				    		}
		    			//System.out.println(d);
	    			
	    		}

	    	  }
	    			
	  
	    			//	System.out.println(d.get(i));
	    			
		    		//System.out.println(d.size());
	    		
	    		
	    		
	    	}
//}
	    	
	    


