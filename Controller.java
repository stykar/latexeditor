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

}