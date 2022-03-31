package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JUnitTesting {

	public int countWord() {
		int wordCount = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a file name you want to count: ");
		String fileName = scan.nextLine();

		File file = new File(fileName);
		//File file = new File(textFieldFileName.getText());

		//scan = new Scanner (file);
		while (scan.hasNext()) {
			String word = scan.next();
			wordCount++;
		}
		scan.close();
		System.out.print("Number of word in your file is: ");
		System.out.println(wordCount);
		return wordCount;
	}

}//end class
