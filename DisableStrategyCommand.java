package controller;
import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.Document;
import model.VersionsManager;

public class DisableStrategyCommand implements Command{
    private JMenu j;
    private VersionsManager vm;
    public DisableStrategyCommand(JMenu j, VersionsManager verMan){
        this.j=j;
        this.vm=verMan;
    }

    public void execute(Document d, JTextArea input){
        JMenuItem dsCommand = new JMenuItem("Disable");
        j.add(dsCommand);
        dsCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vm.disable();
            }
        });
    }
}