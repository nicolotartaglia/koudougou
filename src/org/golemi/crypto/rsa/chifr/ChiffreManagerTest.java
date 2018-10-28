package org.golemi.crypto.rsa.chifr;



import java.math.BigInteger;
import java.util.List;

import org.golemi.crypto.rsa.gencle.FileUtils;
public class ChiffreManagerTest {

	public static void main(String[] args) throws Exception {
		if(args.length <2){
			throw new IllegalArgumentException(" deux arguments doit etres specifie");
		}
		List<BigInteger> bigs = FileUtils.lireCle(args[1]);
		BigInteger pubKey = bigs.get(0);
		BigInteger modulus = bigs.get(1);
		BigInteger original = new BigInteger(args[0].getBytes());
		
		BigInteger messageChiffre  = ChiffreManager.chiffre(original,pubKey,modulus);
		System.out.println("Message Chiffree:" +messageChiffre);


	}
}
