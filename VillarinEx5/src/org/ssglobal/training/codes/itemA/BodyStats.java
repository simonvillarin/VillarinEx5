package org.ssglobal.training.codes.itemA;

public class BodyStats {
	private final int IDEAL_WEIGHT_FOR_FEMALE = 100;
	private final int IDEAL_WEIGHT_FOR_MALE = 106;
	private final int MIN_HEIGHT = 50;
	private final int PLUS_POUNDS_FOR_FEMALE = 5;
	private final int PLUS_POUNDS_FOR_MALE = 6;
	private final double RANGE = 0.15;

	public void inputHeight(char gender, int height) {
		int weight = computeWeight(gender, height);
		boolean isOkay = normalWeight(gender, weight);
		
		System.out.format("Actual Weight: %d \n", weight);
		if (isOkay) {
			System.out.println("Weight is okay.");
		} else {
			System.out.println("Weight is not okay.");
		}
	}

	public int computeWeight(char gender, int height) {
		int weight = 0;
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
	
	public boolean normalWeight(char gender, int weight) {
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
}
