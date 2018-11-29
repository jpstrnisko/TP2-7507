package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class StartScreen extends Application {
	
	private Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			
	        this.stage = primaryStage;
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GameView.fxml"));
	        Parent root = (Parent)loader.load();
	        primaryStage.setTitle("Algo Empires");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
