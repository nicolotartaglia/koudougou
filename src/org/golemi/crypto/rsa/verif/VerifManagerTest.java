package org.golemi.crypto.rsa.verif;

import java.math.BigInteger;
import java.util.List;

import org.golemi.crypto.rsa.gencle.FileUtils;

public class VerifManagerTest {

	public static void main(String[] args) throws Exception {
		if(args.length < 2){
			throw new IllegalArgumentException("Deux arguments doit etres specifie");
		}
		List<BigInteger> bigs = FileUtils.lireCle(args[0]);
		BigInteger pubKey = bigs.get(0);
		BigInteger modulus = bigs.get(1);
	    boolean result = VerifManager.verify(modulus, pubKey, args[1]);
	    System.out.println("La signature correspond : "+ result);
	}

	
}
