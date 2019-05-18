import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;

import javax.swing.event.DocumentListener;

public interface Command{
    public void execute(Document d, JTextArea jta);
}

class SaveCommand implements Command{
    private JMenu j;
    public SaveCommand(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem save = new JMenuItem("Save");
        j.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                doc.setContents(input.getText());
                doc.save();   
            }
        });
    }
}

class LoadCommand implements Command{
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

class AddChapter implements Command{
    private JMenu j;
    public AddChapter(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addChapter = new JMenuItem("Add Chapter");
        j.add(addChapter);
        addChapter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String checkTemplate = "{letter}";
                String checkTemplate2 = "{article}";
                if((doc.getContents().contains(checkTemplate)) 
                    || (doc.getContents().contains(checkTemplate2))){
                    JOptionPane.showMessageDialog(null,"Cant put Chapter in this Template");
                } else{
                    input.insert("\\chapter{...}", input.getCaretPosition());
                }
            }
        });
        
    }
}
class AddSection implements Command{
    private JMenu j;
    public AddSection(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addSection = new JMenuItem("Add Section");
        j.add(addSection);
        addSection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String checkTemplate = "{letter}";
                if(doc.getContents().contains(checkTemplate)){
                    JOptionPane.showMessageDialog(null,"Cant put Section in this Template");
                } else{
                    input.insert("\\section{}", input.getCaretPosition());
                }
            }
        }); 
    }
}

class AddSubsection implements Command{
    private JMenu j;
    public AddSubsection(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addSubsection = new JMenuItem("Add Subsection");
        j.add(addSubsection);
        addSubsection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\Subsection{}", input.getCaretPosition());
            }
        });
    }
}

class AddSubSubSection implements Command{
    private JMenu j;
    public AddSubSubSection(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addSubSubSection = new JMenuItem("Add Subsubsection");
        j.add(addSubSubSection);
        addSubSubSection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\Subsubsection{}", input.getCaretPosition());
            }
        });
    }
}

class AddEnumerationListItemize implements Command{
    private JMenu j;
    public AddEnumerationListItemize(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input){
        JMenuItem addEnumerationListItemize = new JMenuItem("Add Enumeration List(itemize)");
        j.add(addEnumerationListItemize);
        addEnumerationListItemize.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{itemize} \n"
                                +" \\item ... \n \\item ... "
                                +"\n \\end{itemize}", input.getCaretPosition());
            }
        });
    }     
}

class AddEnumerationListEnumerate implements Command{
    private JMenu j;
    public AddEnumerationListEnumerate(JMenu j){
        this.j=j;
    }
    public void execute(Document doc, JTextArea input) {
        JMenuItem addEnumerationListEnumerate = new JMenuItem("Add Enumeration List(enumerate)");
        j.add(addEnumerationListEnumerate);
        addEnumerationListEnumerate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{enumerate} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{enumerate}", input.getCaretPosition());
            }
        });
    }
}

class AddTable implements Command{
    private JMenu j;
    public AddTable(JMenu j){
        this.j=j;
    }
    public void execute(Document d, JTextArea input){
        JMenuItem addTable = new JMenuItem("Add Table");
        j.add(addTable);
        addTable.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
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
        });
    }
}

class AddFigure implements Command{
    private JMenu j;
    public AddFigure(JMenu j){
        this.j=j;
    }
    public void execute(Document d, JTextArea input){
        JMenuItem addFigure = new JMenuItem("Add Figure");
        j.add(addFigure);
        addFigure.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                input.insert("\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}", input.getCaretPosition());
            }
        });
    }
}
