import java.io.*;
import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;

public class Document{
    private String author;
    private String date;
    private String copyright;
    private int versionID;
    private String content;

    public Document(String author,String date, String copyright, int versionID, String content){
        this.author=author;
        this.date=date;
        this.copyright=copyright;
        this.versionID=versionID;
        this.content=content;
    }

    /*public Document clone(){
        Document clone = new Document(author, date, copyright, versionID+1, content);
        return clone;
    }*/
    
    public void save(){
        String filepath="";
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            File selectedFile = jfc.getSelectedFile();
            filepath = selectedFile.getAbsolutePath();
        }
        try {
            FileWriter dest;
            dest = new FileWriter(filepath+".tex");
            dest.write(content);
            dest.close();
        }
        catch (FileNotFoundException err) {} 
        catch (IOException err) {} 
    }
    
    public void setContents(String s){
        this.content=s;
    }

    public String getContents(){
        return content;
    }
}