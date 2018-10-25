package org.golemi.crypto.rsa.algo;

import java.math.BigInteger;
import java.util.Random;

/**
 * C'est une classe d'implementation de l'algorithme de Muller Rabin pour voire si un nombre est premier ou pas.
 * 
 * @author golemi
 *
 */
public final class MullerRabinPrimarityVerificator {

	/**
	 * Test si un grand nombre est premier ou pas.
	 * @param number : Nombre a verifier sa primarite
	 * @return <code>true<code> si le nombre est premier <code>false<code> sinon.
	 */
	public static boolean isProbablePrime(BigInteger number) {
		return isProbablePrime(number, 400);
	}
	
	public static BigInteger generatePremier(int t1, int t2){
		boolean isPrime = false;
		BigInteger value = null;
		while(!isPrime){
			value = new BigInteger(t2, new Random());
			int lenght = value.bitLength();
			if(lenght >= t1 && lenght <=t2 ){
				isPrime = MullerRabinPrimarityVerificator.isProbablePrime(value);	
			}
		}
		return value;
	}

	/**
	 * Test si un grand nombre est premier ou pas.
	 * @param number : Nombre a verifier sa primarite
	 * @param precision :  nombre de chiffre
	 * @return <code>true<code> si le nombre est premier <code>false<code> sinon.
	 */
	public static boolean isProbablePrime(BigInteger number, int precision) {

		BigInteger deux = new BigInteger("2");
		if (number.compareTo(BigInteger.ONE) == 0) {
			return false;
		}
		if (number.compareTo(new BigInteger("3")) < 0)
			return true;
		int s = 0;
		BigInteger d = number.subtract(BigInteger.ONE);
		while (d.mod(deux).equals(BigInteger.ZERO)) {
			s++;
			d = d.divide(deux);
		}
		for (int i = 0; i < precision; i++) {
			BigInteger a = uniformRandom(deux, number.subtract(BigInteger.ONE));
			BigInteger x = a.modPow(d, number);
			if (x.equals(BigInteger.ONE) || x.equals(number.subtract(BigInteger.ONE)))
				continue;
			int r = 0;
			for (; r < s; r++) {
				x = x.modPow(deux, number);
				if (x.equals(BigInteger.ONE))
					return false;
				if (x.equals(number.subtract(BigInteger.ONE)))
					break;
			}
			if (r == s)
				return false;
		}
		return true;
	}

	private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
		Random rnd = new Random();
		BigInteger res;
		do {
			res = new BigInteger(top.bitLength(), rnd);
		} while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
		return res;
	}
}