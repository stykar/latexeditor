import javax.swing.event.*;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class MyDocumentListener implements  DocumentListener{
    private String allText;
    private Document doc;
    private JTextArea area;
    private ArrayList<String> instances = new ArrayList<>();
    public MyDocumentListener(JTextArea text, Document d){
        this.area = text;
        this.allText = text.getText();
        this.doc = d;
    }
    public void insertUpdate(DocumentEvent e){
        //manager.getStrategy().putVersion(doc);
        System.out.println("mpike1");
        updateLog();
    }
    public void removeUpdate(DocumentEvent e){
        //manager.getStrategy().putVersion(doc);
        System.out.println("mpike2");
        updateLog();
    }
    public void changedUpdate(DocumentEvent e){
        //manager.getStrategy().putVersion(doc);
        System.out.println("mpike3");
        updateLog();
    }
    public void updateLog(){
        this.allText = area.getText();
        doc.getVersionsManager().getStrategy().putVersion(doc);
        System.out.println("mpike4");
        if(instances.size()==0){
            instances.add(allText);
            //counter++;
            //System.out.println(allText);
        }
        if(instances.get(instances.size()-1) != allText){
            instances.add(allText);
           //System.out.println(allText);
            //counter++;            
        }
    }
}