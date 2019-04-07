import java.awt.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;


public class UIManager{

    private Controller controller;
    private String latexString="";

    public void createFirstUI() {
        System.out.println("hi");
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        JLabel lab = new JLabel("Choose Template:");

        /* final JTextArea textArea = new JTextArea(200, 400);
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        textArea.append("Please give a number to create a specific LaTeX document \n"
            +"If any other input is given then an empty document will be created\n"
            +"- 1 for a report template\n- 2 for a book template\n"
            +"- 3 for an article template\n- 4 for a letter template\nInput:");
        textArea.setCaretPosition(textArea.getDocument().getLength());*/

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
                controller.reportTemplatePressed();
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
            }
        });

        tmp2Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e2){
                controller.bookTemplatePressed();
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));              
            }
        });

        tmp3Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3){
                controller.articleTemplatePressed();
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        });  

        tmp4Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e4){
                controller.letterTemplatePressed();
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));              
            }
        }); 

        tmp5Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e5){
                controller.emptyTemplatePressed();
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
        
       /* public void insertUpdate(javax.swing.event.DocumentEvent e){

        }
        public void removeUpdate(javax.swing.event.DocumentEvent e){

        }*/
        /*textArea.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"Cant put Section in this Template");
            }
        });*/
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        textArea.append(latexString);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    String filepath = getTextInput();
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
            public void actionPerformed(ActionEvent e){
                LoadTemplate loadedtmp = new LoadTemplate();
                //TO DO pop-up me entry file path
                String filepath = getTextInput();
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

    
    //constructors,mutators
    public void setLatexString(String toString){
        latexString=toString;
    }

    public String getLatexString(){
        return latexString;
    }

    public UIManager(Controller c){
        this.controller=c;
    }
}