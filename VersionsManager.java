package model;
import controller.*;
import view.*;
import javax.swing.JTextArea;

import java.util.ArrayList;

public class VersionsManager{

    private boolean enabled;
    private VersionsStrategy vs;
    private ArrayList<Document> docList = new ArrayList<>();
    private boolean isUndo;

    public VersionsManager(VersionsStrategy verstr){
        this.vs = verstr;
        this.enabled = true;
        this.isUndo = false;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public void enable(){
        this.enabled = true;
    }

    public void disable(){
        this.enabled = false;
    }

    public void setStrategy(VersionsStrategy verstr){
        this.vs = verstr;
    }

    public VersionsStrategy getStrategy(){
        return vs;
    }

    public void setCurrentVersion(Document doc){
        vs.putVersion(doc);
    }

    public Document getPreviousVersion(){
        return vs.getVersion();
    }

    public void rollbackToPreviousVersion(JTextArea input){
        this.isUndo = true;
        vs.removeVersion();
        input.setText(vs.getVersion().getContents());
    }

    public boolean getIsUndo(){
        return this.isUndo;
    }

    public void setIsUndo(boolean b){
        this.isUndo = b;
    }
}