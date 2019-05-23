package controller;
import model.*;
import view.*;



import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextArea;

public class SaveCommand implements Command{
    private JMenu j;
    public SaveCommand(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem save = new JMenuItem("Save");
        j.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                doc.setContents(input.getText());
                doc.save();   
            }
        });
    }
}