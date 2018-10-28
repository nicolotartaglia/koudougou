package org.golemi.crypto.rsa.dechifr;

import java.math.BigInteger;

public class DeChiffreManager {
	
	
	public static BigInteger dechiffre(BigInteger message, BigInteger privateKey, BigInteger modulus ){
	    BigInteger encrypt =  message.modPow(privateKey, modulus);
	    return encrypt;
	}
}
