package model;
import controller.*;
import view.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public interface VersionsStrategy {
    public void putVersion(Document d);

    public Document getVersion();

    public void setEntireHistory(List<Document> dList);

    public List<Document> getEntireHistory();

    public void removeVersion();
}

/*class VolatileVersionsStrategy implements VersionsStrategy {
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
}*/

/*class StableVersionsStrategy implements VersionsStrategy {
    private List<File> fileList;
    private List<Document> docList;
    public StableVersionsStrategy() {
        this.fileList = new ArrayList<File>();
        this.docList = new ArrayList<Document>();
    }

    public void putVersion(Document doc) {
        String toString = doc.getContents();
        File file;
        FileWriter writer;
        try {
            file = new File("state"+fileList.size()+".tex");
            writer = new FileWriter(file);
            writer.write(toString);
            this.fileList.add(file);
            this.docList.add(doc);
            writer.close();
        } catch (IOException e) {
            
        }
    }
    public Document getVersion(){
        if(this.docList.size() >= 1){
            return this.docList.get(this.docList.size()-1);
        }
        Document noDoc = new Document("", "", "", "", "");
        return noDoc;
    }
    public void setEntireHistory(List<Document> dList){
        if(this.fileList != null){
            for(int i=0;i<this.fileList.size();i++){
                this.fileList.get(i).delete();
            }
        }
        this.docList=dList;
        if(this.fileList != null){
            this.fileList.clear();
        }
        if(this.docList != null){
            for(int i=0;i<this.docList.size();i++){
                String toString = this.docList.get(i).getContents();
                File file;
                FileWriter writer;
                try {
                    file = new File("state"+i+".tex");
                    writer = new FileWriter(file);
                    writer.write(toString);
                    this.fileList.add(file);
                    writer.close();
                } catch (IOException e) {
                    
                }
            }
        }
    }
    public List<Document> getEntireHistory(){
        return this.docList;
    }
    public void removeVersion(){
        if(this.fileList != null){
            if(this.fileList.size() > 1){
                this.fileList.get(this.fileList.size()-1).delete();
                this.fileList.remove(this.fileList.size()-1);;
                this.docList.remove(this.docList.size()-1);
            }
        }
    }

    public void clearAndGo(){
        if(this.fileList != null){
            for(int i=0; i<this.fileList.size(); i++){
                this.fileList.get(i).delete();
            }
        }
    }
}*/