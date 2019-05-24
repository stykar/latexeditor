package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import controller.Command;
import model.Document;
import model.DocumentManager;

class US9Test {
	
	Command cmd;
	DocumentManager test = new DocumentManager();
	Document test1 = new Document("","","","","");

	@Test
	void test() {
		String check ="\\documentclass[11pt,a4paper]{report}\n";
		
		cmd = new LoadCommandTest();
		cmd.execute(test1,null);
		
		assertEquals(check,test1.getContents());
		
	}

}
