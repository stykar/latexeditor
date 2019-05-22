import javax.swing.event.*;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class MyDocumentListener implements  DocumentListener{
    private String allText;
    private VersionsManager vm;
    private Document doc;
    private JTextArea area;
    public MyDocumentListener(JTextArea text, VersionsManager verman, Document d){
        this.area = text;
        this.allText = text.getText();
        this.vm = verman;
        this.doc=d;
    }
    public void insertUpdate(DocumentEvent e){
        //manager.getStrategy().putVersion(doc);
        System.out.println("insert");
        updateLog();
    }
    public void removeUpdate(DocumentEvent e){
        //manager.getStrategy().putVersion(doc);
        System.out.println("remove");
        updateLog();
    }
    public void changedUpdate(DocumentEvent e){
        //manager.getStrategy().putVersion(doc);
        System.out.println("changed");
        updateLog();
    }
    public void updateLog(){
        if(vm.isEnabled()){
            if(!allText.equals(area.getText())){
                this.allText = area.getText();
                Document d = new Document(doc.getAuthor(), doc.getDate(), 
                        doc.getCopyright(), doc.getVersionID(), allText);
                vm.getStrategy().putVersion(d);
                System.out.println("update");
            }
        }
    }
}