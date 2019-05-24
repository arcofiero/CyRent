package CyRent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class DBConnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		if (args.length == 0)
	      {   
	         System.out.println(
	               "Usage: java -classpath driver_class_path" 
	               + File.pathSeparator 
	               + ". TestDB propertiesFile");
	         return;
	      }

	      SimpleDataSource.init(args[0]);
		
	    //Create a connection to the database
	      try (Connection connection = SimpleDataSource.getConnection())//use try because we want to be sure to be sure to close the resource even if there is an exception 
	      {
	         Statement stat = connection.createStatement();
	         
	         // Construct the Scanner and PrintWriter objects for reading and writing
	         String inputFileName = "renters_test.txt"; //TODO: We need a text file with our customers information
	         File inputFile = new File(inputFileName);
	         Scanner in = new Scanner(inputFile);

	         // Creating Arraylists with bd info 
	         
	         ArrayList<String> RenterFirstName = new ArrayList<String>(); //Use to be productCodes
	         ArrayList<String> RenterLastName = new ArrayList<String>(); //use to be descriptions
	         ArrayList<String> RetnerUserName = new ArrayList<String>(); //use to be prices
	         
	        //read in line by line from inputfile 
	         while (in.hasNextLine())
	         {
	        	String firstName = in.nextLine(); 
	        	String lastName = in.nextLine();
	        	String userName = in.nextLine();
	        	
	        	RenterFirstName.add(firstName);
	        	RenterLastName.add(lastName);
	        	RetnerUserName.add(userName);
	         }
	         
	         //Array List Over close time 
	         
	         in.close();
	         
	         
	         
	         //Create a table for Renters 
	         
	         stat.execute("CREATE TABLE Renters (Renter_First_Name VARCHAR(40), Renter_Last_Name VARCHAR(40), Renter_User_Name VARCHAR(40))");
	         //for loop to go over each element in the arrayList
	         for(int i=0; i<RenterLastName.size(); i++){
	        	 // How it should look: INSERT INTO Product VALUES ('John','Doe','JohnDoe99')
	        	 stat.execute("INSERT INTO Renters VALUES ('" + RenterFirstName.get(i) +"', '" + RenterLastName.get(i) + "'," + RetnerUserName.get(i) +")");
	         }
	         
	         String fm = "John";
	         String query = "SELECT * FROM Renters WHERE Renter_First_Name " + fm;
	    	 ResultSet result = stat.executeQuery(query);

	      
	    	 while(result.next()){ //Use the next method to move to the next row. If there is a new row to read, true.
	         	 for(int i=1; i<=3; i++){
	         		 System.out.print(result + "\t");
	         	 }
	         	 
	         	System.out.println();
	          }
	          result.close(); // Close the current ResultSet before issuing a new query on the same  statement
	         
	         //stat.execute("DROP TABLE Renter"); 
	      
	      
	      }

}
}

