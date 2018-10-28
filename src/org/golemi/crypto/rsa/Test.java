package org.golemi.crypto.rsa;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args) {
		String message = "bromo";
		System.out.println("Message : "+message);
		BigInteger  data = new BigInteger(message.getBytes());
		System.out.println("Original : "+ data);
		System.out.println("Enn:" + new String(data.toByteArray()));

	}

}
