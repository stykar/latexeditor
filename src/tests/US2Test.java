package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

import model.Document;
import model.DocumentManager;


class US2Test {

	@Test
	void test() {
				
		DocumentManager test = new DocumentManager();
		
		Document test1 = test.createDocument("Report");
		Document test2 = test.createDocument("Book");
		Document test3 = test.createDocument("Article");
		Document test4 = test.createDocument("Letter");
		Document test5 = test.createDocument("");
		
		test1.setContents("Test 1 is successfull");
		test2.setContents("Test 2 is successfull");
		test3.setContents("Test 3 is successfull");
		test4.setContents("Test 4 is successfull");
		test5.setContents("Test 5 is successfull");
		
		assertEquals(test1.getContents(),"Test 1 is successfull");
		assertEquals(test2.getContents(),"Test 2 is successfull");
		assertEquals(test3.getContents(),"Test 3 is successfull");
		assertEquals(test4.getContents(),"Test 4 is successfull");
		assertEquals(test5.getContents(),"Test 5 is successfull");
			
	
	}

}
