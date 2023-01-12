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
			
			if (gaattc != -1) {
				System.out.format("GAATTC: %d, %d", gaattc, (gaattc + 6));
			} else if (gatcc != -1){
				System.out.format("GATCC: %d, %d", gatcc, (gatcc + 5));
			} else {
				System.out.println("-1");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
