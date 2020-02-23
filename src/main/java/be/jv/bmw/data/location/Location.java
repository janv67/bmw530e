package be.jv.bmw.data.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_location")
public class Location {
	public Location(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Location(double latitude, double longitude, String isoCountryCode, double auxPowerRegular,
			double auxPowerEcoPro, double auxPowerEcoProPlus, double soc, double socMax, boolean pendingUpdate,
			boolean vehicleTracking) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.isoCountryCode = isoCountryCode;
		this.auxPowerRegular = auxPowerRegular;
		this.auxPowerEcoPro = auxPowerEcoPro;
		this.auxPowerEcoProPlus = auxPowerEcoProPlus;
		this.soc = soc;
		this.socMax = socMax;
		this.pendingUpdate = pendingUpdate;
		this.vehicleTracking = vehicleTracking;
	}
	public Location() {
		super();
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String date="";
	private String time="";
	private double latitude;
	private double longitude;
	private String isoCountryCode ="";
	private double auxPowerRegular;
	private double auxPowerEcoPro;
	private double auxPowerEcoProPlus;
	private double soc;
	private double socMax;
	private boolean pendingUpdate;
	private boolean vehicleTracking;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getIsoCountryCode() {
		return isoCountryCode;
	}
	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}
	public double getAuxPowerRegular() {
		return auxPowerRegular;
	}
	public void setAuxPowerRegular(double auxPowerRegular) {
		this.auxPowerRegular = auxPowerRegular;
	}
	public double getAuxPowerEcoPro() {
		return auxPowerEcoPro;
	}
	public void setAuxPowerEcoPro(double auxPowerEcoPro) {
		this.auxPowerEcoPro = auxPowerEcoPro;
	}
	public double getAuxPowerEcoProPlus() {
		return auxPowerEcoProPlus;
	}
	public void setAuxPowerEcoProPlus(double auxPowerEcoProPlus) {
		this.auxPowerEcoProPlus = auxPowerEcoProPlus;
	}
	public double getSoc() {
		return soc;
	}
	public void setSoc(double soc) {
		this.soc = soc;
	}
	public double getSocMax() {
		return socMax;
	}
	public void setSocMax(double socMax) {
		this.socMax = socMax;
	}
	public boolean isPendingUpdate() {
		return pendingUpdate;
	}
	public void setPendingUpdate(boolean pendingUpdate) {
		this.pendingUpdate = pendingUpdate;
	}
	public boolean isVehicleTracking() {
		return vehicleTracking;
	}
	public void setVehicleTracking(boolean vehicleTracking) {
		this.vehicleTracking = vehicleTracking;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString(){
		return new com.google.gson.Gson().toJson(this);
	}

}
