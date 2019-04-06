import java.io.*;

public interface TemplateManager{
    public String createTemplate();
    public String createTemplate(File f);
}

class ReportTemplate implements TemplateManager{
    public String createTemplate(){
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
        return latexString;
    }
    public String createTemplate(File f){
        return null;
    }
}
class BookTemplate implements TemplateManager{
    public String createTemplate(){
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
        return latexString;
    }

    public String createTemplate(File f){
        return null;
    }
}

class ArticleTemplate implements TemplateManager{
    public String createTemplate(){
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
        return latexString;
    }

    public String createTemplate(File f){
        return null;
    }
}

class LetterTemplate implements TemplateManager{
    public String createTemplate(){
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
        return latexString;
    }

    public String createTemplate(File f){
        return null;
    }
}

class EmptyTemplate implements TemplateManager{
    public String createTemplate(){
        String latexString="";
        return latexString;
    }

    public String createTemplate(File f){
        return null;
    }
}

class LoadTemplate implements TemplateManager{
    public String createTemplate(File inputFile){
        String latexString="";
        try {
            System.out.print("0");
            BufferedReader src;
            String line="";
            src = new BufferedReader(new FileReader(inputFile));
            line=src.readLine();
            while (line != null) {
                latexString+=line+"\n";
                line=src.readLine();
            }
            src.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return latexString;
    }

    public String createTemplate(){
        return null;
    }
}