package be.jv.bmw.data.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"wikipedia",
"name-ru",
"admin-level",
"name-de",
"boundary",
"name-tzl",
"name-fr",
"wikidata",
"name-nl",
"official-name-nl",
"name",
"official-name",
"name-en",
"ref-INS",
"level",
"type"
})
public class Admin7 {

@JsonProperty("wikipedia")
private String wikipedia;
@JsonProperty("name-ru")
private String nameRu;
@JsonProperty("admin-level")
private String adminLevel;
@JsonProperty("name-de")
private String nameDe;
@JsonProperty("boundary")
private String boundary;
@JsonProperty("name-tzl")
private String nameTzl;
@JsonProperty("name-fr")
private String nameFr;
@JsonProperty("wikidata")
private String wikidata;
@JsonProperty("name-nl")
private String nameNl;
@JsonProperty("official-name-nl")
private String officialNameNl;
@JsonProperty("name")
private String name;
@JsonProperty("official-name")
private String officialName;
@JsonProperty("name-en")
private String nameEn;
@JsonProperty("ref-INS")
private String refINS;
@JsonProperty("level")
private String level;
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

@JsonProperty("name-ru")
public String getNameRu() {
return nameRu;
}

@JsonProperty("name-ru")
public void setNameRu(String nameRu) {
this.nameRu = nameRu;
}

@JsonProperty("admin-level")
public String getAdminLevel() {
return adminLevel;
}

@JsonProperty("admin-level")
public void setAdminLevel(String adminLevel) {
this.adminLevel = adminLevel;
}

@JsonProperty("name-de")
public String getNameDe() {
return nameDe;
}

@JsonProperty("name-de")
public void setNameDe(String nameDe) {
this.nameDe = nameDe;
}

@JsonProperty("boundary")
public String getBoundary() {
return boundary;
}

@JsonProperty("boundary")
public void setBoundary(String boundary) {
this.boundary = boundary;
}

@JsonProperty("name-tzl")
public String getNameTzl() {
return nameTzl;
}

@JsonProperty("name-tzl")
public void setNameTzl(String nameTzl) {
this.nameTzl = nameTzl;
}

@JsonProperty("name-fr")
public String getNameFr() {
return nameFr;
}

@JsonProperty("name-fr")
public void setNameFr(String nameFr) {
this.nameFr = nameFr;
}

@JsonProperty("wikidata")
public String getWikidata() {
return wikidata;
}

@JsonProperty("wikidata")
public void setWikidata(String wikidata) {
this.wikidata = wikidata;
}

@JsonProperty("name-nl")
public String getNameNl() {
return nameNl;
}

@JsonProperty("name-nl")
public void setNameNl(String nameNl) {
this.nameNl = nameNl;
}

@JsonProperty("official-name-nl")
public String getOfficialNameNl() {
return officialNameNl;
}

@JsonProperty("official-name-nl")
public void setOfficialNameNl(String officialNameNl) {
this.officialNameNl = officialNameNl;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("official-name")
public String getOfficialName() {
return officialName;
}

@JsonProperty("official-name")
public void setOfficialName(String officialName) {
this.officialName = officialName;
}

@JsonProperty("name-en")
public String getNameEn() {
return nameEn;
}

@JsonProperty("name-en")
public void setNameEn(String nameEn) {
this.nameEn = nameEn;
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

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

}