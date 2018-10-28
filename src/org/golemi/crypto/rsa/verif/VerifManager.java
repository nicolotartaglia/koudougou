package org.golemi.crypto.rsa.verif;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class VerifManager {
	
	
	public static boolean verify(BigInteger modulus, BigInteger exponent, String  sigBytes)  throws Exception{
	    Signature sig = Signature.getInstance("SHA1withRSA");
	    KeyFactory keyMaker = KeyFactory.getInstance("RSA");
	    RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulus, exponent);
	    RSAPublicKey pubKey = (RSAPublicKey)keyMaker.generatePublic(pubKeySpec);
	    sig.initVerify(pubKey);
	    return sig.verify(sigBytes.getBytes());
	}
	

}
