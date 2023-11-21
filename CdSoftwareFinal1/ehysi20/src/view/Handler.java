package view;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Handler implements EventHandler<ActionEvent> {

	public void handle (ActionEvent e) {
		Stage primaryStage=new Stage();
		Label eventlabel=new Label ("Login button clicked ok");
		Scene scene1=new Scene (eventlabel,600,300);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Handler");
		primaryStage.show();
		
		}
}
