package tests;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import model.Document;
import model.DocumentManager;



public class US1Test {

	@Test
	public void test() throws IOException {
		DocumentManager test = new DocumentManager();
		String [] latexString = new String [5];
		int num;
		
		
		Document test1 = test.createDocument("Report");
		Document test2 = test.createDocument("Book");
		Document test3 = test.createDocument("Article");
		Document test4 = test.createDocument("Letter");
		Document test5 = test.createDocument("");
		
		
			for (num = 0; num<5; num++){
				latexString[num]="";
				
				 try {
			         BufferedReader src;
			         String line="";
			         String f = Integer.toString(num+1);
			         src = new BufferedReader(new FileReader("temp"+ f +".tex"));
			         line=src.readLine();
			         while (line != null) {
			             latexString[num]+=line+"\n";
			             line=src.readLine();
			         }
			         src.close();
			     } catch (FileNotFoundException e) {

			     }
				 

				
				}
			
			for(int i=0; i<5; i++){
				switch(i){
				
				case(0):
					if(!latexString[i].equals(test1.getContents())){
						fail("Test 1 failed");
					}else {i++;}
					
				case(1):
					if(!latexString[i].equals(test2.getContents())){
						fail("Test 2 failed");
					}else {i++;}
					
				case(2):
					if(!latexString[i].equals(test3.getContents())){
						fail("Test 3 failed");
					}else {i++;}
					
				case(3):
					if(!latexString[i].equals(test4.getContents())){
						fail("Test 4 failed");
					}else {i++;}
					
				case(4):
					if(!latexString[i].equals(test5.getContents())){
						fail("Test 5 failed");
					}else {i++;}
					
				}
			}
			
		
		
	}
	
}