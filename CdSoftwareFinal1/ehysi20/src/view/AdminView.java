package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Accessemployes;
import model.Employees;
import model.User;

public class AdminView {
	
private User currentUser;

public AdminView() {}
	
	public AdminView(User currentUser){
		this.currentUser = currentUser;
	}
	
	public Scene exec(Stage primaryStage)
	{
		Accessemployes empFile = new Accessemployes();
		
		ObservableList<Employees> empList = FXCollections.observableArrayList(empFile.getEmployees());
		
		TableView empTable = new TableView();
		empTable.setEditable(true);
		
		TableColumn nameC = new TableColumn("Name");
		nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn snameC = new TableColumn("Surname");
		snameC.setCellValueFactory(new PropertyValueFactory<>("sname"));
		
		TableColumn birthdayC = new TableColumn("Birthday");
		birthdayC.setCellValueFactory(new PropertyValueFactory<>("bdate"));
		
		TableColumn phoneC = new TableColumn("Phone");
		phoneC.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		TableColumn salaryC = new TableColumn("Salary");
		salaryC.setCellValueFactory(new PropertyValueFactory<>("salary"));
		
		TableColumn emailC = new TableColumn("Email");
		emailC.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn userC = new TableColumn("Username");
		userC.setCellValueFactory(new PropertyValueFactory<>("user"));
		
		TableColumn passC = new TableColumn("Password");
		passC.setCellValueFactory(new PropertyValueFactory<>("pass"));
		
		TableColumn levelC = new TableColumn("Level");
		levelC.setCellValueFactory(new PropertyValueFactory<>("level"));
		
		empTable.setItems(empList);
		empTable.getColumns().addAll(nameC, snameC, birthdayC, phoneC, salaryC,emailC,userC,passC,levelC);
		empTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		
		Button cancel = new Button("Cancel");
		Button edit = new Button("Edit Selected");
		Button add = new Button ("Add");
		Button delete = new Button("Delete");
		Button back = new Button ("Back");
		Button logout = new Button ("Log Out");
		
		
		BorderPane bp = new BorderPane();
		HBox hb = new HBox();

		
		hb.getChildren().addAll(back, logout, add,edit,delete, cancel);
		hb.setMargin(edit, new Insets(10, 10, 10, 10));;
		hb.setMargin(logout, new Insets(10, 10, 10, 10));;
		hb.setMargin(add, new Insets(10, 10, 10, 10));;
		hb.setMargin(delete, new Insets(10, 10, 10, 10));;
		hb.setAlignment(Pos.CENTER);

		bp.setCenter(empTable);
		bp.setBottom(hb);
	
		
		add.setOnAction(e -> {
			primaryStage.setScene((new Adminhandler(this.currentUser)).exec(primaryStage));
		});
		
		
		
		Scene scene = new Scene(bp,900,400);

		primaryStage.setTitle(" Employees ");
		primaryStage.setResizable(false);
		
		
		cancel.setOnAction(e -> {
			primaryStage.close();
		});
		
		
		edit.setOnAction(e -> {
			Employees emp = (Employees) empTable.getSelectionModel().getSelectedItem();
			System.out.println(emp);
			primaryStage.setScene((new ManageEmployee(this.currentUser, emp)).exec(primaryStage));
			
		});
		
	
		delete.setOnAction(e -> {
			Employees emp = (Employees) empTable.getSelectionModel().getSelectedItem();
			int id = emp.getId();
			empFile.rm(id);
			System.out.println("Item Deleted");
			primaryStage.setScene((new AdminView(this.currentUser)).exec(primaryStage));
			
		});
		
		
		back.setOnAction(e -> {
			primaryStage.setScene((new MainMenu(currentUser)).exec(primaryStage));	
		});
		
		logout.setOnAction(e -> {
			primaryStage.setScene((new Login()).exec(primaryStage));	
		});
		
		return scene;
	}
	

}
