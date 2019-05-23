package model;
import controller.*;
import view.*;
import java.util.ArrayList;
import java.util.List;

public class VolatileVersionsStrategy implements VersionsStrategy {
    private List<Document> dList;

    public VolatileVersionsStrategy() {
        this.dList = new ArrayList<Document>();
    }

    public void putVersion(Document doc) {
        this.dList.add(doc);
    }

    public Document getVersion() {
        return this.dList.get(this.dList.size()-1);
    }

    public void setEntireHistory(List<Document> docList) {
        this.dList = docList;
    }

    public List<Document> getEntireHistory() {
        return this.dList;
    }

    public void removeVersion() {
        if(this.dList.size() > 1){
            this.dList.remove(this.dList.size()-1);
        }
    }
}