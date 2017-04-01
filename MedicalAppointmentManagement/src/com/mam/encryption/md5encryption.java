package com.mam.encryption;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class md5encryption {

	//Available Algorithms: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
	
	public static String getHash(byte[] inputByte) {
		String hashValue = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(inputByte);
			byte[] digestedByte = md.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedByte).toLowerCase();
		} catch (Exception e) {
			System.out.print(e);
		}
		return hashValue;
	}

}
