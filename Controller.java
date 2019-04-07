import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;

public class Controller{
    private UIManager ui;

    public void startControlling(){
        UIManager userInterface = new UIManager();
        userInterface.createFirstUI();
    }

}