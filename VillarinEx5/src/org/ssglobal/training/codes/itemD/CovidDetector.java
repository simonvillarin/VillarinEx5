package org.ssglobal.training.codes.itemD;

import java.io.IOException;

public class CovidDetector {
	public void verifyCovid() {
		try {
			byte[] kbsequence = new byte[1024];
			System.out.print("Enter a DNA sequence: ");
			System.in.read(kbsequence);
			String sequence = new String(kbsequence).toString().trim();
			
			int gaattc = sequence.indexOf("GAATTC");
			int gatcc = sequence.indexOf("GATCC");

			if (gaattc != -1 && gatcc != -1) {
				System.out.format("GAATTC: %d, %d \n", gaattc, gaattc + 5);
				System.out.format("GATCC: %d, %d", gatcc, gatcc + 4);
			} else if (gaattc != -1 ) {
				System.out.format("GAATTC: %d, %d", gaattc, gaattc + 5);
			} else if (gatcc != -1) {
				System.out.format("GATCC: %d, %d", gatcc, gatcc + 4);
			} else {
				System.out.println(-1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
