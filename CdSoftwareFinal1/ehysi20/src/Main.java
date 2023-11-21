import javafx.application.Application;

import javafx.stage.Stage;
import model.User;
import view.AdminView;
import view.Login;
import view.MainMenu;
import view.ManageEmployee;
import view.ManagerView;


public class Main extends Application {

	public void start(Stage primaryStage) {
		//primaryStage.setScene((new MainMenu()).exec(primaryStage));


		primaryStage.setScene((new Login()).exec(primaryStage));
	    primaryStage.show(); 
	}
	
	
	public static void main(String[] args) {
           launch(args);		

	}

}
