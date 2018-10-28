package org.golemi.crypto.rsa.gencle;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.golemi.crypto.rsa.Constant;
import org.golemi.crypto.rsa.FileUtils;

public class Gencle {
	
	
	public static List<BigInteger> generateKey(int size) throws Exception{
		Random rand = new SecureRandom();
		System.out.println("# Generating RSA keys for bloc size"+ size +"bits.");
		BigInteger p = BigInteger.probablePrime(size, rand);;
		BigInteger q = BigInteger.probablePrime(size, rand);;
		
		BigInteger modulus = p.multiply(q);
		System.out.println("# p,q pair generated. public n is :");
		System.out.println(modulus.toString());
		
		BigInteger pubKey = new BigInteger("65537");
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); 
		BigInteger priKey = pubKey.modInverse(phi);
		System.out.println("# a, b pair generated. public b is:");
		System.out.println(priKey.toString());
		
		System.out.println("# check a*b=1 mod phi(n), a*b :"+pubKey.multiply(priKey).modInverse(phi));
		
		
		List<BigInteger> bigs = new ArrayList<BigInteger>();
		bigs.add(pubKey);
		bigs.add(priKey);
		bigs.add(modulus);
		FileUtils.ecrireCle(Constant.NAME_PRIVATE, priKey, modulus);
		FileUtils.ecrireCle(Constant.NAME_PUBLIC, pubKey, modulus);
		System.out.println("# OK : paire de cle stockee dans ");
		return bigs;
		
	}
	
	

}
