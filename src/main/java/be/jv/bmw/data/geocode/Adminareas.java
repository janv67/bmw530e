package be.jv.bmw.data.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"admin7",
"admin6",
"admin9",
"admin8"
})
public class Adminareas {

@JsonProperty("admin7")
private Admin7 admin7;
@JsonProperty("admin6")
private Admin6 admin6;
@JsonProperty("admin9")
private Admin9 admin9;
@JsonProperty("admin8")
private Admin8 admin8;

@JsonProperty("admin7")
public Admin7 getAdmin7() {
return admin7;
}

@JsonProperty("admin7")
public void setAdmin7(Admin7 admin7) {
this.admin7 = admin7;
}

@JsonProperty("admin6")
public Admin6 getAdmin6() {
return admin6;
}

@JsonProperty("admin6")
public void setAdmin6(Admin6 admin6) {
this.admin6 = admin6;
}

@JsonProperty("admin9")
public Admin9 getAdmin9() {
return admin9;
}

@JsonProperty("admin9")
public void setAdmin9(Admin9 admin9) {
this.admin9 = admin9;
}

@JsonProperty("admin8")
public Admin8 getAdmin8() {
return admin8;
}

@JsonProperty("admin8")
public void setAdmin8(Admin8 admin8) {
this.admin8 = admin8;
}

}