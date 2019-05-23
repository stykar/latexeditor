import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Document{
    private String author;
    private String date;
    private String copyright;
    private String versionID;
    private String content;

    public Document(String author,String date, String copyright, String versionID, String content){
        this.author=author;
        this.date=date;
        this.copyright=copyright;
        this.versionID=versionID;
        this.content=content;
    }
    // TODO
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

    public void setAuthor(String s){
        this.author=s;
    }
    public String getAuthor(){
        return author;
    }

    public void setDate(String s){
        this.date=s;
    }
    public String getDate(){
        return date;
    }

    public void setCopyright(String s){
        this.copyright=s;
    }
    public String getCopyright(){
        return copyright;
    }

    public void setVersionID(String s){
        this.versionID=s;
    }
    public String getVersionID(){
        return versionID;
    }

    public void setContents(String s){
        this.content=s;
    }
    public String getContents(){
        return content;
    }
}