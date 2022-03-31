package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class JUnitTesting {

	public int countWord() {
		int wordCount = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file name you want to count: ");
		String fileName = scan.nextLine();

		File file = new File(fileName);


		scan = new Scanner (file);
		while (scan.hasNext()) {
			String word = scan.next();
			wordCount++;
		}
		scan.close();
		System.out.print("Number of word in your file is: ");
		System.out.println(wordCount);
		return wordCount;
	}

	public void readFile(String input) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a file name you want to open: ");
			String fileName = scan.nextLine();
			
			// Open file
			File file = new File(fileName);

			// Read file
			Scanner fileReader = new Scanner(file);
		
			while(fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				System.out.println(data);
			}
			fileReader.close();
		} catch (Exception e) {
			System.out.println("Invalid file Or something wrong.");
		}
	}// end readFile

	
	public void writeFile(String input) {
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


}//end class
