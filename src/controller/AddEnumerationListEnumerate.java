package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.Document;

public class AddEnumerationListEnumerate implements Command{
    private JMenu j;
    public AddEnumerationListEnumerate(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input) {
        JMenuItem addEnumerationListEnumerate = new JMenuItem("Add Enumeration List(enumerate)");
        j.add(addEnumerationListEnumerate);
        addEnumerationListEnumerate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{enumerate} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{enumerate}", input.getCaretPosition());
            }
        });
    }
}