package org.golemi.crypto.rsa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {


	public static final List<BigInteger> lireCle(String fileName)throws Exception{
		List<BigInteger> files = new ArrayList<BigInteger>();
		ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
		try {
			BigInteger m = (BigInteger) oin.readObject();
			BigInteger e = (BigInteger) oin.readObject();
			files.add(m);
			files.add(e);
		} catch (Exception e) {
			throw new RuntimeException("Spurious serialisation error", e);
		} finally {
			oin.close();
		}
		return files;

	}

	public static final void ecrireCle(String fileName, BigInteger privateKey, BigInteger modulus) throws Exception{
		ObjectOutputStream oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
		try {
			oout.writeObject(privateKey);
			oout.writeObject(modulus);
		} catch (Exception e) {
			throw new Exception("Unexpected error", e);
		} finally {
			oout.close();
		}
	}

}
