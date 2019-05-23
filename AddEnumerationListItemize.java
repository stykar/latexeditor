package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.*;
import view.*;
public class AddEnumerationListItemize implements Command{
    private JMenu j;
    public AddEnumerationListItemize(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addEnumerationListItemize = new JMenuItem("Add Enumeration List(itemize)");
        j.add(addEnumerationListItemize);
        addEnumerationListItemize.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{itemize} \n"
                                +" \\item ... \n \\item ... "
                                +"\n \\end{itemize}", input.getCaretPosition());
            }
        });
    }     
}