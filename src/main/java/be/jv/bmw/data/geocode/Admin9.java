package be.jv.bmw.data.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"wikipedia",
"wikidata",
"level",
"boundary",
"name",
"type",
"admin-level"
})
public class Admin9 {

@JsonProperty("wikipedia")
private String wikipedia;
@JsonProperty("wikidata")
private String wikidata;
@JsonProperty("level")
private String level;
@JsonProperty("boundary")
private String boundary;
@JsonProperty("name")
private String name;
@JsonProperty("type")
private String type;
@JsonProperty("admin-level")
private String adminLevel;

@JsonProperty("wikipedia")
public String getWikipedia() {
return wikipedia;
}

@JsonProperty("wikipedia")
public void setWikipedia(String wikipedia) {
this.wikipedia = wikipedia;
}

@JsonProperty("wikidata")
public String getWikidata() {
return wikidata;
}

@JsonProperty("wikidata")
public void setWikidata(String wikidata) {
this.wikidata = wikidata;
}

@JsonProperty("level")
public String getLevel() {
return level;
}

@JsonProperty("level")
public void setLevel(String level) {
this.level = level;
}

@JsonProperty("boundary")
public String getBoundary() {
return boundary;
}

@JsonProperty("boundary")
public void setBoundary(String boundary) {
this.boundary = boundary;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("admin-level")
public String getAdminLevel() {
return adminLevel;
}

@JsonProperty("admin-level")
public void setAdminLevel(String adminLevel) {
this.adminLevel = adminLevel;
}

}