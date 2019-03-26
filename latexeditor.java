import java.io.*;
import java.util.Scanner;

public class latexeditor{
     public static void main(String[] args) {
        System.out.println("Please give a number to create a specific LaTeX document");
        System.out.println("If no input is given then an empty document will be created");
        System.out.println("- 1 for a report template");
        System.out.println("- 2 for a book template");
        System.out.println("- 3 for an article template");
        System.out.println("- 4 for a letter template");
        System.out.print("Input:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("");
        String line="";
        String text="";
        BufferedReader src;
        FileWriter dest;
        if(num == 1){
            try {
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
        if(num == 2){
            try {
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
        if(num == 3){
            try {
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
        if(num == 4){
            try {
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
}