package org.ssglobal.training.codes.itemC;

public class Deprecation {
	private int MACHINE_PURCHASED = 28_000;
	private final int RATE = 4_000;
	
	public void depreciate() {
		System.out.format("%-5s %-5s %-5s %s \n", "Year", "Deprecation", "End-of-year-value", "Accumulated deprecation");
		System.out.format("%-5s %-5s %-5s %s \n", "----", "-----------", "-----------------", "-----------------------");
		for (short i = 1; i <= (MACHINE_PURCHASED / RATE); i++) {
			int accumulated = RATE * i;
			int value = MACHINE_PURCHASED - accumulated;
			
			System.out.format(" %-7d %-13d %-18d %d \n", i, RATE, value, accumulated);
		}
	}
}
