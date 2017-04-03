package com.mam.keygenerator;

import java.util.Random;

public class keyGenerator {
	
	public int randomizeAccID() {
		Random rnd = new Random();
		int newAccID = rnd.nextInt(1000000 - 100000) + 100000;
		return newAccID;
	}
}
