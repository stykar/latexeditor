import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;

public class MyDocumentListener implements  DocumentListener{
    public void insertUpdate(DocumentEvent e){
        updateLog();
    }
    public void removeUpdate(DocumentEvent e){
        updateLog();
    }
    public void changedUpdate(DocumentEvent e){
        updateLog();
    }
    public void updateLog(){
        //System.out.println("Doulevei");
    }
}