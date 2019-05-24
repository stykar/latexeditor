package tests;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import model.Document;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JTextArea;

import controller.Command;



public class LoadCommandTest implements Command {
	
		
	
	    
	    public LoadCommandTest(){
	        
	    }
	    
	    public void execute(Document doc, JTextArea input){
	    	
	    	
	    	
	    	BufferedReader src;
	        String fileData="";
	        String line="";
	        try {
	            src = new BufferedReader(new FileReader("tempTest.tex"));
	            line=src.readLine();
	            while (line != null) {
	                fileData+=line+"\n";
	                line=src.readLine();
	            }
	            src.close();
	        } catch (FileNotFoundException err) {

	        } catch (IOException err) {

	        }
	       
	        doc.setContents(fileData);;
	    	
	    }
	    
}