import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.P_Vehicle;
import Model.ParkingLot;
import Model.Person;
import Model.Vehicle;
import Service.ParkingLotController;
import Service.PersonController;

public class WorkFlow {
	
	static ParkingLotController parkingController = new ParkingLotController();
	static PersonController personController = new PersonController();
	static List<ParkingLot>  lots = new ArrayList<>();
	static ArrayList<Person> persons = new ArrayList<>();
	static List<Vehicle> uniqeVehicles = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Add Parking lot
		int area=0;
		int rate=0;
		
		while(true) {
			System.out.println("Please provide new Parking lot name:");
			ParkingLot lot = parkingController.createParkingLot(lots, sc.next());
			System.out.println("Please add vehicles capacity");
			while(true) {
				System.out.println("Please add Vehicle area and rate:");
				area = sc.nextInt();
				rate = sc.nextInt();
				parkingController.addToCapacity(lot,new Vehicle(area, rate), uniqeVehicles);
				System.out.println("Do you want to add more capacity?");
				if(sc.next().equals("N")) {
					break;
				}
			}
			System.out.println("Do you want to add more Parking lots:");
			if(sc.next().equals("N")) {
				break;
			}
		}
		System.out.println(lots);
		System.out.println("------------");
		System.out.println("------------");
		String name;
		List<P_Vehicle> allVehicles =  new ArrayList<>();
		
		while(true) {
			System.out.println("Do we have new Vehicle Entry");
			if(sc.next().equals("Y")) {
				System.out.println("What is Name and Area of the Vehicle");
				name = sc.next();
				area = sc.nextInt();
				Person person = personController.getPerson(persons, name);
				P_Vehicle newEntry = personController.preparePersonEntry(allVehicles, person, area);
				
				Vehicle v = parkingController.getVehicle(uniqeVehicles, area);
				parkingController.addVehicle(lots.get(0), v);
				
			}
		}
		
		
		

	}

}
