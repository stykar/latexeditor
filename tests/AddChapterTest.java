package tests;


import static org.junit.Assert.fail;



import javax.swing.JTextArea;

import controller.Command;
import model.Document;

public class AddChapterTest implements Command{
    
    public AddChapterTest(){
    	
    }
    
    public void execute(Document doc, JTextArea j){
        
                String checkTemplate = "{letter}";
                String checkTemplate2 = "{article}";
                if((doc.getContents().contains(checkTemplate)) 
                    || (doc.getContents().contains(checkTemplate2))){
                    fail("Cant put Chapter in this Template");
                } else{
                	
                    doc.setContents("\\chapter{...}");
                }
            
       
        
    }
}