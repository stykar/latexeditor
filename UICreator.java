import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class UICreator{

  public static void createUI() {

    JFrame f = new JFrame("LaTeX Template");
    f.setSize(800, 600);
    f.setLocation(300,200);
    final JTextArea textArea = new JTextArea(20, 40);
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    textArea.append("Please give a number to create a specific LaTeX document \n"
        +"If any other input is given then an empty document will be created\n"
        +"- 1 for a report template\n- 2 for a book template\n"
        +"- 3 for an article template\n- 4 for a letter template\nInput:");
    textArea.setCaretPosition(textArea.getDocument().getLength());
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