package org.ssglobal.training.codes.itemD;

import java.io.IOException;

public class CovidDetector {
	public void verifyCovid() {
		try {
			byte[] kbsequence = new byte[1024];
			System.out.print("Enter a DNA sequence: ");
			System.in.read(kbsequence);
			String sequence1 = new String(kbsequence);
			String sequence2 = "";

			for (short i = 0; i < sequence1.length(); i++) {
				sequence2 += sequence1.charAt(i);
			}

			int gaattc = sequence2.indexOf("GAATTC");
			int gatcc = sequence2.indexOf("GATCC");
			
			if (gaattc != -1 || gatcc != -1) {
				System.out.println("DNA sequence is not safe");
			} else {
				System.out.println("DNA sequence is safe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
