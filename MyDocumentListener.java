import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;

public class MyDocumentListener implements  DocumentListener{
    private String keimeno;
    private ArrayList<String> instances = new ArrayList<>();
    //private int counter = 0;
    public MyDocumentListener(JTextArea str){
        this.keimeno=str.getText();
    }
    public void insertUpdate(DocumentEvent e){
        System.out.println("mpike1");
        updateLog();
    }
    public void removeUpdate(DocumentEvent e){
        System.out.println("mpike2");
        updateLog();
    }
    public void changedUpdate(DocumentEvent e){
        System.out.println("mpike3");
        updateLog();
    }
    public void updateLog(){
        System.out.println("mpike4");
        if(instances.size()==0){
            instances.add(keimeno);
            //counter++;
            //System.out.println(keimeno);
        }
        if(instances.get(instances.size()-1) != keimeno){
            instances.add(keimeno);
           //System.out.println(keimeno);
            //counter++;            
        }
    }
}