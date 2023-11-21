package view;

import java.io.File;

import model.Accessemployes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import model.Employees;


public class Login {	
	public Scene exec(Stage primaryStage){
		
		Label userLabel = new Label("Username: ");
		userLabel.setFont(Font.font("Times New Roman", 
				FontWeight.BOLD, 16));
		TextField userField = new TextField();
		userField.setPromptText("Enter Username");
		
		Label passLabel = new Label("Password: ");
		passLabel.setFont(Font.font("Times New Roman", 
				FontWeight.BOLD, 16));
		PasswordField passField = new PasswordField();
		passField.setPromptText("Enter Password");
		
		Text err = new Text("Username and Password do not match!");
		err.setStroke(Color.RED);
		err.getStyleClass().add("error");
		err.setVisible(false);
		
		StackPane pane = new StackPane();
		
		Button login = new Button("Login");
		
		pane.getChildren().add(login);
				
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(20);
		gp.setPadding(new Insets(10,10,10,10));
		gp.addRow(0, userLabel, userField);
		gp.addRow(1, passLabel, passField);
		gp.setAlignment(Pos.CENTER);
				
		login.setAlignment(Pos.CENTER);
		
		HBox hb_err = new HBox(err);
		hb_err.setAlignment(Pos.CENTER);
		
		GridPane mainPane = new GridPane();
		Text cd=new Text("CD--SOFTWARE");
		cd.setId("welcome-text");
		cd.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 20));
	
		mainPane.addColumn(0, cd, gp, hb_err,pane);
		mainPane.setAlignment(Pos.CENTER);
		
		Handler handler1= new Handler();
		login.setOnAction(handler1);

		Scene scene = new Scene(mainPane,600,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
		
		login.setOnAction(e -> {
			String username = userField.getText();
			String password = passField.getText();
			
			boolean found = false;
			
			Accessemployes emp = new Accessemployes();
			Employees user = emp.checkUser(username, password);
			
			if(user != null)
			{
				System.out.println("Logged in");
				primaryStage.close();
				primaryStage.setScene((new MainMenu(user)).exec(primaryStage));
				primaryStage.show();
			}
			
			if(user.getLevel()==1)
			{
				System.out.println("Logged in");
				primaryStage.setScene((new CashierView(user)).exec(primaryStage));
				//primaryStage.show();
			} else {
				err.setVisible(true);
			}
			if(user.getLevel()==2)
			{
				System.out.println("Logged in");
				primaryStage.setScene((new ManagerView(user)).exec(primaryStage));
				//primaryStage.show();
			} else {
				err.setVisible(true);
			}
			if(user.getLevel()==3)
			{
				System.out.println("Logged in");
				primaryStage.setScene((new MainMenu(user)).exec(primaryStage));
				//primaryStage.show();
			} else {
				err.setVisible(true);
			}
		});
		
		/*cancel.setOnAction(e -> {
			primaryStage.close();
		});
		mainPane.setStyle("-fx-background-image: url('resources/images/LcKoLLkca.png');"
				+ "-fx-background-repeat: stretch;");
		Scene scene = new Scene(mainPane,600,300);
		scene.getStylesheets().addAll(this.getClass().getResource("../resources/css/style.css").toExternalForm());
		primaryStage.setTitle("Login");
		*/
		return scene;
		
		
	}

}
