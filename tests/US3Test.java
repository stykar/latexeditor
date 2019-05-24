
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JTextArea;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

import model.Document;
import model.DocumentManager;
import controller.Command;
import controller.AddChapter;


public class US3Test {
	
	Command cmd;
	DocumentManager test = new DocumentManager();
	Document test1 = test.createDocument("Report");
	
	
	@Test
	void test1 () { //AddChapter
		
		String chapter = "\\chapter{...}";
		
		cmd = new AddChapterTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , chapter);
	
		
	}	
	@Test
	void test2 () { //AddSubsection
		
		
		
		String subsection = "\\Subsection{}";
		
		cmd = new AddSubsectionTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , subsection);
		
	}
	@Test
	void test3 () { //AddEnumerationListEnumerate
		
		String EnumerationListEnumerate = "\\begin{enumerate} \n"
                +" \\item ... \n \\item ... "
                +"\n \\end{enumerate}";
		
		cmd = new AddEnumerationListEnumerateTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , EnumerationListEnumerate);
		
		
		
	}
	@Test
	void test4 () { //AddEnumerationListItemize
		
		String EnumerationListItemize = "\\begin{itemize} \n"
                +" \\item ... \n \\item ... "
                +"\n \\end{itemize}";
		
		cmd = new AddEnumerationListItemizeTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , EnumerationListItemize);
		
	}
	@Test
	void test5 () { //AddFigure
		
		String AddFigure = "\\begin{figure}\n"
                +"\\includegraphics[width=...,height=...]{...}\n"
                +"\\caption{....}\\label{...}"
                +"\\end{figure}";
		
		cmd = new AddFigureTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , AddFigure);
		
	}
	@Test
	void test6 () { //AddSection
		
		String AddSection = "\\section{}";
		
		cmd = new AddSectionTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , AddSection);
		
		
		
		
	}
	@Test
    void test7 () { //AddSubSubSection
		
		String subsubsection = "\\Subsubsection{}";
		
		cmd = new AddSubSubsectionTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , subsubsection);
		
		
	}
	@Test
	void test8 () { //AddTable
		
		String addTable = "\\begin{table} \n"
                +"\\caption{....}\\label{...} \n"
                +"\\begin{tabular}{|c|c|c|} \n"
                +"  \\hline\n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"... &...&...\\ \n"
                +"  \\hline \n"
                +"\\end{tabular}\n"
                +"\\end{table}";
		
		cmd = new AddTableTest();
		cmd.execute(test1,null);
		
		
		assertEquals(test1.getContents() , addTable);
		
		
	}
		
	
	


}