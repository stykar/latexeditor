//import java.io.*;
import java.util.Scanner;

public class LatexEditor{
     public static void main(String[] args) {
        Controller cont = new Controller();
        UIManager ui = new UIManager(cont);
        cont.startControlling(ui);
    }
}