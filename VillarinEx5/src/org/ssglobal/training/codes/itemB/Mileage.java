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
			name = new String(kbname).toString().trim();
			System.in.skipNBytes(System.in.available());
			
			byte[] kbprice = new byte[1024];
			System.out.print("Enter price per gallon: ");
			System.in.read(kbprice);
			String price = new String(kbprice).toString().trim();
			pricePerGallon = Double.parseDouble(price.trim());
			System.in.skipNBytes(System.in.available());
			
			byte[] kbamount = new byte[1024];
			System.out.print("Enter total price to fill up: ");
			System.in.read(kbamount);
			String amount = new String(kbamount).toString().trim();
			amountPaid = Double.parseDouble(amount);
			System.in.skipNBytes(System.in.available());
			
			byte[] kbinitial = new byte[1024];
			System.out.print("Enter initial odometer value: ");
			System.in.read(kbinitial);
			String initialOdometer1 = new String(kbinitial).toString().trim();
			initialOdometer = Integer.parseInt(initialOdometer1);
			System.in.skipNBytes(System.in.available());

			byte[] kbfinal = new byte[1024];
			System.out.print("Enter final odometer value: ");
			System.in.read(kbfinal);
			String finalOdometer1 = new String(kbfinal).toString().trim();
			finalOdometer = Integer.parseInt(finalOdometer1);
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
