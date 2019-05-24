package CyRent;

public class Cars {
	
	
	public String carType = "";
	public Double carCost = 0.0;
	
	
	public Cars(String CarType, Double CarCost) {
		
		this.carType = CarType;
		this.carCost = CarCost;
	}
	
	public String getCarType() {
		return this.carType;
	}
	
	public Double getCarCost() {
		return this.carCost;
	}
	
}
