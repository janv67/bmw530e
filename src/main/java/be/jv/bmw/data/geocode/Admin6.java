package be.jv.bmw.data.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"wikipedia",
"population",
"website",
"name-ru",
"name-ca",
"border-type",
"admin-level",
"population-date",
"name-sk",
"wikipedia-fr",
"ISO3166-2",
"name-de",
"source-population",
"boundary",
"name-tzl",
"name-fr",
"wikidata",
"name-nl",
"official-name-nl",
"official-name",
"name-lt",
"name",
"ref-INS",
"name-en",
"level",
"name-es",
"type"
})
public class Admin6 {

@JsonProperty("wikipedia")
private String wikipedia;
@JsonProperty("population")
private String population;
@JsonProperty("website")
private String website;
@JsonProperty("name-ru")
private String nameRu;
@JsonProperty("name-ca")
private String nameCa;
@JsonProperty("border-type")
private String borderType;
@JsonProperty("admin-level")
private String adminLevel;
@JsonProperty("population-date")
private String populationDate;
@JsonProperty("name-sk")
private String nameSk;
@JsonProperty("wikipedia-fr")
private String wikipediaFr;
@JsonProperty("ISO3166-2")
private String iSO31662;
@JsonProperty("name-de")
private String nameDe;
@JsonProperty("source-population")
private String sourcePopulation;
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
@JsonProperty("official-name")
private String officialName;
@JsonProperty("name-lt")
private String nameLt;
@JsonProperty("name")
private String name;
@JsonProperty("ref-INS")
private String refINS;
@JsonProperty("name-en")
private String nameEn;
@JsonProperty("level")
private String level;
@JsonProperty("name-es")
private String nameEs;
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

@JsonProperty("population")
public String getPopulation() {
return population;
}

@JsonProperty("population")
public void setPopulation(String population) {
this.population = population;
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

@JsonProperty("name-ca")
public String getNameCa() {
return nameCa;
}

@JsonProperty("name-ca")
public void setNameCa(String nameCa) {
this.nameCa = nameCa;
}

@JsonProperty("border-type")
public String getBorderType() {
return borderType;
}

@JsonProperty("border-type")
public void setBorderType(String borderType) {
this.borderType = borderType;
}

@JsonProperty("admin-level")
public String getAdminLevel() {
return adminLevel;
}

@JsonProperty("admin-level")
public void setAdminLevel(String adminLevel) {
this.adminLevel = adminLevel;
}

@JsonProperty("population-date")
public String getPopulationDate() {
return populationDate;
}

@JsonProperty("population-date")
public void setPopulationDate(String populationDate) {
this.populationDate = populationDate;
}

@JsonProperty("name-sk")
public String getNameSk() {
return nameSk;
}

@JsonProperty("name-sk")
public void setNameSk(String nameSk) {
this.nameSk = nameSk;
}

@JsonProperty("wikipedia-fr")
public String getWikipediaFr() {
return wikipediaFr;
}

@JsonProperty("wikipedia-fr")
public void setWikipediaFr(String wikipediaFr) {
this.wikipediaFr = wikipediaFr;
}

@JsonProperty("ISO3166-2")
public String getISO31662() {
return iSO31662;
}

@JsonProperty("ISO3166-2")
public void setISO31662(String iSO31662) {
this.iSO31662 = iSO31662;
}

@JsonProperty("name-de")
public String getNameDe() {
return nameDe;
}

@JsonProperty("name-de")
public void setNameDe(String nameDe) {
this.nameDe = nameDe;
}

@JsonProperty("source-population")
public String getSourcePopulation() {
return sourcePopulation;
}

@JsonProperty("source-population")
public void setSourcePopulation(String sourcePopulation) {
this.sourcePopulation = sourcePopulation;
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

@JsonProperty("official-name")
public String getOfficialName() {
return officialName;
}

@JsonProperty("official-name")
public void setOfficialName(String officialName) {
this.officialName = officialName;
}

@JsonProperty("name-lt")
public String getNameLt() {
return nameLt;
}

@JsonProperty("name-lt")
public void setNameLt(String nameLt) {
this.nameLt = nameLt;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("ref-INS")
public String getRefINS() {
return refINS;
}

@JsonProperty("ref-INS")
public void setRefINS(String refINS) {
this.refINS = refINS;
}

@JsonProperty("name-en")
public String getNameEn() {
return nameEn;
}

@JsonProperty("name-en")
public void setNameEn(String nameEn) {
this.nameEn = nameEn;
}

@JsonProperty("level")
public String getLevel() {
return level;
}

@JsonProperty("level")
public void setLevel(String level) {
this.level = level;
}

@JsonProperty("name-es")
public String getNameEs() {
return nameEs;
}

@JsonProperty("name-es")
public void setNameEs(String nameEs) {
this.nameEs = nameEs;
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