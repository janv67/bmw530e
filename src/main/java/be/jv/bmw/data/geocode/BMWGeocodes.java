package be.jv.bmw.data.geocode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_geocode")
public class BMWGeocodes {
	public BMWGeocodes(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public BMWGeocodes() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String latitude;
	private String longitude;
	private String geonumber;
	private String staddress;
	private String stnumber;
	private String postal;
	private String city;
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String toString(){
		return new com.google.gson.Gson().toJson(this);
	}
	public String getGeonumber() {
		return geonumber;
	}
	public void setGeonumber(String geonumber) {
		this.geonumber = geonumber;
	}
	public String getStaddress() {
		return staddress;
	}
	public void setStaddress(String staddress) {
		this.staddress = staddress;
	}
	public String getStnumber() {
		return stnumber;
	}
	public void setStnumber(String stnumber) {
		this.stnumber = stnumber;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
