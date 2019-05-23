package controller;
import model.*;
import view.*;


import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;
public class UndoCommand implements Command{
    private JMenu j;
    private VersionsManager vm;
    public UndoCommand(JMenu j, VersionsManager verMan){
        this.j=j;
        this.vm=verMan;
    }
    public void execute(Document d, JTextArea input){
        JMenuItem undoCommand = new JMenuItem("Undo");
        j.add(undoCommand);
        undoCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vm.rollbackToPreviousVersion(input);
            }
        });
    }
}