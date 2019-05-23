package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JTextArea;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

import model.Document;
import model.DocumentManager;
import controller.Command;
import controller.AddChapter;


public class US3Test {
	
	Command cmd;
	DocumentManager test = new DocumentManager();
	Document test1 = test.createDocument("Report");
	
	
	@Test
	void test1 () {
		
		AddChapter ad1 = new AddChapter(null);
		
		cmd = new AddChapter(ad1);
		cmd.execute(test1,ad1);
		
		assertEquals(test1.getContents() + "\\chapter{...}"  , cmd.getContents());
	
		
	}
		
	
	


}



