package org.golemi.crypto.rsa.gencle;

import java.math.BigInteger;

import org.golemi.crypto.rsa.Constant;
import org.golemi.crypto.rsa.algo.MullerRabinPrimarityVerificator;

public class Gencle {
	
	
	
	public static void generateKey(int size) throws Exception{
		System.out.println("# Generating RSA keys for bloc size 512 bits.");
		BigInteger p = MullerRabinPrimarityVerificator.generatePremier(size/2, size/2+16);
		BigInteger q = MullerRabinPrimarityVerificator.generatePremier(size/2, size/2+16);
		BigInteger n = p.multiply(q);
		System.out.println("# p,q pair generated. public n is :");
		System.out.println(n.toString());
		
		BigInteger a = MullerRabinPrimarityVerificator.generatePremier(size/2, size/2+16);
		BigInteger b = a.modInverse(n);
		System.out.println("# a,b pair generated. public b is:");
		System.out.println(b.toString());
		
		System.out.println("# check a*b=1 mod phi(n) a*b :"+ a.multiply(b));
		
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));   
		
		BigInteger clepublic  = new BigInteger("65537");    
		BigInteger cleprivee = clepublic.modInverse(phi);
		FileUtils.ecrireCle(Constant.DIRECTORY+Constant.NAME_PRIVATE, cleprivee.toString());
		FileUtils.ecrireCle(Constant.DIRECTORY+Constant.NAME_PUBLIC, clepublic.toString());
		System.out.println("# OK : paire de cle stockee dans "+(Constant.DIRECTORY+Constant.NAME_PRIVATE));
		
		
	}
	
	

}
