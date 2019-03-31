package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;




public class Main extends Application{
	/*
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	

	



public class Main extends Application {
	*/
	static AnchorPane root;//static anchor pane wich is the root
	static List<AnchorPane> pane = new ArrayList<AnchorPane>();
	private static int idx_cur = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("anchor.fxml")); 
			pane.add((AnchorPane)FXMLLoader.load(getClass().getResource("login.fxml")));
			pane.add((AnchorPane)FXMLLoader.load(getClass().getResource("dashboard.fxml")));
			//pane.add((AnchorPane)FXMLLoader.load(getClass().getResource("lecturer.fxml")));
			pane.add((AnchorPane)FXMLLoader.load(getClass().getResource("department.fxml")));

			root.getChildren().add(pane.get(0));
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init_app() {
		for(int i = 0; i < pane.size(); i++) {
			
		}
	}
	
	public static AnchorPane get_pane(int idx) {
		return pane.get(idx);
	}
	
	public static void set_pane(int idx) {
		root.getChildren().remove(pane.get(idx_cur));
		root.getChildren().add(pane.get(idx));
		idx_cur = idx;
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
