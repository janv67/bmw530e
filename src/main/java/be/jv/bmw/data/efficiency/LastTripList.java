package be.jv.bmw.data.efficiency;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_lasttriplist")
public class LastTripList implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	private String unit;

	private String lastTrip;

	private String name;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLastTrip() {
		return lastTrip;
	}

	public void setLastTrip(String lastTrip) {
		this.lastTrip = lastTrip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return new com.google.gson.Gson().toJson(this);
	}

}
