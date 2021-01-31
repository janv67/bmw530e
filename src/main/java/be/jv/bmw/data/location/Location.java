package be.jv.bmw.data.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_location")
public class Location {
	public Location(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Location(String latitude, String longitude, String isoCountryCode, double auxPowerRegular,
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
    private String latitude;
	private String longitude;
	private String isoCountryCode ="";
	private double auxPowerRegular;
	private double auxPowerEcoPro;
	private double auxPowerEcoProPlus;
	private double soc;
	private double socMax;
	private boolean pendingUpdate;
	private boolean vehicleTracking;
	
	private String geo_city;
	private String geo_street;
	private String geo_number;
	private String geo_postal;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
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
	public String getGeo_city() {
		return geo_city;
	}
	public void setGeo_city(String geo_city) {
		this.geo_city = geo_city;
	}
	public String getGeo_street() {
		return geo_street;
	}
	public void setGeo_street(String geo_street) {
		this.geo_street = geo_street;
	}
	public String getGeo_number() {
		return geo_number;
	}
	public void setGeo_number(String geo_number) {
		this.geo_number = geo_number;
	}
	public String getGeo_postal() {
		return geo_postal;
	}
	public void setGeo_postal(String geo_postal) {
		this.geo_postal = geo_postal;
	}

}
