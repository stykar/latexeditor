import java.awt.*;
import java.io.*;
import java.awt.event.*;
//import java.awt.Dimension;
//import java.awt.Container;

import javax.swing.*;
//import javax.swing.JFrame;
import javax.swing.JTextArea;


public class UICreator{

    public static void createFirstUI() {
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        JLabel lab = new JLabel("Choose Template:");
        String latexString="";

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
                String latexString;
                ReportTemplate template = new ReportTemplate();
                latexString = template.createTemplate();
                //JOptionPane.showMessageDialog(null,"Created Report Template");
                UICreator ui2 = new UICreator();
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
                UICreator ui2 = new UICreator();
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
                UICreator ui2 = new UICreator();
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
                UICreator ui2 = new UICreator();
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
                UICreator ui2 = new UICreator();
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
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenuItem save = new JMenuItem("Save");
        

        
        /*
        try {
            File dest = new FileWriter("template.tex");
            dest.write(textArea.getText());
            dest.close();
            } catch (FileNotFoundException e) {
    
            } catch (IOException e) {
    
            }
        */
        file.add(save);
        JMenuItem load = new JMenuItem("Load");
        file.add(load);
        
        JMenuItem undo = new JMenuItem("Undo");
        file.add(undo);
         //!!!!!!!!!!!!!!!!US_3!!!!!!!!!!!!!!!!!!!!!
        JMenu addCommand = new JMenu("Add Command");
        mb.add(addCommand);
        JMenuItem addChapter = new JMenuItem("Add Chapter");
        addCommand.add(addChapter);
        JMenuItem addSubsection = new JMenuItem("Add Subsection");
        addCommand.add(addSubsection);
        JMenuItem addSubsubsection = new JMenuItem("Add subsubsection");
        addCommand.add(addSubsubsection);
        JMenuItem addEnumerationList = new JMenuItem("Add enumeration list");
        addCommand.add(addEnumerationList);
        JMenuItem addTable = new JMenuItem("Add a table");
        addCommand.add(addTable);

        f.setJMenuBar(mb);
        final JTextArea textArea = new JTextArea(200, 400);
        f.getContentPane().add(BorderLayout.CENTER, textArea);
        textArea.append(latexString);
        textArea.setCaretPosition(textArea.getDocument().getLength());
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
        
        //!!!!!!!!!!!!!!!!!!!!!!!!!US_3!!!!!!!!!!!!!!!!!!!!!!
        addCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        
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
                        System.out.println(line);
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
        /*BufferedReader src;
        String fileData="";
        String line="";
        try {
            src = new BufferedReader(filepath);
            line=src.readLine();
            while (line != null) {
                fileData+=line+"\n";
                line=src.readLine();
            }
            src.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }*/
        return filepath;








        /*final String newline = "\n";
        JFrame frame = new JFrame("TextDemo");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(20);
 
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
 
        String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();
        textField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                textArea.append(text + newline);
                textField.selectAll();
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

        });
        frame.add(textArea, textField);
        frame.pack();
        frame.setVisible(true);

        textArea.setCaretPosition(textArea.getDocument().getLength());

        return newline;*/
    }
}