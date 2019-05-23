package controller;
import model.*;
import view.*;


public class LatexEditor{
     public static void main(String[] args) {
        LatexEditorController cont = new LatexEditorController();
        UIManager ui = new UIManager(cont);
        cont.startControlling(ui);
    }
}