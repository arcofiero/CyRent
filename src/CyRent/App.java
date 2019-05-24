package CyRent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;


public class App {
	public String userName = "";
	public String carType = "";
	public double hour = 0;
	public double penalty = 0.1;
	public double cost = 0.0;
	private Scanner sc;

	
	public App(String userName, String carType, double hours) {
		this.userName = userName;
		this.carType = carType;
		this.hour = hours;
	}
	
	public static UUID generateRandNumber() {
		return UUID.randomUUID() ;
	}

	public double hoursUsed() {
		return hour;	
	}
	
	public boolean checkHours() {
		boolean extraHours = false;
		
		if(hour >=8) {
			extraHours = true;
			
		}
		return extraHours;
		
	}
	
	public double getCarCost() throws FileNotFoundException {
		File inputFile = new File("CarDetails.txt");
		sc = new Scanner(inputFile);
		while(sc.hasNextLine()) {
			 String line = sc.nextLine();
			 if ( line.toLowerCase().indexOf(carType.toLowerCase()) != -1 ) { 
				 String[] splitStr = line.split("\\s+");
				 return Double.parseDouble(splitStr[1]);
			 }
		}
		sc.close();
		return -1;
	}

	public double totalCost() throws FileNotFoundException {
		double carCost = getCarCost();
		if (carCost == -1) {
			return 0;
		}
		if (checkHours()) {
			return (hour * carCost) + (hour * carCost * penalty);
		}
		else {
			return hour * carCost;
		}
	}
	
	public String receipt() throws FileNotFoundException {
		return "User Name: " + userName + "\n" + "Car Type:" + carType + "\n" + "Car Cost: $" + String.format("%.2f", getCarCost()) + "\n" 
					+ "Hours Booked:" + hour + "\n" + "Total Cost: $" + String.format("%.2f", totalCost())+"\nConfirmation Number: "+generateRandNumber(); 
	}
	
	
}
