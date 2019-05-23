package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.*;
import view.*;
public class AddTable implements Command{
    private JMenu j;
    public AddTable(JMenu j){
        this.j=j;
    }
    public void execute(Document d, JTextArea input){
        JMenuItem addTable = new JMenuItem("Add Table");
        j.add(addTable);
        addTable.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{table} \n"
                +"\\caption{....}\\label{...} \n"
                +"\\begin{tabular}{|c|c|c|} \n"
                +"  \\hline\n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"  \\hline \n"
                +"\\end{tabular}\n"
                +"\\end{table}", input.getCaretPosition());
            }
        });
    }
}