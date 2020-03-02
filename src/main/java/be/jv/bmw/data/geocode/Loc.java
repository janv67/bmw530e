package be.jv.bmw.data.geocode;

public class Loc {
	private String staddress;
	private String stnumber;
	private String postal;
	private String latt;
	private String city;
	private String prov;
	private String longt;

	public String getStaddress() {
		return staddress;
	}

	public void setStaddress(String input) {
		this.staddress = input;
	}

	public String getStnumber() {
		return stnumber;
	}

	public void setStnumber(String input) {
		this.stnumber = input;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String input) {
		this.postal = input;
	}

	public String getLatt() {
		return latt;
	}

	public void setLatt(String input) {
		this.latt = input;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String input) {
		this.city = input;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String input) {
		this.prov = input;
	}

	public String getLongt() {
		return longt;
	}

	public void setLongt(String input) {
		this.longt = input;
	}

}
