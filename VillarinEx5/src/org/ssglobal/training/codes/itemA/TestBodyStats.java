package org.ssglobal.training.codes.itemA;

import java.io.IOException;

public class TestBodyStats {

	public static void main(String[] args) {
		byte[] kbheight = new byte[1024];
		char gender = 0;
		int height = 0;
		
		try {
			System.out.print("Enter gender ([F] for Female and [M] for Male): ");
			gender = (char) System.in.read();
			
			System.in.skipNBytes(System.in.available());
			
			System.out.print("Enter height: ");
			System.in.read(kbheight);
			String height1 = new String(kbheight).toString().trim();
			height = Integer.parseInt(height1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BodyStats bs = new BodyStats();
		bs.inputHeight(gender, height);
	}

}
