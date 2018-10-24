package org.golemi.crypto.rsa.algo;

import java.math.BigInteger;

/**
 * Test la classe {@link MullerRabinPrimarityVerificator}
 * @author golemi
 *
 */
public final class MullerRabinPrimarityTest {

	public static void main(String[] args) {
		String[] primes = { "2", "3", "41", "48", "105", "3613", "7297", "226673591177742970257407", "2932031007403",
	    "2266735911777429702574072" };
	
		for (String p : primes) {
			boolean result = MullerRabinPrimarityVerificator.isProbablePrime(new BigInteger(p));
			System.out.println("Le nombre " + p + " est -il probablement premier ? :  " + result);
		}
	}

}