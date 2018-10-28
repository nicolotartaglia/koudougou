package org.golemi.crypto.rsa.sign;

import java.math.BigInteger;
import java.util.List;

import org.golemi.crypto.rsa.FileUtils;

public class SignManagerTest {

	public static void main(String[] args) throws Exception {
		if(args.length < 2){
			throw new IllegalArgumentException("Deux arguments doit etres specifie");
		}
		BigInteger original = new BigInteger(args[0].getBytes());
		List<BigInteger> bigs = FileUtils.lireCle(args[1]);
		BigInteger pubKey = bigs.get(0);
		BigInteger modulus = bigs.get(1);
	    String result = SignManager.sign(original, modulus, pubKey);
	    System.out.println("Le message signe en base64: "+ result);
	}
    
}
