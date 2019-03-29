import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Dimension;
//import java.awt.Container;

import javax.swing.*;
//import javax.swing.JFrame;
import javax.swing.JTextArea;


public class UICreator{

  public static void createUI() {

    JFrame f = new JFrame("LaTeX Template");
    f.setSize(1000, 600);
    f.setLocation(300,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File");
    mb.add(file);
    JMenuItem save = new JMenuItem("Save");
    file.add(save);
    JMenuItem restore = new JMenuItem("Restore");
    file.add(restore);
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
    f.setJMenuBar(mb);
    f.add(p);

    tmp1Button.addActionListener(new ActionListener(){

    	public void actionPerformed(ActionEvent e1){
    		ReportTemplate template = new ReportTemplate();
            template.createTemplate();
            JOptionPane.showMessageDialog(null,"Created Report Template");
    	}

    });

    tmp2Button.addActionListener(new ActionListener(){

    	public void actionPerformed(ActionEvent e2){
    		BookTemplate template = new BookTemplate();
            template.createTemplate();
            JOptionPane.showMessageDialog(null,"Created Book Template");
    	}

    });

    tmp3Button.addActionListener(new ActionListener(){

    	public void actionPerformed(ActionEvent e3){
    		ArticleTemplate template = new ArticleTemplate();
            template.createTemplate();
            JOptionPane.showMessageDialog(null,"Created Article Template");
    	}

    });  

    tmp4Button.addActionListener(new ActionListener(){

    	public void actionPerformed(ActionEvent e4){
    		LetterTemplate template = new LetterTemplate();
            template.createTemplate();
            JOptionPane.showMessageDialog(null,"Created Letter Template");
    	}

    }); 

    tmp5Button.addActionListener(new ActionListener(){

    	public void actionPerformed(ActionEvent e5){
    		EmptyTemplate template = new EmptyTemplate();
            template.createTemplate();
            JOptionPane.showMessageDialog(null,"Created Empty Template");
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
}