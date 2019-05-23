package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import model.Document;

public class LoadCommand implements Command{
    private JMenu j;
    public LoadCommand(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem load = new JMenuItem("Load");
        j.add(load);
        load.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String filepath="";
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setDialogTitle("Select a LaTeX File");
                jfc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("LaTeX Files", "tex");
                jfc.addChoosableFileFilter(filter);
                int returnValue = jfc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION){
                    File selectedFile = jfc.getSelectedFile();
                    filepath = selectedFile.getAbsolutePath();
                }

                BufferedReader src;
                String fileData="";
                String line="";
                try {
                    src = new BufferedReader(new FileReader(filepath));
                    line=src.readLine();
                    while (line != null) {
                        fileData+=line+"\n";
                        line=src.readLine();
                    }
                    src.close();
                } catch (FileNotFoundException err) {

                } catch (IOException err) {

                }
                input.setText("");
                input.append(fileData);
            }
        });
    }
}