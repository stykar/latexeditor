package controller;
import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.Document;

public class AddSubSubSection implements Command{
    private JMenu j;
    public AddSubSubSection(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addSubSubSection = new JMenuItem("Add Subsubsection");
        j.add(addSubSubSection);
        addSubSubSection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\Subsubsection{}", input.getCaretPosition());
            }
        });
    }
}