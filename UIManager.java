import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JTextArea;


public class UIManager{
    private LatexEditorController controller;
    private Document doc;
    private VersionsManager vm;

    public void createFirstUI() {
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);

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
                createPopUp(0);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
            }
        });

        tmp2Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e2){
                createPopUp(1);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        });

        tmp3Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e3){
                createPopUp(2);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        });  

        tmp4Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e4){
                createPopUp(3);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));                
            }
        }); 

        tmp5Button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e5){
                createPopUp(4);
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
    public void createPopUp(int num){
        JFrame pop = new JFrame("Inputs");
        JPanel poppan = new JPanel(new GridBagLayout());
        JButton enter = new JButton("Enter");
        JTextField jt1 = new JTextField(30);
        JTextField jt2 = new JTextField(30);
        JTextField jt3 = new JTextField(30);
        JTextField jt4 = new JTextField(30);
        JLabel lab1 = new JLabel("author:");
        JLabel lab2 = new JLabel("date:");
        JLabel lab3 = new JLabel("copyright:");
        JLabel lab4 = new JLabel("versionID:");
        pop.setSize(1000,600);
        pop.setLocation(300,200);
        pop.setVisible(true);
        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 0;
        d.gridy = 1;
        poppan.add(lab1,d);
        d.gridx = 1;
        d.gridy = 1;
        poppan.add(jt1,d);
        d.gridx = 0;
        d.gridy = 2;
        poppan.add(lab2,d);
        d.gridx = 1;
        d.gridy = 2;
        poppan.add(jt2,d);
        d.gridx = 0;
        d.gridy = 3;
        poppan.add(lab3,d);
        d.gridx = 1;
        d.gridy = 3;
        poppan.add(jt3,d);
        d.gridx = 0;
        d.gridy = 4;
        poppan.add(lab4,d);
        d.gridx = 1;
        d.gridy = 4;
        poppan.add(jt4,d);
        d.gridx = 0;
        d.gridy = 5;
        /*poppan.add(lab5,d);
        d.gridx = 1;
        d.gridy = 5;
        poppan.add(jt5,d);
        d.gridx = 0;
        d.gridy = 6;*/
        pop.add(poppan);
        final JButton enterButton = new JButton("Enter Inputs");
        pop.getContentPane().add(BorderLayout.SOUTH, enterButton);

        enterButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String author= jt1.getText();
                String date= jt2.getText();
                String copyright= jt3.getText();
                String versionID= jt4.getText();
                System.out.println(author);
                if(num==0){
                    controller.reportTemplatePressed(author, date, copyright, versionID);
                    pop.dispatchEvent(new WindowEvent(pop, WindowEvent.WINDOW_CLOSING));
                }
                else if(num==1){
                    controller.bookTemplatePressed(author, date, copyright, versionID);
                    pop.dispatchEvent(new WindowEvent(pop, WindowEvent.WINDOW_CLOSING));
                }
                else if(num==2){
                    controller.articleTemplatePressed(author, date, copyright, versionID);
                    pop.dispatchEvent(new WindowEvent(pop, WindowEvent.WINDOW_CLOSING));
                }
                else if(num==3){
                    controller.letterTemplatePressed(author, date, copyright, versionID);
                    pop.dispatchEvent(new WindowEvent(pop, WindowEvent.WINDOW_CLOSING));
                }
                else{
                    controller.emptyTemplatePressed(author, date, copyright, versionID);
                    pop.dispatchEvent(new WindowEvent(pop, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }


    public void createSecondUI(Document d){
        VolatileVersionsStrategy vvs = new VolatileVersionsStrategy();
        VersionsManager verman = new VersionsManager(vvs);
        this.vm = verman;
        this.doc=d;
        this.vm.getStrategy().putVersion(d);
        JFrame f = new JFrame("LaTeX Template");
        f.setSize(1000, 600);
        f.setLocation(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea(200, 400);
        JScrollPane scroll = new JScrollPane(textArea);
        textArea.append(doc.getContents());
        textArea.getDocument().addDocumentListener(new MyDocumentListener(textArea, vm, doc));
       
        f.getContentPane().add(scroll);
        //f.getContentPane().add(BorderLayout.CENTER, textArea);

        textArea.setCaretPosition(textArea.getDocument().getLength());
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu vt = new JMenu("Version Tracking");
        mb.add(file);
        mb.add(vt);

        StableVersionStrategyCommand svsc = new StableVersionStrategyCommand(vt, vm);
        svsc.execute(doc, textArea);

        VolatileVersionStrategyCommand vvsc = new VolatileVersionStrategyCommand(vt, vm);
        vvsc.execute(doc, textArea);
        
        DisableStrategyCommand dsc = new DisableStrategyCommand(vt, vm);
        dsc.execute(doc, textArea);

        SaveCommand save = new SaveCommand(file);
        save.execute(doc, textArea);
        
        LoadCommand load = new LoadCommand(file);
        load.execute(doc, textArea);
        
        UndoCommand undo = new UndoCommand(file, vm);
        undo.execute(doc, textArea);

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
        
        
        f.setVisible(true);
        final JButton exitButton = new JButton("Click to exit");
        f.getContentPane().add(BorderLayout.SOUTH, exitButton);

        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StableVersionsStrategy svs = new StableVersionsStrategy();
                svs.setEntireHistory(vm.getStrategy().getEntireHistory());
                svs.clearAndGo();
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