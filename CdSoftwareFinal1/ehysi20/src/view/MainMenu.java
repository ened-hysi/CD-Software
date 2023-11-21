package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;

public class MainMenu {
	
	
	User currentUser;
	Stage primaryStage;
	
	public MainMenu(){
		
	}
	
	public MainMenu(User currentUser)
	{
		this.currentUser = currentUser;
	}
	
	public Scene exec(Stage ps)
	{
		primaryStage = ps;
		
		BorderPane mainPane = new BorderPane();
		
		HBox userButtons = new HBox();
		userButtons.getStyleClass().add("bluebox");
		Button cashierview = new Button("Cashier View");
		Button managerview = new Button(" Manager View ");
		Button adminview = new Button(" Admin View ");
		

		
		userButtons.getChildren().addAll(cashierview, managerview,adminview);
		userButtons.setMargin(managerview, new Insets(20, 20, 20, 20));
		userButtons.setAlignment(Pos.CENTER);
		
		
		mainPane.setCenter(userButtons);
		
		cashierview.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				primaryStage.setScene((new CashierView(currentUser)).exec(primaryStage));
				
			}
		});
		
		managerview.setOnAction(e -> {
			primaryStage.setScene((new ManagerView(currentUser)).exec(primaryStage));
		});
		
		adminview.setOnAction(e -> {
			primaryStage.setScene((new AdminView(currentUser)).exec(primaryStage));
		});
		
		

		Scene scene = new Scene(mainPane,600,400);

		return scene;
	}
	
	
	

}
