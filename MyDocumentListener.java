import javax.swing.event.*;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class MyDocumentListener implements  DocumentListener{
    private String keimeno;
    private Document doc;
    private VersionsManager manager;
    private ArrayList<String> instances = new ArrayList<>();
    public MyDocumentListener(Document doc){
        this.keimeno = doc.getContents();
        this.doc = doc;
    }
    public void insertUpdate(DocumentEvent e){
        manager.getStrategy().putVersion(doc);
        System.out.println("mpike1");
        updateLog();
    }
    public void removeUpdate(DocumentEvent e){
        manager.getStrategy().putVersion(doc);
        System.out.println("mpike2");
        updateLog();
    }
    public void changedUpdate(DocumentEvent e){
        manager.getStrategy().putVersion(doc);
        System.out.println("mpike3");
        updateLog();
    }
    public void updateLog(){
        manager.getStrategy().putVersion(doc);
        System.out.println("mpike4");
        if(instances.size()==0){
            instances.add(keimeno);
            //counter++;
            //System.out.println(keimeno);
        }
        if(instances.get(instances.size()-1) != keimeno){
            instances.add(keimeno);
           //System.out.println(keimeno);
            //counter++;            
        }
    }
}