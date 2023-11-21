package view;
 

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Accessemployes;
import model.Date;
import model.Employees;
import model.User;

public class ManageEmployee {

		private User currentUser;
		private Employees editEmployee;	
		
		public ManageEmployee(User currentUser, Employees editEmployee){
			this.currentUser = currentUser;
			this.editEmployee = editEmployee;
		}
		
		public Scene exec(Stage primaryStage){
			
			String nameText = editEmployee.getName();
			String snameText = editEmployee.getSname();
			String phoneText = editEmployee.getPhone();
			Date birthdayText = editEmployee.getBdate();
			String emailText = editEmployee.getEmail();
			double salary1 = editEmployee.getSalary();
			String salaryText = salary1 +"";
			String usernameText = editEmployee.getUser();
			String passwordText = editEmployee.getPass();
			int level1 = editEmployee.getLevel();
			String levelText = level1 + "";

			
			Label name = new Label("Name: ");
			Label sname = new Label("Surname: ");
			Label phone = new Label("Phone: ");
			Label birthday = new Label("Birthday: ");
			Label email = new Label("Email: ");
			Label salary = new Label("Salary: ");
			Label username = new Label("Username: ");
			Label password = new Label("Password: ");
			Label level = new Label("Level: ");
			
			
			TextField nameField = new TextField(nameText);
			TextField snameField = new TextField(snameText);
			TextField phoneField = new TextField(phoneText);
			TextField emailField = new TextField(emailText);
			TextField salaryField = new TextField(salaryText);
			DatePicker bdayField = new DatePicker();
			TextField usernameField = new TextField(usernameText);
			TextField passwordField = new TextField(passwordText);
			TextField levelField  = new TextField(levelText);
			
			
			bdayField.setValue(LocalDate.of(birthdayText.getYear(), birthdayText.getMonth(), birthdayText.getDay()));
	
			Button create = new Button("Create");
			Button cancel = new Button("Cancel");
			
			GridPane gp = new GridPane();
			gp.addColumn(0, name, sname, phone, birthday, email,salary, username, password, level);
			gp.addColumn(1, nameField, snameField, phoneField, bdayField, emailField,salaryField, usernameField, passwordField, levelField);
			
			gp.setHgap(10);
			gp.setVgap(10);
			gp.setPadding(new Insets(10,10,10,10));
			
			HBox hb = new HBox(create, cancel);
			HBox.setMargin(create, new Insets(10,10,10,10));
			HBox.setMargin(cancel, new Insets(10,10,10,10));
			hb.setAlignment(Pos.BOTTOM_RIGHT);
			
			BorderPane mainPane = new BorderPane();
			mainPane.setCenter(gp);
			mainPane.setBottom(hb);
			
			Scene scene = new Scene(mainPane);

			primaryStage.setTitle("Edit Employee");
			

			cancel.setOnAction(e -> {
				primaryStage.setScene((new AdminView(this.currentUser)).exec(primaryStage));
			});
			
			create.setOnAction(e -> {

				Accessemployes empList = new Accessemployes();
				
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
				
				Employees emp = new Employees(ename, esname, bdate, ephone, sal1,email1,eusername,epassword,elevel);
				
				empList.editEmployee(empList.getPosition(editEmployee), emp);
				
				this.showSuccessful(primaryStage);
					
			});
			
			return scene;
		}
		
		public void showSuccessful(Stage primaryStage)
		{
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			
			VBox vb = new VBox();
			
			String message = "Successfully Inserted!";
			message = "Successfully Edited!";

			Label msg = new Label(message);
			Button ok = new Button("OK");
			
			vb.getChildren().addAll(msg, ok);
			Scene scene = new Scene(vb);

			stage.setTitle("Information");
			stage.setScene(scene);
			stage.show();
			
			ok.setOnAction(e -> {
				stage.close();
				
		    primaryStage.setScene((new AdminView(this.currentUser)).exec(primaryStage));
			});
		}
} 
