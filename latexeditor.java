import java.io.*;

public class latexeditor{
     public static void main(String[] args) {
        System.out.println("Please give a number to create a specific LaTeX document");
        System.out.println("If no input is given then an empty document will be created");
        System.out.println("- 1 for a report template");
        System.out.println("- 2 for a book template");
        System.out.println("- 3 for an article template");
        System.out.println("- 4 for a letter template");
        String line="";
        String text="";
        BufferedReader src;
        FileWriter dest;
        try {
            src = new BufferedReader(new FileReader("temp1.txt"));
            dest = new FileWriter("test.tex");
            line=src.readLine();
            while (line != null) {
                dest.write(line+"\n");
                System.out.println(line);
                line=src.readLine();
            }
            System.out.println(text);
            src.close();
            dest.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}