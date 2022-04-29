package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		createTable();
		insertWord();
		getData();
		launch(args);
	}

	//Read data from MySQL
	public static void getData() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement get = conn.prepareStatement("SELECT * FROM word");

			ResultSet rs = get.executeQuery();
			while(rs.next()) {
				System.out.println("Below are data from table word:");
				System.out.println(rs.getString("word_list") + "\t" + rs.getString("character_count"));
			}
			get.close();
		}catch (Exception e) {
			System.out.println(e);
		}finally {System.out.println("Insert complete.");}
	}

	//Insert word to MySQL
	public static void insertWord() throws Exception{

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter value for variable 1: ");
		String var1 = scan.nextLine();

		System.out.println("Enter value for variable 2: ");
		String var2 = scan.nextLine();

		System.out.println("Enter value for variable 3: ");
		String var3 = scan.nextLine();

		System.out.println("Enter value for variable 4: ");
		String var4 = scan.nextLine();

		try {
			Connection conn = getConnection();
			PreparedStatement inserted = conn.prepareStatement("INSERT INTO word (word_list, character_count)"
					+ "VALUES ('"+var1+"'," + var1.length()+"), "
					+ "('"+var2+"',"+var2.length()+"), ('"+var3+"', "+var3.length()+"),"
					+ " ('"+var4+"', "+var4.length()+")");

			inserted.executeUpdate();
			inserted.close();
		}catch (Exception e) {
			System.out.println(e);
		}finally {System.out.println("Insert complete.");}

	}

	//Create a table
	public static void createTable() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement createTable = conn.prepareStatement("CREATE TABLE IF NOT EXISTS word (word_list varchar(2000), character_count int)");
			createTable.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {System.out.println("Create Default Table complete.");}

	}

	//Connect to MySQL
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/wordOccurrences";
			String username = "root";
			String password = "Hocmai@1";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
