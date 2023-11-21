package view;

import java.util.ArrayList;

import javafx.application.Application;




import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Accesscditems;
import model.Bill;
import model.Cashier;
import model.Cditems;
import model.Date;
import model.Employees;
import model.User;

public class CashierView {
	
	
     private User currentUser;
	
	 public CashierView() {}
	
	
	public CashierView(User currentUser){
		this.currentUser = currentUser;
	}

	public Scene exec(Stage primaryStage){
		Accesscditems cdFile = new Accesscditems();
		cdFile.readF();
		
		
		ObservableList<Cditems> cdList = FXCollections.observableArrayList(cdFile.getCditems());
		
		
		TableView cdTable = new TableView();
		
		cdTable.setEditable(true);
		
		TableColumn nameCd = new TableColumn("Name");
		nameCd.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn genre = new TableColumn("Genre");
		genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		
		TableColumn price = new TableColumn("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn quant = new TableColumn("Quantity");
		quant.setCellValueFactory(new PropertyValueFactory<>("quant"));
		
		TableColumn release = new TableColumn("ReleaseDate");
		release.setCellValueFactory(new PropertyValueFactory<>("release"));
		
		TableColumn singer = new TableColumn("Singer");
		singer.setCellValueFactory(new PropertyValueFactory<>("singer"));
		 
		
		cdTable.setItems(cdList);
		cdTable.getColumns().addAll(nameCd, genre,price,quant,release,singer);
		
		//cdTable.setMaxWidth(Region.USE_PREF_SIZE);
		cdTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
				
		
		Button print = new Button("Print");
		Button add = new Button (" Add ");
		Button back = new Button ("Back");

		
		BorderPane bp = new BorderPane();
		HBox hb = new HBox();
		
		
		Label enter =new Label (" Quantity: ");
		Label totalAmount= new Label (" Total amount: ");
		totalAmount.setFont(new Font("Calibri Body", 20.0));
		enter.setFont(new Font("Calibri Body", 20.0));
		TextField quantity = new TextField();
		
		//String e1level = quantity.getText();
		//int quanBill = Integer.parseInt(e1level);
		
        
		
		TextField result=new TextField();
		//TextField searchField = new TextField();
		
		/*searchField.setPromptText(" Search ");
		
		 searchField.setLayoutX(11.0);
	        searchField.setLayoutY(83.0);
	       // searchField.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
	        //searchField.setStrokeWidth(0.0);
	        searchField.setStyle("-fx-fill: #f70d1a;");
	        
	       // searchField.setWrappingWidth(50.80340623855591);
	        searchField.setFont(new Font("Calibri Body", 20.0));
	        searchField.setMinWidth(Region.USE_PREF_SIZE);
	        searchField.setMaxWidth(Region.USE_PREF_SIZE);
	        
	        result.setFont(new Font("Calibri Body", 15.0));
	        result.setMinWidth(Region.USE_PREF_SIZE);
	        result.setMaxWidth(Region.USE_PREF_SIZE);
	        */
	        
	        
		
		if(currentUser.getLevel()==3)
			hb.getChildren().add(back);
		
	    hb.getChildren().add(print);
		hb.getChildren().addAll(totalAmount,result);
		hb.setSpacing(15.0);
		hb.setPadding(new Insets(15, 12, 15, 12));
		hb.setAlignment(Pos.CENTER);
		
		
		bp.setCenter(cdTable);
		bp.setBottom(hb);
		
		GridPane gp=new GridPane();

		//gp.add(searchField, 0, 0,4,1);
		gp.add(enter, 10, 0);
		
		gp.add(quantity, 15, 0);
		gp.add(add, 22, 0);
		
	     //gp.add(totalAmount, 15, 15);
	     //gp.add(result, 18, 15);
		gp.setHgap(2); 
		gp.setVgap(2);
		gp.setPadding(new Insets(15, 12, 15, 12));
		
		bp.setTop(gp);

		bp.setPadding(new Insets(15, 12, 15, 12));

		Scene scene = new Scene(bp,550,500);
		 

		primaryStage.setTitle(" Cashier View ");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		back.setOnAction(e -> {
			primaryStage.setScene((new MainMenu(currentUser)).exec(primaryStage));	
		});
		
		/*add.setOnAction(e ->{
			Cditems cd = (Cditems) cdTable.getSelectionModel().getSelectedItem();
			cdFile.addToBill(cd);
			cdFile.addToQuanBill(quanBill);
			
		});
	
		print.setOnAction(e -> {
			//Bill newBill = new Bill(currentUser, cdFile.getBillItems(), cdFile.getQuanBills());
			primaryStage.setScene((new CashierView(currentUser)).exec(primaryStage));	
		});*/
	  
		return scene;
	}
}
	

