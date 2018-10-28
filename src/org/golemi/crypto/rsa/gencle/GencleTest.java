package org.golemi.crypto.rsa.gencle;



public class GencleTest {

	public static void main(String[] args) throws Exception {
		if(args.length < 1){
			throw new IllegalArgumentException("La taille doit etre specifier");
		}
		Gencle.generateKey(Integer.parseInt(args[0]));
		
	}

}
