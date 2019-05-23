package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.*;
import view.*;
public class AddSubsection implements Command{
    private JMenu j;
    public AddSubsection(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addSubsection = new JMenuItem("Add Subsection");
        j.add(addSubsection);
        addSubsection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\Subsection{}", input.getCaretPosition());
            }
        });
    }
}