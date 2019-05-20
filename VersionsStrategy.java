import java.util.List;
import java.io.*;

public interface VersionsStrategy {
    public void putVersion(Document d);

    public Document getVersion();

    public void setEntireHistory(List<Document> dList);

    public List<Document> getEntireHistory();

    public void removeVersion();
}

class VolatileVersionsStrategy implements VersionsStrategy {
    private List<Document> dList;

    public VolatileVersionsStrategy() {

    }

    public void putVersion(Document doc) {
        this.dList.add(doc);
    }

    public Document getVersion() {
        return this.dList.get(this.dList.size());
    }

    public void setEntireHistory(List<Document> docList) {
        this.dList = docList;
    }

    public List<Document> getEntireHistory() {
        return this.dList;
    }

    public void removeVersion() {
        this.dList.remove(this.dList.size());
    }
}

class StableVersionsStrategy implements VersionsStrategy {
    private List<File> fileList;
    private List<Document> docList;
    public StableVersionsStrategy() {

    }

    public void putVersion(Document doc) {
        String toString = doc.getContents();
        File file;
        FileWriter writer;
        try {
            file = new File("state"+fileList.size()+1);
            writer = new FileWriter(file);
            writer.write(toString);
            this.fileList.add(file);
            this.docList.add(doc);
            writer.close();
        } catch (IOException e) {
            
        }
    }
    public Document getVersion(){
        return this.docList.get(this.docList.size());
    }
    public void setEntireHistory(List<Document> dList){
        for(int i=0;i<this.fileList.size();i++){
            this.fileList.get(i).delete();
        }
        this.docList=dList;
        this.fileList.clear();
        for(int i=0;i<this.docList.size();i++){
            String toString = this.docList.get(i).getContents();
            File file;
            FileWriter writer;
            try {
                file = new File("state"+i);
                writer = new FileWriter(file);
                writer.write(toString);
                this.fileList.add(file);
                writer.close();
            } catch (IOException e) {
                
            }
        }
    }
    public List<Document> getEntireHistory(){
        return this.docList;
    }
    public void removeVersion(){
        this.fileList.get(this.fileList.size()).delete();
        this.fileList.remove(this.fileList.size());
        this.docList.remove(this.docList.size());
    }
}