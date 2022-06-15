package Model;

import java.util.LinkedList;

public class ParkingLot{
	public Integer id;
	public String name;
	public LinkedList<Allotment> capacity = new LinkedList<>();
	
	public ParkingLot(Integer id, String name){
		this.id= id;
		this.name=name;
	}
	
	public String toString() {
		return "Lot id:"+id+" Name:"+name+" Having capacity of:"+capacity;
	}
}

