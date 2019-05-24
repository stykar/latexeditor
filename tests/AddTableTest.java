package tests;
import model.*;


import javax.swing.JTextArea;

import controller.Command;

public class AddTableTest implements Command {
	
	    
	    public AddTableTest(){
	        
	    }
	    
	    public void execute(Document doc, JTextArea input){
	    	
	    	doc.setContents("\\begin{table} \n"
	                +"\\caption{....}\\label{...} \n"
	                +"\\begin{tabular}{|c|c|c|} \n"
	                +"  \\hline\n"
	                +"... &...&...\\ \n"
	                +"... &...&...\\ \n"
	                +"... &...&...\\ \n"
	                +"  \\hline \n"
	                +"\\end{tabular}\n"
	                +"\\end{table}");
	    }
	

}
