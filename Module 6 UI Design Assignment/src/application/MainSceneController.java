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

	// Read a file
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

	// Write to a file
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

	// Count word in a file
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

