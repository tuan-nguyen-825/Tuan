package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * Date: Apr 13-2022
 * Word Occurrences Application: is used to read files, write text to file, and count words in a file. 
 * Inherited JavaFX Application class. 
 * UI design tool: JavaFX Scene Builder
 * 
 * @author Tuan Nguyen
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/MainScene.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//scene.setFill(Color.BLUE);


			primaryStage.setTitle("Word Occurrences Application");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is main method of Word Occurrences Application
	 * @param args array of strings arguments is used to start the application
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
