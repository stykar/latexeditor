package tests;
import model.*;


import javax.swing.JTextArea;

import controller.Command;

public class AddEnumerationListEnumerateTest implements Command {
	
	public AddEnumerationListEnumerateTest() {
		
	}
	
	public void execute(Document doc, JTextArea input) {
		
		doc.setContents("\\begin{enumerate} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{enumerate}");
	}

}
