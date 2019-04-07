import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;
import javax.swing.event.DocumentListener;


public class UIManager{

    public static void createFirstUI() {
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        JLabel lab = new JLabel("Choose Template:");
        String latexString="";



        JButton tmp1Button = new JButton("Report Template");
        JButton tmp2Button = new JButton("Book Template");
        JButton tmp3Button = new JButton("Article Template");
        JButton tmp4Button = new JButton("Letter Template"); 
        JButton tmp5Button = new JButton("Empty Document");             
        GridBagConstraints c= new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        p.add(lab);
        p.add(tmp1Button,c);
        p.add(tmp2Button,c);
        p.add(tmp3Button,c);
        p.add(tmp4Button,c);
        p.add(tmp5Button,c);
        f.add(p);

        tmp1Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e1) {
                String latexString;
                ReportTemplate template = new ReportTemplate();
                latexString = template.createTemplate();
                UIManager ui2 = new UIManager();
                ui2.createSecondUI(latexString);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
            }
        });

        tmp2Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e2){
                String latexString;
                BookTemplate template = new BookTemplate();
                latexString = template.createTemplate();
                //JOptionPane.showMessageDialog(null,"Created Book Template");
                UIManager ui2 = new UIManager();
                ui2.createSecondUI(latexString);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        });

        tmp3Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3){
                String latexString;
                ArticleTemplate template = new ArticleTemplate();
                latexString = template.createTemplate();
                //JOptionPane.showMessageDialog(null,"Created Article Template");
                UIManager ui2 = new UIManager();
                ui2.createSecondUI(latexString);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        });  

        tmp4Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e4){
                String latexString;
                LetterTemplate template = new LetterTemplate();
                latexString = template.createTemplate();
                //JOptionPane.showMessageDialog(null,"Created Letter Template");
                UIManager ui2 = new UIManager();
                ui2.createSecondUI(latexString);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        }); 

        tmp5Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e5){
                String latexString;
                EmptyTemplate template = new EmptyTemplate();
                latexString = template.createTemplate();
                //JOptionPane.showMessageDialog(null,"Created Empty Template");
                UIManager ui2 = new UIManager();
                ui2.createSecondUI(latexString);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        });         

        final JButton exitButton = new JButton("Click to exit");
        f.getContentPane().add(BorderLayout.SOUTH, exitButton);

        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        f.setVisible(true);
    }

    public void createSecondUI(String latexString){
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea(200, 400);
        textArea.getDocument().addDocumentListener(new MyDocumentListener(textArea));
       
    
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        textArea.append(latexString);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(new ActionListener(){
            String filepath;
            public void actionPerformed(ActionEvent e){
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int returnValue = jfc.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION){
                    File selectedFile = jfc.getSelectedFile();
                    filepath = selectedFile.getAbsolutePath();
                }
                try {

                    FileWriter dest;
                    dest = new FileWriter(filepath+".tex");
                    dest.write(textArea.getText());
                    dest.close();
                    } catch (FileNotFoundException err) {
            
                    } catch (IOException err) {
            
                    }                
            }
        });
        JMenuItem load = new JMenuItem("Load");
        file.add(load);
        load.addActionListener(new ActionListener(){
            String filepath;
            public void actionPerformed(ActionEvent e){

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
                textArea.setText("");
                textArea.append(fileData);
                //loadedtmp.createTemplate();
            }
        });
        
        JMenuItem undo = new JMenuItem("Undo");
        file.add(undo);

        JMenu addCommand = new JMenu("Add Command");
        mb.add(addCommand);
        JMenuItem addChapter = new JMenuItem("Add Chapter");
        addCommand.add(addChapter);
        addChapter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String checkTemplate = "{letter}";
                String checkTemplate2 = "{article}";
                if(latexString.contains(checkTemplate) || latexString.contains(checkTemplate2)){
                    JOptionPane.showMessageDialog(null,"Cant put Chapter in this Template");
                } else{
                    textArea.insert("\\chapter{...}", textArea.getCaretPosition());
                }
            }
        });

        JMenuItem addSection = new JMenuItem("Add Section");
        addCommand.add(addSection);
        addSection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String checkTemplate = "{letter}";
                if(latexString.contains(checkTemplate)){
                    JOptionPane.showMessageDialog(null,"Cant put Section in this Template");
                } else{
                    textArea.insert("\\section{}", textArea.getCaretPosition());
                }
            }
        });

        JMenuItem addSubsection = new JMenuItem("Add Subsection");
        addCommand.add(addSubsection);
        addSubsection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.insert("\\Subsection{}", textArea.getCaretPosition());
            }
        });

        JMenuItem addSubsubsection = new JMenuItem("Add Subsubsection");
        addCommand.add(addSubsubsection);
        addSubsubsection.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.insert("\\Subsubsection{}", textArea.getCaretPosition());
            }
        });

        JMenuItem addEnumerationListItemize = new JMenuItem("Add Enumeration List(itemize)");
        addCommand.add(addEnumerationListItemize);
        addEnumerationListItemize.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.insert("\\begin{itemize} \n"
                                +" \\item ... \n \\item ... "
                                +"\n \\end{itemize}", textArea.getCaretPosition());
            }
        });
        JMenuItem addEnumerationListEnumerate = new JMenuItem("Add Enumeration List(enumerate)");
        addCommand.add(addEnumerationListEnumerate);
        addEnumerationListEnumerate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.insert("\\begin{enumerate} \n"
                                +" \\item ... \n \\item ... "
                                +"\n \\end{enumerate}", textArea.getCaretPosition());
            }
        });
        JMenuItem addTable = new JMenuItem("Add Table");
        addCommand.add(addTable);
        addTable.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.insert("\\begin{table} \n"
                +"\\caption{....}\\label{...} \n"
                +"\\begin{tabular}{|c|c|c|} \n"
                +"  \\hline\n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"  \\hline \n"
                +"\\end{tabular}\n"
                +"\\end{table}", textArea.getCaretPosition());
            }
        });
        JMenuItem addFigure = new JMenuItem("Add Figure");
        addCommand.add(addFigure);
        addFigure.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.insert("\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}", textArea.getCaretPosition());
            }
        });
        f.setJMenuBar(mb);
        
        
        addCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        
        
        f.setVisible(true);
        final JButton exitButton = new JButton("Click to exit");
        f.getContentPane().add(BorderLayout.SOUTH, exitButton);

        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });        
    }

    public String getTextInput(){
        String arxeio;
        arxeio = JOptionPane.showInputDialog("give file path and/or name");
        String filepath = arxeio;
        return filepath;
    }
}