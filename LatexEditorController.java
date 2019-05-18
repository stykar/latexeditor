import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;

public class LatexEditorController{
    private UIManager ui;

    public void startControlling(UIManager userInterface){
        this.ui = userInterface;
        userInterface.createFirstUI();
    }
    public void createSecUI(Document doc){
        ui.createSecondUI(doc);
    }
    public void reportTemplatePressed(){
        DocumentManager dm = new DocumentManager();
        createSecUI(dm.createDocument("Report"));
    }
    public void bookTemplatePressed(){
        DocumentManager dm = new DocumentManager();
        createSecUI(dm.createDocument("Book"));
    }
    public void articleTemplatePressed(){
        DocumentManager dm = new DocumentManager();
        createSecUI(dm.createDocument("Article"));
    }

    public void letterTemplatePressed(){
        DocumentManager dm = new DocumentManager();
        createSecUI(dm.createDocument("Letter"));
    }

    public void emptyTemplatePressed(){
        DocumentManager dm = new DocumentManager();
        createSecUI(dm.createDocument("Empty"));
    }

    /*public void saveButtonPressed(JTextArea input){
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
            dest.write(input.getText());
            dest.close();
        }
        catch (FileNotFoundException err) {} 
        catch (IOException err) {} 
    }*/

    /*public void loadButtonPressed(JTextArea input){
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
        //loadedtmp.createTemplate();
    }*/

    public void chapterButtonPressed(JTextArea input){
        String checkTemplate = "{letter}";
        String checkTemplate2 = "{article}";
        if((ui.getLatexString().contains(checkTemplate)) 
            || (ui.getLatexString().contains(checkTemplate2))){
            JOptionPane.showMessageDialog(null,"Cant put Chapter in this Template");
        } else{
            input.insert("\\chapter{...}", input.getCaretPosition());
        }
    }

    public void sectionButtonPressed(JTextArea input){
        String checkTemplate = "{letter}";
        if(ui.getLatexString().contains(checkTemplate)){
            JOptionPane.showMessageDialog(null,"Cant put Section in this Template");
        } else{
            input.insert("\\section{}", input.getCaretPosition());
        }
    }

    public void subsectionButtonPressed(JTextArea input){
        input.insert("\\Subsection{}", input.getCaretPosition());
    }

    public void subsubsectionButtonPressed(JTextArea input){
        input.insert("\\Subsubsection{}", input.getCaretPosition());
    }

    public void itemizeButtonPressed(JTextArea input){
        input.insert("\\begin{itemize} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{itemize}", input.getCaretPosition());
    }

    public void enumerateButtonPressed(JTextArea input){
        input.insert("\\begin{enumerate} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{enumerate}", input.getCaretPosition());
    }

    public void tableButtonPressed(JTextArea input){
        input.insert("\\begin{table} \n"
                +"\\caption{....}\\label{...} \n"
                +"\\begin{tabular}{|c|c|c|} \n"
                +"  \\hline\n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"  \\hline \n"
                +"\\end{tabular}\n"
                +"\\end{table}", input.getCaretPosition());
    }

    public void figureButtonPressed(JTextArea input){
        input.insert("\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}", input.getCaretPosition());
    }


}