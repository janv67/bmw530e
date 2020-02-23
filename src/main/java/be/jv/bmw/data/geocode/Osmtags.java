package be.jv.bmw.data.geocode;

public class Osmtags{
	  private String wikipedia; 
	  private String wikidata; 
	  private String boundary; 
	  private String name; 
	  private String type; 
	  private String adminLevel; 

	  public String getWikipedia(){
	  	return wikipedia; 
	  }
	  public void setWikipedia(String input){
	  	 this.wikipedia = input;
	  }
	  public String getWikidata(){
	  	return wikidata; 
	  }
	  public void setWikidata(String input){
	  	 this.wikidata = input;
	  }
	  public String getBoundary(){
	  	return boundary; 
	  }
	  public void setBoundary(String input){
	  	 this.boundary = input;
	  }
	  public String getName(){
	  	return name; 
	  }
	  public void setName(String input){
	  	 this.name = input;
	  }
	  public String getType(){
	  	return type; 
	  }
	  public void setType(String input){
	  	 this.type = input;
	  }
	  public String getAdminLevel(){
	  	return adminLevel; 
	  }
	  public void setAdminLevel(String input){
	  	 this.adminLevel = input;
	  }
}
