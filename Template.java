import java.io.*;

public interface Template{
    public void createTemplate();
}

class ReportTemplate implements Template{
    public void createTemplate(){
        try {
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp1.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
class BookTemplate implements Template{
    public void createTemplate(){
        try {
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp2.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}

class ArticleTemplate implements Template{
    public void createTemplate(){
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
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}

class LetterTemplate implements Template{
    public void createTemplate(){
        try {
            BufferedReader src;
            FileWriter dest;
            String line="";
            src = new BufferedReader(new FileReader("temp4.txt"));
            dest = new FileWriter("template.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                line=src.readLine();
            }
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}

class EmptyTemplate implements Template{
    public void createTemplate(){
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
    }
}