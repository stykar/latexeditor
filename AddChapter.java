package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Document;

public class AddChapter implements Command{
    private JMenu j;
    public AddChapter(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addChapter = new JMenuItem("Add Chapter");
        j.add(addChapter);
        addChapter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String checkTemplate = "{letter}";
                String checkTemplate2 = "{article}";
                if((doc.getContents().contains(checkTemplate)) 
                    || (doc.getContents().contains(checkTemplate2))){
                    JOptionPane.showMessageDialog(null,"Cant put Chapter in this Template");
                } else{
                    input.insert("\\chapter{...}", input.getCaretPosition());
                }
            }
        });
        
    }
}