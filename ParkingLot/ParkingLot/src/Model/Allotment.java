package Model;

public class Allotment{
	public boolean isAlloted;
	public Vehicle vehicle;
	
	public Allotment(boolean isAlloted, Vehicle vehicle){
		this.isAlloted= isAlloted;
		this.vehicle=vehicle;
	}
	
	public String toString() {
		return "Vehicle :"+vehicle+" isAlloted:"+isAlloted;
	}
}

