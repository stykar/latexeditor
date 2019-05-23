public class LatexEditorController{
    private Document doc;
    private UIManager ui;

    public void startControlling(UIManager userInterface){
        this.ui = userInterface;
        userInterface.createFirstUI();
    }
    public void createSecUI(Document doc){
        ui.createSecondUI(doc);
    }
    public void reportTemplatePressed(String authorst, String datest, String copyrightst, String versionIDst){
        DocumentManager dm = new DocumentManager();
        doc = dm.createDocument("Report");
        doc.setAuthor(authorst);
        doc.setDate(datest);
        doc.setCopyright(copyrightst);
        doc.setVersionID(versionIDst);
        createSecUI(doc);
    }
    public void bookTemplatePressed(String authorst, String datest, String copyrightst, String versionIDst){
        DocumentManager dm = new DocumentManager();
        doc = dm.createDocument("Book");
        doc.setAuthor(authorst);
        doc.setDate(datest);
        doc.setCopyright(copyrightst);
        doc.setVersionID(versionIDst);
        createSecUI(doc);
    }
    public void articleTemplatePressed(String authorst, String datest, String copyrightst, String versionIDst){
        DocumentManager dm = new DocumentManager();
        doc = dm.createDocument("Article");
        doc.setAuthor(authorst);
        doc.setDate(datest);
        doc.setCopyright(copyrightst);
        doc.setVersionID(versionIDst);
        createSecUI(doc);
    }

    public void letterTemplatePressed(String authorst, String datest, String copyrightst, String versionIDst){
        DocumentManager dm = new DocumentManager();
        doc = dm.createDocument("Letter");
        doc.setAuthor(authorst);
        doc.setDate(datest);
        doc.setCopyright(copyrightst);
        doc.setVersionID(versionIDst);
        createSecUI(doc);
    }

    public void emptyTemplatePressed(String authorst, String datest, String copyrightst, String versionIDst){
        DocumentManager dm = new DocumentManager();
        doc = dm.createDocument("Empty");
        doc.setAuthor(authorst);
        doc.setDate(datest);
        doc.setCopyright(copyrightst);
        doc.setVersionID(versionIDst);
        createSecUI(doc);
    }
}