package be.jv.bmw.data.geocode;
public class Intersection{
	  private String distance; 
	  private String xlat; 
	  private String xlon; 
	  private String street2; 
	  private String street1; 

	  public String getDistance(){
	  	return distance; 
	  }
	  public void setDistance(String input){
	  	 this.distance = input;
	  }
	  public String getXlat(){
	  	return xlat; 
	  }
	  public void setXlat(String input){
	  	 this.xlat = input;
	  }
	  public String getXlon(){
	  	return xlon; 
	  }
	  public void setXlon(String input){
	  	 this.xlon = input;
	  }
	  public String getStreet2(){
	  	return street2; 
	  }
	  public void setStreet2(String input){
	  	 this.street2 = input;
	  }
	  public String getStreet1(){
	  	return street1; 
	  }
	  public void setStreet1(String input){
	  	 this.street1 = input;
	  }
}