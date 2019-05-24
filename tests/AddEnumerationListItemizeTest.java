package tests;
import model.*;


import javax.swing.JTextArea;

import controller.Command;

public class AddEnumerationListItemizeTest implements Command {
	
	public AddEnumerationListItemizeTest() {
	}

	public void execute(Document doc, JTextArea input) {
		
		doc.setContents("\\begin{itemize} \n"
                +" \\item ... \n \\item ... "
                +"\n \\end{itemize}");
	}
}
