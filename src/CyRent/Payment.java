package CyRent;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Payment {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> CarType = new ArrayList<String>();
		ArrayList<Double> Price = new ArrayList<Double>();
		
		System.out.println("Welcome to CyRent!");
		System.out.print("Please enter your name: ");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String userName = in.nextLine();
        System.out.print("Please enter the car type (SUV, HatchBack, Sedan, Truck): ");
        String carType = in.nextLine();
        System.out.print("Please enter the time you want to rent this type of the car: ");
        double time = in.nextDouble();
        System.out.println("");
        System.out.println("Reading data file \"CarDetails.txt\"...");
       
        
        System.out.println(" ----------------------");
        System.out.println("------_:RECIEPT:_------");
        System.out.println("");
        App app = new App(userName, carType, time);
        System.out.println(" ----------------------");
        System.out.println("|                      |");
        System.out.println("| You PAY: $" + String.format("%.2f", app.totalCost())+"     |");
        System.out.println("|                      |");
        System.out.println(" ----------------------");
        System.out.println("_Your RECEIPT_\n" + app.receipt());
        
        try (PrintWriter out = new PrintWriter("customerReceipt.txt")) {
            out.println(app.receipt());
        }
        System.out.println("______THANK YOU______");
        System.out.println("");
        System.out.println("------:RECIEPT:------");
	}
	
  
	}

