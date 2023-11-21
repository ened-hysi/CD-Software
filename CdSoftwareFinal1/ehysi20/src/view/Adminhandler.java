package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Accessemployes;
import model.Employees;
import model.User;
import model.Date;

public class Adminhandler implements EventHandler<ActionEvent>{
	
	User currentUser;
	
	public Adminhandler( User currentUser){
		this.currentUser = currentUser;
	};
	
	public Scene exec(Stage primaryStage){
			
			Accessemployes empFile = new Accessemployes();
			
			ObservableList<Employees> empList = FXCollections.observableArrayList(empFile.getEmployees());
		    
			Label name = new Label("Name: ");
			Label sname = new Label("Surname: ");
			Label phone = new Label("Phone: ");
			Label birthday = new Label("Birthday: ");
			Label email = new Label("Email: ");
			Label salary = new Label("Salary: ");
			Label username = new Label("Username;");
			Label password = new Label("Password;");
			Label level = new Label ("Level: ");
	
			
			TextField nameField = new TextField();
			TextField snameField = new TextField();
			TextField phoneField = new TextField();
			TextField emailField = new TextField();
			TextField salaryField = new TextField();
			DatePicker bdayField = new DatePicker();
			TextField usernameField = new TextField();
			TextField passwordField = new TextField();
			TextField levelField = new TextField();
	
			
			Button create = new Button ("Create");

			
			BorderPane bp=new BorderPane();
			HBox hb=new HBox();
			hb.getChildren().add(create);
			bp.setBottom(hb);
			
			GridPane gp = new GridPane();
			gp.addColumn(0, name, sname, birthday ,phone,salary,email,username, password,level);
			gp.addColumn(1, nameField, snameField, bdayField, phoneField, salaryField,emailField, usernameField, passwordField, levelField);
			gp.add(bp,0,10);
			
			gp.setHgap(10);
			gp.setVgap(10);
			gp.setPadding(new Insets(10,10,10,10));
			
	        create.setOnAction(ev -> {
				
    	    String ename = nameField.getText();
			String esname = snameField.getText();
			String ephone = phoneField.getText();
			String email1 = emailField.getText();
			String sal = salaryField.getText();
			double sal1=Double.parseDouble(sal);
			int day = bdayField.getValue().getDayOfMonth();
			int month = bdayField.getValue().getMonthValue();
			int year = bdayField.getValue().getYear();
			String eusername = usernameField.getText();
			String epassword = passwordField.getText();
			String e1level = levelField.getText();
			int elevel = Integer.parseInt(e1level);
		
	        Date bdate = new Date(day, month, year);
					
					
	     	Employees emp = new Employees(ename, esname, bdate ,ephone,sal1,email1,eusername,epassword,elevel);
	      		
	     	Accessemployes empFile1 = new Accessemployes();
	     	empFile1.addEmployee(emp);
			
	     	System.out.println("Successfully Added ");  
	    	primaryStage.setScene((new AdminView(this.currentUser)).exec(primaryStage));
					
			});
	        
			Scene scene=new Scene (gp,600,500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Admin Handler");
			primaryStage.show();
			
			
			
			
			return scene;
				
		}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
