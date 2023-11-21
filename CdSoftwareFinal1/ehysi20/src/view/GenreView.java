package view;
import model.Accesscditems;
import model.Genre;
import model.User;

import javafx.scene.control.Button;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GenreView {
	
	private User currentUser;
	private Accesscditems cdList;
	
	
	public GenreView(User currentUser,Accesscditems cdList){
		this.currentUser = currentUser;
		this.cdList = cdList;
	}
	
	public Scene exec(Stage primaryStage){
	
		List<Genre> found = new ArrayList<Genre>();
		for(Genre gen : Genre.values()){
		    if(cdList.countGenre(gen) <= 5){
		        found.add(gen);
		    }
		}
		Button done = new Button (" Done ");

		BorderPane bp = new BorderPane();
		VBox hb = new VBox();
		HBox hb1 = new HBox();
		
	
		
		bp.setCenter(hb);
		bp.setBottom(hb1);
		//bp.setBottom(done);
		hb1.getChildren().add(done);
		hb1.setAlignment(Pos.BOTTOM_CENTER);
		 done.setOnAction(e -> {
            
			primaryStage.setScene((new ManagerView(this.currentUser)).exec(primaryStage));

         });

		
		String sample = "";
		
		int i = 0;
		for(Genre f: found) {
			i+=5;
			sample = "Genre " + f.name() + " has less than 5 items \n";
			Text sampletxt = new Text(sample);
			sampletxt.setId("welcome-text");
			sampletxt.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
			hb.getChildren().add(sampletxt);
			hb.setMargin(sampletxt, new Insets(10, 10, 10, 10));;

		}
		
		Scene scene = new Scene(bp,500,350);
		
		
		return scene;
	}
}
