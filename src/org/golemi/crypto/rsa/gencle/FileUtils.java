package org.golemi.crypto.rsa.gencle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtils {

	
	public static final String lireCle(String path)throws Exception{
		StringBuffer b = new StringBuffer();
		BufferedReader reader = null;
		try{
			File file = new File(path);
			if(!file.exists()){
				throw new FileNotFoundException ("Le fichier suivant n'existe pas : " + file);
			}
			reader = new BufferedReader (new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				b.append(line);
			}
		}catch(Exception e){
			
		}
		finally {
			reader.close();
		    }
		if(b.length()<1){
			throw new Exception ("Aucun cle trouve ");
		}
		return "null";
	}
	
	public static final void ecrireCle(String path, String content) throws Exception{
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(path));
	        output.write(content);
	    }
		catch(Exception e){
			throw e;
		}
	    finally {
	      output.close();
	    }
	}
		 
}
