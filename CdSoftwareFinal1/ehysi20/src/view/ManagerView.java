package view;

import javafx.application.Application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Accesscditems;
import model.Cditems;
import model.Employees;
import model.Genre;
import model.User;


public class ManagerView  {
	
	private User currentUser;
	
	public ManagerView() {}

	public ManagerView(User currentUser){
		this.currentUser = currentUser;
	}
	
	public Scene exec(Stage primaryStage){
		
		Accesscditems cdFile = new Accesscditems();
		ObservableList<Cditems> cdList = FXCollections.observableArrayList(cdFile.getCditems());
		TableView cdTable = new TableView();
		
		cdTable.setEditable(true);
		
		TableColumn nameCdX = new TableColumn("Name");
		nameCdX.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//TableColumn genreX = new TableColumn("Genre");
		//genreX.setCellValueFactory(new PropertyValueFactory<>("genre"));
		
		TableColumn priceX = new TableColumn("Price");
		priceX.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn quantX = new TableColumn("Quantity");
		quantX.setCellValueFactory(new PropertyValueFactory<>("quant"));
		
		TableColumn releaseX = new TableColumn("Release Date");
		releaseX.setCellValueFactory(new PropertyValueFactory<>("release"));
		
		TableColumn singerX = new TableColumn("Singer");
		singerX.setCellValueFactory(new PropertyValueFactory<>("singer"));
		
		TableColumn genX = new TableColumn("Genre");
		genX.setCellValueFactory(new PropertyValueFactory<>("gen"));
		 
		
		cdTable.setItems(cdList);
		cdTable.getColumns().addAll(nameCdX,priceX,quantX,releaseX,singerX,genX);
		cdTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				
		Button add = new Button (" Add ");
		Button cancel = new Button("Cancel");
		Button edit = new Button("Edit Selected");
		Button delete = new Button ("Delete");
		Button back = new Button ("Back"); 
		Button checkGenre = new Button("Check Genre");
		
		cancel.setOnAction(ev -> {
				primaryStage.close();
		});

		 
		BorderPane bp = new BorderPane();
		HBox hb = new HBox();
		
		if(currentUser.getLevel()==3)
			hb.getChildren().add(back);
		
		hb.getChildren().addAll(add,edit, cancel, delete,checkGenre);
		hb.setMargin(edit, new Insets(10, 10, 10, 10));;
		hb.setMargin(cancel, new Insets(0, 10, 0, 0));;
		hb.setMargin(add, new Insets(0, 10, 0, 0));;
		hb.setMargin(delete, new Insets(0, 10, 0, 0));;
		hb.setMargin(back, new Insets(0, 10, 0, 0));;
		hb.setAlignment(Pos.CENTER);
			
		bp.setCenter(cdTable);
		bp.setBottom(hb);
		
		add.setOnAction(e -> {
			primaryStage.setScene((new ManagHandler(this.currentUser)).exec(primaryStage));
		});

		Scene scene = new Scene(bp,700,350);

		primaryStage.setTitle(" Manager View ");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		back.setOnAction(e -> {
			primaryStage.setScene((new MainMenu(currentUser)).exec(primaryStage));	
		});
		
		edit.setOnAction(e -> {
			Cditems cd = (Cditems) cdTable.getSelectionModel().getSelectedItem();
			System.out.println(cd);
			primaryStage.setScene((new ManageCd(this.currentUser, cd)).exec(primaryStage));
			
		});
		
		delete.setOnAction(e -> {
			
			Cditems cd = (Cditems) cdTable.getSelectionModel().getSelectedItem();
			int id = cd.getId();
			cdFile.remove(id);
			System.out.println("Item Deleted");
			primaryStage.setScene((new ManagerView(this.currentUser)).exec(primaryStage));
			
		});
		
		
		checkGenre.setOnAction(e ->{
			primaryStage.setScene((new GenreView(this.currentUser,cdFile)).exec(primaryStage));

		});

		
		return scene;
	}


}
