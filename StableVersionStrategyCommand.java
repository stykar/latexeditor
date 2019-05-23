package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.Document;
import model.StableVersionsStrategy;
import model.VersionsManager;

public class StableVersionStrategyCommand implements Command{
    private JMenu j;
    private VersionsManager vm;
    public StableVersionStrategyCommand(JMenu j, VersionsManager verMan){
        this.j=j;
        this.vm=verMan;
    }

    public void execute(Document d, JTextArea input){
        JMenuItem svsCommand = new JMenuItem("Stable");
        j.add(svsCommand);
        svsCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                StableVersionsStrategy svs = new StableVersionsStrategy();
                svs.setEntireHistory(vm.getStrategy().getEntireHistory());
                vm.setStrategy(svs);
                vm.enable();
            }
        });
    }
}