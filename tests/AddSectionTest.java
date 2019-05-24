package tests;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import controller.Command;

public class AddSectionTest implements Command {
	
	public AddSectionTest() {
		
	}
	
	public void execute(Document doc, JTextArea input){
		
		doc.setContents("\\section{}");
	}

}