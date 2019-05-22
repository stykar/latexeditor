import javax.swing.JTextArea;

public class VersionsManager{

    private boolean enabled;
    private VersionsStrategy vs;

    public VersionsManager(VersionsStrategy verstr){
        this.vs = verstr;
        this.enabled = true;
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
        vs.removeVersion();
        input.setText(vs.getVersion().getContents());
    }
}