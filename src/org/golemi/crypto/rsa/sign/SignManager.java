package org.golemi.crypto.rsa.sign;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Base64;

public class SignManager {
	


	public static String sign(BigInteger message, BigInteger modulus, BigInteger exponent)  throws Exception{
	    Signature sig = Signature.getInstance("SHA1withRSA");
	    KeyFactory keyMaker = KeyFactory.getInstance("RSA");
	    RSAPrivateKeySpec privKeySpec = new RSAPrivateKeySpec(modulus, exponent);
	    RSAPrivateKey privKey = (RSAPrivateKey)keyMaker.generatePrivate(privKeySpec);
	    sig.initSign(privKey);
	    sig.update(message.toByteArray());
	    return Base64.getEncoder().encodeToString(sig.sign());
	}
	

}
