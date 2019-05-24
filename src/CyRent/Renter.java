package CyRent;

public class Renter {
	private String name = "";
	private String userName= "";
	
	public Renter(String name,String userName) {
		this.name = name;
		this.userName = userName;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getUserName() {
		return userName;
	}
}
