package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class CountWordTest {
	// Test if a file open and code can count total work in that file: my file.txt (has 9 char.)
	@Test
	public void test() {
		JUnitTesting test = new JUnitTesting();
		int output = test.countWord();
		assertEquals(9, output);


	}

}
