import java.io.*;
import java.util.*;

public class ReadFile {
	//Count number of words in a file
	public static int countWords(String fileName) throws FileNotFoundException {
		int wordCount = 0;
		Scanner scan = new Scanner (new File(fileName));
		while (scan.hasNext()) {
			String word = scan.next();
			wordCount++;
		}
		return wordCount;
	}
	
	//Main
	public static void main(String[] args) throws IOException {
		//Open a file
		Scanner file;
		file = new Scanner (new File ("The Raven.txt"));

		//Read the file
		String fileContent = "";
		while(file.hasNext()) {
			fileContent = fileContent.concat(file.nextLine() + "\n");
		}

		//Write the file
		FileWriter fileWriter = new FileWriter("NewRaven.txt");
		fileWriter.write(fileContent);

		//Call method: countWords()
		int wordCount = countWords("The Raven.txt");
		System.out.println("Total number of words: " + wordCount);

		//Close the file
		fileWriter.close();

	}
}


