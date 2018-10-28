package org.golemi.crypto.rsa.chifr;

import java.math.BigInteger;


public class ChiffreManager {
	
	public static BigInteger chiffre(BigInteger message, BigInteger publicKey, BigInteger modulus ){
	    BigInteger encrypt =  message.modPow(publicKey, modulus);
	    return encrypt;
	}
}
