package Model;

public class Vehicle {
	
	public Integer area;
	public Integer rate;
	
	public Vehicle(Integer area, Integer rate){
		this.rate=rate;
		this.area=area;
	}
	
	public String toString() {
		return "area :"+area+" rate:"+rate;
	}

}