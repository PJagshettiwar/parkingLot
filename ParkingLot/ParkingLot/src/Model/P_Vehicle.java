package Model;

import java.util.Date;

public class P_Vehicle {
	public Integer id;
	public Integer person_id;
	public Date startTime;
	public Date endTime;
	public Integer amoutPaid;
	public Integer area;
	
	public P_Vehicle(Integer id, Integer person_id, Integer area) {
		this.id=id;
		this.person_id=person_id;
		this.area=area;
		this.startTime = new Date();
	}
}
