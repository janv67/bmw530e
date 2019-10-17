package be.jv.bmw.data.efficiency;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_efficiency")
public class Efficiency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String date="";
	private String time="";
	
	@OrderColumn(name = "characteristic_list")
	@OneToMany(cascade=CascadeType.ALL)
	@ElementCollection	
	private CharacteristicList[] characteristicList;

	@OrderColumn(name = "life_time_list")
	@OneToMany(cascade=CascadeType.ALL)
	@ElementCollection	
	private LifeTimeList[] lifeTimeList;

	@OrderColumn(name = "last_trip_list")
	@OneToMany(cascade=CascadeType.ALL)
	@ElementCollection	
	private LastTripList[] lastTripList;

	private String modelType;

	private String efficiencyQuotient;

	public CharacteristicList[] getCharacteristicList() {
		return characteristicList;
	}

	public void setCharacteristicList(CharacteristicList[] characteristicList) {
		this.characteristicList = characteristicList;
	}

	public LifeTimeList[] getLifeTimeList() {
		return lifeTimeList;
	}

	public void setLifeTimeList(LifeTimeList[] lifeTimeList) {
		this.lifeTimeList = lifeTimeList;
	}

	public LastTripList[] getLastTripList() {
		return lastTripList;
	}

	public void setLastTripList(LastTripList[] lastTripList) {
		this.lastTripList = lastTripList;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getEfficiencyQuotient() {
		return efficiencyQuotient;
	}

	public void setEfficiencyQuotient(String efficiencyQuotient) {
		this.efficiencyQuotient = efficiencyQuotient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString(){
		return new com.google.gson.Gson().toJson(this);
	}


}
