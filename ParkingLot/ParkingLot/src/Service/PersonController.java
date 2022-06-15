package Service;

import java.util.List;

import Model.P_Vehicle;
import Model.Person;

public class PersonController {
	
	public Person getPerson(List<Person> persons, String name) {
		for(Person p : persons) {
			if(p.name.equals(name)) {
				return p;
			}
		}
		
		if(persons.size()>0) {
			int lastId = persons.get(persons.size()-1).id+1;
			persons.add(new Person(lastId, name));
		}else {
			persons.add(new Person(1, name));
		}
		return persons.get(persons.size()-1);
	}
	
	public P_Vehicle preparePersonEntry(List<P_Vehicle> allVehicles , Person person, Integer area) {
		if(allVehicles.size()>0) {
			int lastId = allVehicles.get(allVehicles.size()-1).id+1;
			allVehicles.add(new P_Vehicle(lastId, person.id, area));
		}else {
			allVehicles.add(new P_Vehicle(1, person.id, area));
		}
		return allVehicles.get(allVehicles.size()-1);
	}
	
}
