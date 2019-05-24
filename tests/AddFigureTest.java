package tests;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import controller.Command;

public class AddFigureTest implements Command {
	
	public AddFigureTest() {
		
	}
	
	public void execute(Document doc, JTextArea input){
		
		doc.setContents("\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}");
	}

}
