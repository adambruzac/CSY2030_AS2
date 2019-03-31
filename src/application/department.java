package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class  department implements Serializable{
	private static final long serialVersionUID = 1L;
	private String departmentID;
	private String departmentName;
	

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	
	public String toString() {
		return "department [departmentID=" + departmentID + ", departmentName=" + departmentName
				+ "]";
	}
	
	
	private void writeObject(ObjectOutputStream os) throws IOException, ClassNotFoundException{
		try {
			os.defaultWriteObject();
			os.writeObject(getDepartmentID());
			os.writeObject(getDepartmentName());
		} catch(Exception e) {
			e.printStackTrace();;
		}
	}
	
	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException
	 {
	  try {
	   is.defaultReadObject();
	  String departmentID = (String) is.readObject();
	  String departmentName = (String) is.readObject();
	 
	  } catch (Exception e) { 
		  e.printStackTrace(); 
		  }
	 }
	
	
	
}
