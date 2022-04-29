package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Date: Apr 13-2022
 * Controller class: contains all methods to work with the Main Scene like readFile, writeFile, and countWord.
 * 		initialize(): set buttons on UI layout inactive until fill in label text.
 * 		readFile(): read a file by enter a file name. Display the file in console and application
 *		writeFile(): write text to a file. Will create a new file if it is not exist. 
 * 		contWord(): count word in a file. 
 * 
 * @author Tuan Nguyen
 * @version 1.0
 * 
 */
public class MainSceneController {
	@FXML private Label labelResult;
	@FXML private TextField textFieldFileName;
	@FXML private Button btnRead;
	@FXML private Button btnWrite;
	@FXML private Button btnCount;

	@FXML
	public void initialize() {
		//textFieldFileName.setText("The Raven.txt");

		textFieldFileName.textProperty().addListener((obs, oldText, newText) -> {
			System.out.println("Text changed from "+oldText+" to "+newText);
			Boolean isFileNameEmpty = textFieldFileName.getText().isEmpty();
			btnRead.setDisable(isFileNameEmpty);
			btnWrite.setDisable(isFileNameEmpty);
			btnCount.setDisable(isFileNameEmpty);
		});


	}
	/**
	 * This method is used to read and display text files' content.
	 * This method use File and Scanner class to read files.
	 * 
	 * @param event enter file name, then click on Read-file button to read files
	 * @param fileName: name of text files includes file extensions
	 * @param file: file open
	 * @param fileReader: file scan to read
	 *
	 */
	public void readFile(ActionEvent event) {
		try {
			//			Scanner scan = new Scanner(System.in);
			//			System.out.println("Enter a file name you want to open: ");

			//			String fileName = scan.nextLine();
			String fileName = textFieldFileName.getText();

			// Open file
			File file = new File(fileName);

			// Read file
			Scanner fileReader = new Scanner(file);
			labelResult.setText("");
			while(fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				System.out.println(data);
				labelResult.setText(labelResult.getText()+data); 
			}
			fileReader.close();//After complete scanning, close the file
		} catch (Exception e) {
			System.out.println("Invalid file Or something wrong.");
		}
	}// end readFile

	/**
	 * This method is used to write text to a file.
	 * This method use FileWriter class and writer method to write text into a file.
	 * A new file will automatic created if it not exist. 
	 * Text will be written overlap on the file destination. 
	 * 
	 * @param event On UI layout, enter file name and click on write button to write a file.
	 */
	public void writeFile(ActionEvent event) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a file name you want to write into it: ");
			String fileName = scan.nextLine();
			System.out.println("Enter your text: ");
			String fileContent = scan.nextLine();

			FileWriter fileWriter = new FileWriter(fileName);
			fileWriter.write(fileContent);
			fileWriter.close();

			System.out.println("Your text has successful added to the file: ");
		}
		catch (Exception e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}
	}//end

	/**
	 * This method is used to count number of words in a file.
	 * 
	 * @param event on UI layout, enter a file name and click on count button to count words in a file.
	 * @param wordCount: total number of words counted in a file
	 * @param file: file name
	 */
	public void countWord(ActionEvent event) {

		try {
			int wordCount = 0;

			Scanner scan = new Scanner(System.in);
			//			System.out.println("Enter a file name you want to count: ");
			//			String fileName = scan.nextLine();

			//			File file = new File(fileName);
			File file = new File(textFieldFileName.getText());

			scan = new Scanner (file);
			while (scan.hasNext()) {
				String word = scan.next();
				wordCount++;
			}
			scan.close();
			System.out.print("Number of word in your file is: ");
			System.out.println(wordCount);
			labelResult.setText(String.valueOf(wordCount)+" words");

		} catch (FileNotFoundException e) {
			System.out.println("File is not existing. Please check file name again.");
			e.printStackTrace();
		}
	}
}

