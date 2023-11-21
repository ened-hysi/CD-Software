package view;


import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Accesscditems;
import model.Cditems;
import model.Date;
import model.Genre;
import model.User;


public class ManagHandler implements EventHandler<ActionEvent> {
	User currentUser;
	
	public ManagHandler( User currentUser){
		this.currentUser = currentUser;
	};
	
	public Scene exec (Stage primaryStage) {
		
		Accesscditems cdFile = new Accesscditems();
		
		ObservableList<Genre> GENRE = FXCollections.observableArrayList(Genre.values());
		
		Label name = new Label("Name: ");
		Label price = new Label("Price: ");
		Label quantity = new Label("Quantity: ");
		Label purchdate = new Label("Purchase Date: ");
		Label singer = new Label("Singer: ");
		Label gen = new Label("Genres: ");
		
		TextField nameField = new TextField();
		TextField priceField = new TextField();
		TextField quantityField = new TextField();
		TextField singerField = new TextField();
		DatePicker pDateField = new DatePicker();
		
		
		Button create = new Button ("Create");
		Button cancel = new Button("Cancel");

		
		ComboBox GENREFIELD = new ComboBox(GENRE);
		GENREFIELD.getSelectionModel().select(Genre.POP);
		
		BorderPane bp=new BorderPane();
		HBox hb=new HBox();
		hb.getChildren().addAll(create,cancel);
		hb.setMargin(cancel, new Insets(0, 0, 0, 10));;
		bp.setBottom(hb);
		
		GridPane gp = new GridPane();
		gp.addColumn(0, name, price, quantity, purchdate,singer,gen);
		gp.addColumn(1, nameField, priceField, quantityField, pDateField,singerField,GENREFIELD);
		gp.add(bp,0,7);
		
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10,10,10,10));
		
       create.setOnAction(ev -> {
			
	      String ename = nameField.getText();
		  String eprice = priceField.getText();
		  double eprice1 = Double.parseDouble(eprice);
		  String equant = quantityField.getText();
		  int equant1=Integer.parseInt(equant);

		  String esinger = singerField.getText();
		  int day = pDateField.getValue().getDayOfMonth();
		  int month = pDateField.getValue().getMonthValue();
		  int year = pDateField.getValue().getYear();
		  Genre egen = (Genre) GENREFIELD.getSelectionModel().getSelectedItem();
					
	      Date purcchdate = new Date(day, month, year);
					
					
	      Cditems cd = new Cditems(ename, eprice1 ,equant1,purcchdate,esinger,egen);
					
		  Accesscditems cdFile1 = new Accesscditems();
		  cdFile1.readF();
		  cdFile1.addCditems(cd);
					
		  System.out.println("Successfully Added " + cd.getRelease());
		  primaryStage.setScene((new ManagerView(this.currentUser)).exec(primaryStage));
				
		});
       
       cancel.setOnAction(e -> {
		  primaryStage.setScene((new ManagerView(this.currentUser)).exec(primaryStage));
		});
       
		Scene scene=new Scene (gp,600,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Handler");
		primaryStage.show();
		return scene;
			
	}


	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
