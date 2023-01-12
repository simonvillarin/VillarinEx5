package org.ssglobal.training.codes.itemB;

import java.io.IOException;

public class Mileage {
	private String name;
	private double pricePerGallon;
	private double amountPaid;
	private int initialOdometer;
	private int finalOdometer;
	private int totalMiles;
	private double gallonsUsed;
	private double milesPerGallon;
	
	public void inputDetails() {
		try {
			byte[] kbname = new byte[1024];
			System.out.print("Enter your name: ");
			System.in.read(kbname);
			String name1 = new String(kbname);
			String name2 = "";
			
			for (short i = 0; i < name1.length(); i++) {
				name2 += name1.charAt(i);
			}
			name = name2.trim();
			System.in.skipNBytes(System.in.available());
			
			byte[] kbprice = new byte[1024];
			System.out.print("Enter price per gallon: ");
			System.in.read(kbprice);
			String price1 = new String(kbprice);
			String price2 = "";
			
			for (short i = 0; i < price1.length(); i++) {
				price2 += price1.charAt(i);
			}
			pricePerGallon = Double.parseDouble(price2.trim());
			System.in.skipNBytes(System.in.available());
			
			byte[] kbamount = new byte[1024];
			System.out.print("Enter total price to fill up: ");
			System.in.read(kbamount);
			String amount1 = new String(kbamount);
			String amount2 = "";
			
			for (short i = 0; i < amount1.length(); i++) {
				amount2 += amount1.charAt(i);
			}
			amountPaid = Double.parseDouble(amount2.trim());
			System.in.skipNBytes(System.in.available());
			
			byte[] kbinitial = new byte[1024];
			System.out.print("Enter initial odometer value: ");
			System.in.read(kbinitial);
			String initialOdometer1 = new String(kbinitial);
			String initialOdometer2 = "";
			
			for (int i = 0; i < initialOdometer1.length(); i++) {
				initialOdometer2 += initialOdometer1.charAt(i);
			}
			initialOdometer = Integer.parseInt(initialOdometer2.trim());
			System.in.skipNBytes(System.in.available());

			byte[] kbfinal = new byte[1024];
			System.out.print("Enter final odometer value: ");
			System.in.read(kbfinal);
			String finalOdometer1 = new String(kbfinal);
			String finalOdometer2 = "";
			
			for (short i = 0; i < finalOdometer1.length(); i++) {
				finalOdometer2 += finalOdometer1.charAt(i);
			}
			finalOdometer = Integer.parseInt(finalOdometer2.trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void computeMileage() {
		totalMiles = finalOdometer - initialOdometer;
		gallonsUsed = amountPaid / pricePerGallon;
		milesPerGallon = totalMiles / gallonsUsed;
	}
	
	public void print() {
		System.out.format("%s, you drove %d miles using \n", name, totalMiles);
		System.out.format("%f gallons with an mpg of %f", gallonsUsed, milesPerGallon);
	}
}
