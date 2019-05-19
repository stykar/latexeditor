import java.io.*;

public class DocumentManager{
    public DocumentManager(){

    }

    public Document createDocument(String s){
        if(s.equals("Report")){
            String latexString="";
            try {
                BufferedReader src;
                String line="";
                src = new BufferedReader(new FileReader("temp1.tex"));
                line=src.readLine();
                while (line != null) {
                    latexString+=line+"\n";
                    line=src.readLine();
                }
                src.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
            Document c = new Document("author1","currentdate","C","1",latexString);
            return c;
        }else if(s.equals("Book")){
            String latexString="";
            try {
                BufferedReader src;
                String line="";
                src = new BufferedReader(new FileReader("temp2.tex"));
                line=src.readLine();
                while (line != null) {
                    latexString+=line+"\n";
                    line=src.readLine();
                }
                src.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
            Document c = new Document("author1","currentdate","C","1",latexString);
            return c;
        }else if(s.equals("Article")){
            String latexString="";
            try {
                System.out.print("0");
                BufferedReader src;
                String line="";
                src = new BufferedReader(new FileReader("temp3.tex"));
                line=src.readLine();
                while (line != null) {
                    latexString+=line+"\n";
                    line=src.readLine();
                }
                src.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
            Document c = new Document("author1","currentdate","C","1",latexString);
            return c;
        }else if(s.equals("Letter")){
            String latexString="";
            try {
                BufferedReader src;
                String line="";
                src = new BufferedReader(new FileReader("temp4.tex"));
                line=src.readLine();
                while (line != null) {
                    latexString+=line+"\n";
                    line=src.readLine();
                }
                src.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
            Document c = new Document("author1","currentdate","C","1",latexString);
            return c;
        }else{
            String latexString="";
            Document c = new Document("author1","currentdate","C","1",latexString);
            return c;
        }
    }
}