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

public class AddSection implements Command{
    private JMenu j;
    public AddSection(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addSection = new JMenuItem("Add Section");
        j.add(addSection);
        addSection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String checkTemplate = "{letter}";
                if(doc.getContents().contains(checkTemplate)){
                    JOptionPane.showMessageDialog(null,"Cant put Section in this Template");
                } else{
                    input.insert("\\section{}", input.getCaretPosition());
                }
            }
        }); 
    }
}