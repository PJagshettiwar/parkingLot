package Service;

import java.util.List;

import Model.Allotment;
import Model.ParkingLot;
import Model.Vehicle;

public class ParkingLotController {
	
	public ParkingLot createParkingLot(List<ParkingLot>  lots , String name) {
		if(lots.size()>0) {
			int lastId = lots.get(lots.size()-1).id+1;
			lots.add(new ParkingLot(lastId, name));
		}else {
			lots.add(new ParkingLot(1, name));
		}
		return lots.get(lots.size()-1);
	}
	
	public void addToCapacity(ParkingLot lot, Vehicle vehicle, List<Vehicle> uniqeVehicles) {
		lot.capacity.add(new Allotment(false, vehicle));
		if(uniqeVehicles.size()==0) {
			uniqeVehicles.add(vehicle);
		}
		boolean present=false;
		for(int i=0; i<uniqeVehicles.size();i++) {
			if(uniqeVehicles.get(i).area.equals(vehicle.area)) {
				present = true;
			}
		}
		if(!present) {
			uniqeVehicles.add(vehicle);
		}
	}
	
	public Vehicle getVehicle(List<Vehicle> uniqeVehicles, Integer area) {
		for(Vehicle v : uniqeVehicles) {
			if(v.area.equals(area)) {
				return v;
			}
		}
		return null;
	}
	
	public void removeVehicle(ParkingLot lot, Vehicle vehicle) {
		for(Allotment capacity : lot.capacity) {
			if(capacity.isAlloted==true) {
				capacity.isAlloted=false;
				capacity.vehicle = null;
				break;
			}
		}
	}
	
	public boolean addVehicle(ParkingLot lot, Vehicle vehicle) {
		for(Allotment capacity : lot.capacity) {
			if(capacity.vehicle.area.equals(vehicle.area)) {
				if(!capacity.isAlloted) {
					capacity.isAlloted=true;
					capacity.vehicle = vehicle;
					return true;
				}
			}
		}
		return false;
	}
	
	
}
