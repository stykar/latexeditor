package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.Document;

public class AddFigure implements Command{
    private JMenu j;
    public AddFigure(JMenu j){
        this.j=j;
    }
    public void execute(Document d, JTextArea input){
        JMenuItem addFigure = new JMenuItem("Add Figure");
        j.add(addFigure);
        addFigure.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}", input.getCaretPosition());
            }
        });
    }
}