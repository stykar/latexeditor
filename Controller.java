import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.*;

public class Controller{

    private UIManager ui;

    public void startControlling(UIManager userInterface){
        this.ui=userInterface;
        userInterface.createFirstUI();
    }

    public void createSecUI(String input){
        ui.createSecondUI(input);
    }

    public void reportTemplatePressed(){
        String latexString;
        ReportTemplate template = new ReportTemplate();
        latexString = template.createTemplate();
        createSecUI(latexString);
    }

    public void bookTemplatePressed(){
        String latexString;
        BookTemplate template = new BookTemplate();
        latexString = template.createTemplate();
        //JOptionPane.showMessageDialog(null,"Created Book Template");
        createSecUI(latexString);
    }

    public void articleTemplatePressed(){
        String latexString;
        ArticleTemplate template = new ArticleTemplate();
        latexString = template.createTemplate();
        //JOptionPane.showMessageDialog(null,"Created Article Template");
        createSecUI(latexString);
    }

    public void letterTemplatePressed(){
        String latexString;
        LetterTemplate template = new LetterTemplate();
        latexString = template.createTemplate();
        //JOptionPane.showMessageDialog(null,"Created Letter Template");
        createSecUI(latexString);
    }

    public void emptyTemplatePressed(){
        String latexString;
        EmptyTemplate template = new EmptyTemplate();
        latexString = template.createTemplate();
        //JOptionPane.showMessageDialog(null,"Created Empty Template");
        createSecUI(latexString);
    }

    public void saveButtonPressed(JTextArea input){
        try {
            String filepath = ui.getTextInput();
            FileWriter dest;
            dest = new FileWriter(filepath+".tex");
            dest.write(input.getText());
            dest.close();
        } catch (FileNotFoundException err) {

        } catch (IOException err) {

        } 
    }

    public void loadButtonPressed(JTextArea input){
        String filepath = ui.getTextInput();
        BufferedReader src;
        String fileData="";
        String line="";
        try {
            src = new BufferedReader(new FileReader(filepath));
            line=src.readLine();
            while (line != null) {
                fileData+=line+"\n";
                line=src.readLine();
            }
            src.close();
        } catch (FileNotFoundException err) {

        } catch (IOException err) {

        }
        input.setText("");
        input.append(fileData);
    }

    public void chapterButtonPressed(JTextArea input){
        String checkTemplate = "{letter}";
        String checkTemplate2 = "{article}";
        if((ui.getLatexString().contains(checkTemplate)) 
            || (ui.getLatexString().contains(checkTemplate2))){
            JOptionPane.showMessageDialog(null,"Cant put Chapter in this Template");
        } else{
            input.insert("\\chapter{...}", input.getCaretPosition());
        }
    }

    public void sectionButtonPressed(JTextArea input){
        String checkTemplate = "{letter}";
        if(ui.getLatexString().contains(checkTemplate)){
            JOptionPane.showMessageDialog(null,"Cant put Section in this Template");
        } else{
            input.insert("\\section{}", input.getCaretPosition());
        }
    }

    public void subsectionButtonPressed(JTextArea input){
        input.insert("\\Subsection{}", input.getCaretPosition());
    }

    public void subsubsectionButtonPressed(JTextArea input){
        input.insert("\\Subsubsection{}", input.getCaretPosition());
    }

    public void itemizeButtonPressed(JTextArea input){
        input.insert("\\begin{itemize} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{itemize}", input.getCaretPosition());
    }

    public void enumerateButtonPressed(JTextArea input){
        input.insert("\\begin{enumerate} \n"
                        +" \\item ... \n \\item ... "
                        +"\n \\end{enumerate}", input.getCaretPosition());
    }

    public void tableButtonPressed(JTextArea input){
        input.insert("\\begin{table} \n"
                +"\\caption{....}\\label{...} \n"
                +"\\begin{tabular}{|c|c|c|} \n"
                +"  \\hline\n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"  \\hline \n"
                +"\\end{tabular}\n"
                +"\\end{table}", input.getCaretPosition());
    }

    public void figureButtonPressed(JTextArea input){
        input.insert("\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}", input.getCaretPosition());
    }

}