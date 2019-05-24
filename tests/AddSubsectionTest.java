package tests;
import model.*;


import javax.swing.JTextArea;

import controller.Command;

public class AddSubsectionTest implements Command {
	
	    
	    public AddSubsectionTest(){
	        
	    }
	    
	    public void execute(Document doc, JTextArea input){
	    	
	    	doc.setContents("\\Subsection{}");
	    }
	

}
