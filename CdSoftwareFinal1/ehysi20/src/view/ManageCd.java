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
import model.Accesscditems;
import model.Date;
import model.Genre;
import model.Cditems;
import model.User;

public class ManageCd {
	
	private User currentUser;
	private Cditems editCditems;


	public ManageCd(User currentUser, Cditems editCditems){
		this.currentUser = currentUser;
		this.editCditems = editCditems;
	}
	
	public Scene exec(Stage primaryStage){

		String nameText = editCditems.getName();
		double price1 = editCditems.getPrice();
		String priceText = price1 +"";
		int quant = editCditems.getQuant();
		String quantText = quant +"";

		String singerText = editCditems.getSinger();
		Date dateText= editCditems.getRelease();
	
		
		ObservableList<Genre> GENRE = FXCollections.observableArrayList(Genre.values());
		
		Label name = new Label("Name: ");
		Label price = new Label("Price: ");
		Label quantity = new Label("Quantity: ");
		Label purchdate = new Label("Purchase Date: ");
		Label singer = new Label("Singer: ");
		Label gen = new Label("Genres: ");
		
		TextField nameField = new TextField(nameText);
		TextField priceField = new TextField(priceText);
		TextField quantityField = new TextField(quantText);
		TextField singerField = new TextField(singerText);
		DatePicker pDateField = new DatePicker();
		
		pDateField.setValue(LocalDate.of(dateText.getYear(), dateText.getMonth(), dateText.getDay()));

		ComboBox GENREFIELD = new ComboBox(GENRE);
		GENREFIELD.getSelectionModel().select(editCditems.getGen());
		
		Button create = new Button("Edit");
		Button cancel = new Button("Cancel");
		
		GridPane gp = new GridPane();
		gp.addColumn(0, name, price, quantity,purchdate,singer, gen);
		gp.addColumn(1, nameField, quantityField,priceField, pDateField, singerField, GENREFIELD);
		
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
			primaryStage.setScene((new ManagerView(this.currentUser)).exec(primaryStage));
		});
		
		create.setOnAction(e -> {

		  Accesscditems cdList = new Accesscditems();
		 
		  String ename = nameField.getText();
		  String eprice = priceField.getText();
		  double eprice1 = Double.parseDouble(eprice);
		  String equant = quantityField.getText();
		  int equant1=Integer.parseInt(equant);
		  String esinger = singerField.getText();
		  int day = pDateField.getValue().getDayOfMonth();
		  int month = pDateField.getValue().getMonthValue();
		  int year = pDateField.getValue().getYear();
		  Date release = new Date(day, month, year);
		  Genre egen = (Genre) GENREFIELD.getSelectionModel().getSelectedItem();
			
		  Cditems cdit = new Cditems(ename,eprice1,equant1,release,esinger,egen);
		  
		  
		  cdList.editCditems(cdList.search(editCditems), cdit);

		  this.showSuccessful(primaryStage);
	
			
		});
		
		return scene;
	}
	
	public void showSuccessful(Stage primaryStage)
	{
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		VBox vb = new VBox();

		String message = "Successfully Edited!";

		Label msg = new Label(message);
		Button ok = new Button("OK");
		
		vb.getChildren().addAll(msg, ok);
		Scene scene = new Scene(vb);

		stage.setTitle("Information");
		stage.setScene(scene);
		stage.show();
		
		ok.setOnAction(e -> {
			stage.close();

		primaryStage.setScene((new ManagerView(this.currentUser)).exec(primaryStage));
		});
	}

}
