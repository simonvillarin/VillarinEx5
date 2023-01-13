package org.ssglobal.training.codes.itemA;

import java.io.IOException;

public class BodyStats {
	private char gender;
	private int height;
	private int weight;
	private final int IDEAL_WEIGHT_FOR_FEMALE = 100;
	private final int IDEAL_WEIGHT_FOR_MALE = 106;
	private final int MIN_HEIGHT = 50;
	private final int PLUS_POUNDS_FOR_FEMALE = 5;
	private final int PLUS_POUNDS_FOR_MALE = 6;
	private final double RANGE = 0.15;

	public void inputHeight(char gender, int height) {
		this.gender = gender;
		this.height = height;
		int weight = computeWeight();
		boolean isOkay = normalWeight();
		
		System.out.format("Actual Weight: %d \n", weight);
		if (isOkay) {
			System.out.println("Weight is okay.");
		} else {
			System.out.println("Weight is not okay.");
		}
	}

	public int computeWeight() {
		int diffInHeight = (height - MIN_HEIGHT);
		
		if (diffInHeight > 9) {
			diffInHeight += 2;
		}

		if (gender == 'F' || gender == 'f') {
			weight = IDEAL_WEIGHT_FOR_FEMALE + (diffInHeight * PLUS_POUNDS_FOR_FEMALE);
		} else if (gender == 'M' || gender == 'm'){
			weight = IDEAL_WEIGHT_FOR_MALE + (diffInHeight * PLUS_POUNDS_FOR_MALE);
		} else {
			System.out.println("Invalid input.");
		}
		return weight;
	}
	
	public boolean normalWeight() {
		double minRangeFemale = (IDEAL_WEIGHT_FOR_FEMALE - (IDEAL_WEIGHT_FOR_FEMALE * RANGE));
		double maxRangeFemale = (IDEAL_WEIGHT_FOR_FEMALE + (IDEAL_WEIGHT_FOR_FEMALE * RANGE));
		double minRangeMale = (IDEAL_WEIGHT_FOR_MALE - (IDEAL_WEIGHT_FOR_MALE * RANGE));
		double maxRangeMale = (IDEAL_WEIGHT_FOR_MALE + (IDEAL_WEIGHT_FOR_MALE * RANGE));
		
		
		if ((gender == 'F' || gender == 'f') && (weight <= maxRangeFemale && weight >= minRangeFemale)) {
			return true;
		} else if ((gender == 'M' || gender == 'm') && (weight <= maxRangeMale && weight >= minRangeMale)) {
			return true;
		}
		return false;
	}
	
	public void print() {
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
			inputHeight(gender, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
