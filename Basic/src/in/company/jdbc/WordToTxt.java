package in.company.jdbc;

import java.io.*;

public class WordToTxt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File f=new File("F:\\arjun.txt");
		FileInputStream fis =new FileInputStream("F:\\arjun.txt");
		FileOutputStream fos=new FileOutputStream("F:\\arjun.xls");
		int i=0;  
	    while((i=fis.read())!=-1)
	    {  
	    	fos.write(i);
	      
	     // System.out.print((char)i);  
	    	
	   }	
	    
	    }
	      
	}


