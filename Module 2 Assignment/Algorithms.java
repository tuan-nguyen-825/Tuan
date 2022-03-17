package assignment_2;

/* Create a program to demonstrate the use of Collections methods reverse, fill, copy, max and min
1. Create and display a list of three characters
2. Reverse and display the list
3. Create copy list from an array of the three Characters
4. Copy the contents of list in step one into copy list of the step three.
5. Fill list with letter R
6. Create a method named output and display at it shown below
7. Name your class "Algorithms"

Output:
list contains:
The list is: P C M
Max: P Min: C

After calling reverse, list contains:
The list is: M C P
Max: P Min: C

After copying, copyList contains:
The list is: M C P
Max: P Min: C

After calling fill, list contains:
The list is: R R R
Max: R Min: R
*/
// Import needed java packages
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

//  7. Create a class name "Algorithms"
public class Algorithms {
//	6. Create a method named output to display
   private static void output(String title, List<Character> listLetters)  //Parameters: string title & a list
   {
      System.out.printf(title);                                          // title
      System.out.printf("%nThe list is: ");                              // a text to described the list elements

      for (Character element : listLetters)                             // iterate list
         System.out.printf("%s ", element);
      
      System.out.printf("%nMax: %s", Collections.max(listLetters));     // Max
      System.out.printf(" Min: %s%n", Collections.min(listLetters));    // Min
   }//end output()
   
      // main
	public static void main(String[] args) {
		try {                                                       // try & catch: start
//		1. Create and display a list of three characters
		Character[] letters = {'P', 'C', 'M'};                     // creating an array of Character type
		List<Character> listLetters = Arrays.asList(letters);     //  getting a list view of array letter
	    output("list contains: ", listLetters);                  //   call output()---to display the list
	    
	    
//	    2. Reverse and display the list
      Collections.reverse(listLetters);                                     // reverse order the elements
      output("%nAfter calling reverse, list contains:", listLetters);       // display list after reverse

//      3. Create copy list from an array of the three Characters      
      Character[] lettersCopy = new Character[3];                          // create a copy of array letters. Length 3.
      List<Character> copyList = Arrays.asList(lettersCopy);               // create a copy of the list to view array lettersCopy
      
//    4. Copy the contents of list in step one into copy list of the step three.
      Collections.copy(copyList, listLetters);                            // copy list
      output("%nAfter copying, copyList contains:", copyList);            // display a copy list

//    5. Fill list with letter R
      Collections.fill(listLetters, 'R');                                // fill letter 'R' to listLetters
      output("%nAfter calling fill, list contains:", listLetters);       // display list after filled in 
		}catch(Exception e) {
			e.printStackTrace();
		}                                                                // try & catch: end
	}//end main
}//end Algorithms class
