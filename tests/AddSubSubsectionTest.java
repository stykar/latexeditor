package tests;
import model.*;


import javax.swing.JTextArea;

import controller.Command;

public class AddSubSubsectionTest implements Command {
	
	    
	    public AddSubSubsectionTest(){
	        
	    }
	    
	    public void execute(Document doc, JTextArea input){
	    	
	    	doc.setContents("\\Subsubsection{}");
	    }
	

}