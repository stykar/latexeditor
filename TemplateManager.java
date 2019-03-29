import java.io.*;

public interface TemplateManager{
    public String createTemplate();
}

class ReportTemplate implements TemplateManager{
    public String createTemplate(){
        String latexString="";
        try {
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp1.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                latexString+=line+"\n";
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return latexString;
    }
}
class BookTemplate implements TemplateManager{
    public String createTemplate(){
        String latexString="";
        try {
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp2.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                latexString+=line+"\n";
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return latexString;
    }
}

class ArticleTemplate implements TemplateManager{
    public String createTemplate(){
        String latexString="";
        try {
            System.out.print("0");
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp3.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                latexString+=line+"\n";
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return latexString;
    }
}

class LetterTemplate implements TemplateManager{
    public String createTemplate(){
        String latexString="";
        try {
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp4.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                latexString+=line+"\n";
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return latexString;
    }
}

class EmptyTemplate implements TemplateManager{
    public String createTemplate(){
        String latexString="";
        File dest = new File("template.txt");
        if (dest.exists()) {
            dest.delete();     
        }

        try {
            FileWriter fin;
            fin = new FileWriter("template.tex");
            
            fin.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return latexString;
    }
}