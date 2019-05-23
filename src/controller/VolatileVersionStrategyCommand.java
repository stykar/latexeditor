package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import model.*;
import view.*;
public class VolatileVersionStrategyCommand implements Command{
    private JMenu j;
    private VersionsManager vm;
    public VolatileVersionStrategyCommand(JMenu j, VersionsManager verMan){
        this.j=j;
        this.vm=verMan;
    }

    public void execute(Document d, JTextArea input){
        JMenuItem vvsCommand = new JMenuItem("Volatile");
        j.add(vvsCommand);
        vvsCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VolatileVersionsStrategy vvs = new VolatileVersionsStrategy();
                vvs.setEntireHistory(vm.getStrategy().getEntireHistory());
                vm.setStrategy(vvs);
                vm.enable();
            }
        });
    }
}