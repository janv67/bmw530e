package be.jv.bmw.data.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"wikipedia",
"wikidata",
"website",
"name-ru",
"name",
"admin-level",
"ref-INS",
"level",
"boundary",
"type"
})
public class Admin8 {

@JsonProperty("wikipedia")
private String wikipedia;
@JsonProperty("wikidata")
private String wikidata;
@JsonProperty("website")
private String website;
@JsonProperty("name-ru")
private String nameRu;
@JsonProperty("name")
private String name;
@JsonProperty("admin-level")
private String adminLevel;
@JsonProperty("ref-INS")
private String refINS;
@JsonProperty("level")
private String level;
@JsonProperty("boundary")
private String boundary;
@JsonProperty("type")
private String type;

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

@JsonProperty("website")
public String getWebsite() {
return website;
}

@JsonProperty("website")
public void setWebsite(String website) {
this.website = website;
}

@JsonProperty("name-ru")
public String getNameRu() {
return nameRu;
}

@JsonProperty("name-ru")
public void setNameRu(String nameRu) {
this.nameRu = nameRu;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("admin-level")
public String getAdminLevel() {
return adminLevel;
}

@JsonProperty("admin-level")
public void setAdminLevel(String adminLevel) {
this.adminLevel = adminLevel;
}

@JsonProperty("ref-INS")
public String getRefINS() {
return refINS;
}

@JsonProperty("ref-INS")
public void setRefINS(String refINS) {
this.refINS = refINS;
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

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

}