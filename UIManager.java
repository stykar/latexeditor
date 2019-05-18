import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.io.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.filechooser.*;
import javax.swing.event.DocumentListener;


public class UIManager{
    private LatexEditorController controller;
    private String latexString="";
    private Document doc;

    public void createFirstUI() {
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        JLabel lab = new JLabel("Choose Template:");



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
    public void createPopUp(){
        JFrame pop = new JFrame("Inputs");
        JButton enter = new JButton("Enter");
        JTextField jt1 = new JTextField(30);
        JTextField jt2 = new JTextField(30);
        JTextField jt3 = new JTextField(30);
        JTextField jt4 = new JTextField(30);
        JTextField jt5 = new JTextField(30);
        JLabel lab1 = new JLabel("author:");
        JLabel lab2 = new JLabel("date:");
        JLabel lab3 = new JLabel("copyright:");
        JLabel lab4 = new JLabel("versionID:");
        JLabel lab5 = new JLabel("content:");
        pop.setSize(1000,600);
        pop.setLocation(300,200);
        pop.setVisible(true);
        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 0;
        d.gridy = 1;
        pop.add(lab1);
        pop.add(jt1);
        d.gridx = 0;
        d.gridy = 2;
        pop.add(lab2);
        pop.add(jt2);
        d.gridx = 0;
        d.gridy = 3;
        pop.add(lab3);
        pop.add(jt3);
        d.gridx = 0;
        d.gridy = 4;
        pop.add(lab4);
        pop.add(jt4);
        d.gridx = 0;
        d.gridy = 5;
        pop.add(lab5);
        pop.add(jt5);
        d.gridx = 0;
        d.gridy = 6;
        pop.add(enter);

        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String author= jt1.getText();
                String date= jt2.getText();
                String copyright= jt3.getText();
                String versionID= jt4.getText();
                String content= jt5.getText();
            }
        });


        

    }











    public void createSecondUI(Document doc){
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea(200, 400);
        textArea.getDocument().addDocumentListener(new MyDocumentListener(textArea));
       
    
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        textArea.append(doc.getContents());
        textArea.setCaretPosition(textArea.getDocument().getLength());
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);



        SaveCommand save = new SaveCommand(file);
        save.execute(doc, textArea);
        
        
        LoadCommand load = new LoadCommand(file);
        load.execute(doc, textArea);
        
        JMenuItem undo = new JMenuItem("Undo");
        file.add(undo);

        JMenu addCommand = new JMenu("Add Command");
        mb.add(addCommand);

        AddChapter addChapter = new AddChapter(addCommand);
        addChapter.execute(doc, textArea);
        

        

        AddSection addSection = new AddSection(addCommand);
        addSection.execute(doc,textArea);
    

        AddSubsection addSubsection = new AddSubsection(addCommand);
        addSubsection.execute(doc, textArea);

        AddSubSubSection addSubsubsection = new AddSubSubSection(addCommand);
        addSubsubsection.execute(doc, textArea);
    

        
        AddEnumerationListItemize addEnumerationListItemize = new AddEnumerationListItemize(addCommand);
        addEnumerationListItemize.execute(doc, textArea);

        AddEnumerationListEnumerate addEnumerationListEnumerate = new AddEnumerationListEnumerate(addCommand);
        addEnumerationListEnumerate.execute(doc, textArea);
        
        AddTable addTable = new AddTable(addCommand);
        addTable.execute(doc, textArea);

        AddFigure addFigure = new AddFigure(addCommand);
        addFigure.execute(doc, textArea);

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

    public UIManager(LatexEditorController c){
        this.controller=c;
    }
}