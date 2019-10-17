package be.jv.bmw.data.dynamic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_attributesmap")
public class AttributesMap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	  private String updateTime_converted;
	  private String shdStatusUnified;
	  private String condition_based_services;
	  private String door_lock_state;
	  private String vehicle_tracking;
	  private String Segment_LastTrip_time_segment_end_formatted_time;
	  private String lastChargingEndReason;
	  private String door_passenger_front;
	  private String charging_inductive_positioning;
	  private String check_control_messages;
	  private String beMaxRangeElectricMile;
	  private String chargingHVStatus;
	  private String lights_parking;
	  private String beRemainingRangeFuelKm;
	  private String connectorStatus;
	  private String kombi_current_remaining_range_fuel;
	  private String beRemainingRangeElectricMile;
	  private String window_passenger_front;
	  private String mileage;
	  private String door_driver_front;
	  private String updateTime;
	  private String window_passenger_rear;
	  private String Segment_LastTrip_time_segment_end;
	  private String remaining_fuel;
	  private String updateTime_converted_time;
	  private String window_driver_front;
	  private String chargeNowAllowed;
	  private String chargingTimeRemaining;
	  private String unitOfCombustionConsumption;
	  private String beMaxRangeElectric;
	  private String soc_hv_percent;
	  private String single_immediate_charging;
	  private String beRemainingRangeElectric;
	  private String heading;
	  private String DCS_CCH_Ongoing  = null;
	  private String sunroof_state;
	  private String charging_connection_type;
	  private String Segment_LastTrip_time_segment_end_formatted;
	  private String updateTime_converted_timestamp;
	  private String gps_lat;
	  private String window_driver_rear;
	  private String lastChargingEndResult;
	  private String trunk_state;
	  private String hood_state;
	  private String chargingLevelHv;
	  private String lastUpdateReason;
	  private String beRemainingRangeFuel;
	  private String sunroof_position;
	  private String lsc_trigger;
	  private String unitOfEnergy;
	  private String Segment_LastTrip_time_segment_end_formatted_date;
	  private String prognosisWhileChargingStatus;
	  private String beMaxRangeElectricKm;
	  private String unitOfElectricConsumption;
	  private String Segment_LastTrip_ratio_electric_driven_distance;
	  private String head_unit_pu_software;
	  private String DCS_CCH_Activation = null;
	  private String head_unit;
	  private String chargingSystemStatus;
	  private String door_driver_rear;
	  private String charging_status;
	  private String beRemainingRangeFuelMile;
	  private String beRemainingRangeElectricKm;
	  private String gps_lng;
	  private String door_passenger_rear;
	  private String updateTime_converted_date;
	  private String unitOfLength;
	  private String chargingLogicCurrentlyActive;
	  private String battery_size_max;


	 // Getter Methods 

	  public String getUpdateTime_converted() {
	    return updateTime_converted;
	  }

	  public String getShdStatusUnified() {
	    return shdStatusUnified;
	  }

	  public String getCondition_based_services() {
	    return condition_based_services;
	  }

	  public String getDoor_lock_state() {
	    return door_lock_state;
	  }

	  public String getVehicle_tracking() {
	    return vehicle_tracking;
	  }

	  public String getSegment_LastTrip_time_segment_end_formatted_time() {
	    return Segment_LastTrip_time_segment_end_formatted_time;
	  }

	  public String getLastChargingEndReason() {
	    return lastChargingEndReason;
	  }

	  public String getDoor_passenger_front() {
	    return door_passenger_front;
	  }

	  public String getCharging_inductive_positioning() {
	    return charging_inductive_positioning;
	  }

	  public String getCheck_control_messages() {
	    return check_control_messages;
	  }

	  public String getBeMaxRangeElectricMile() {
	    return beMaxRangeElectricMile;
	  }

	  public String getChargingHVStatus() {
	    return chargingHVStatus;
	  }

	  public String getLights_parking() {
	    return lights_parking;
	  }

	  public String getBeRemainingRangeFuelKm() {
	    return beRemainingRangeFuelKm;
	  }

	  public String getConnectorStatus() {
	    return connectorStatus;
	  }

	  public String getKombi_current_remaining_range_fuel() {
	    return kombi_current_remaining_range_fuel;
	  }

	  public String getBeRemainingRangeElectricMile() {
	    return beRemainingRangeElectricMile;
	  }

	  public String getWindow_passenger_front() {
	    return window_passenger_front;
	  }

	  public String getMileage() {
	    return mileage;
	  }

	  public String getDoor_driver_front() {
	    return door_driver_front;
	  }

	  public String getUpdateTime() {
	    return updateTime;
	  }

	  public String getWindow_passenger_rear() {
	    return window_passenger_rear;
	  }

	  public String getSegment_LastTrip_time_segment_end() {
	    return Segment_LastTrip_time_segment_end;
	  }

	  public String getRemaining_fuel() {
	    return remaining_fuel;
	  }

	  public String getUpdateTime_converted_time() {
	    return updateTime_converted_time;
	  }

	  public String getWindow_driver_front() {
	    return window_driver_front;
	  }

	  public String getChargeNowAllowed() {
	    return chargeNowAllowed;
	  }

	  public String getChargingTimeRemaining() {
	    return chargingTimeRemaining;
	  }

	  public String getUnitOfCombustionConsumption() {
	    return unitOfCombustionConsumption;
	  }

	  public String getBeMaxRangeElectric() {
	    return beMaxRangeElectric;
	  }

	  public String getSoc_hv_percent() {
	    return soc_hv_percent;
	  }

	  public String getSingle_immediate_charging() {
	    return single_immediate_charging;
	  }

	  public String getBeRemainingRangeElectric() {
	    return beRemainingRangeElectric;
	  }

	  public String getHeading() {
	    return heading;
	  }

	  public String getDCS_CCH_Ongoing () {
	    return DCS_CCH_Ongoing ;
	  }

	  public String getSunroof_state() {
	    return sunroof_state;
	  }

	  public String getCharging_connection_type() {
	    return charging_connection_type;
	  }

	  public String getSegment_LastTrip_time_segment_end_formatted() {
	    return Segment_LastTrip_time_segment_end_formatted;
	  }

	  public String getUpdateTime_converted_timestamp() {
	    return updateTime_converted_timestamp;
	  }

	  public String getGps_lat() {
	    return gps_lat;
	  }

	  public String getWindow_driver_rear() {
	    return window_driver_rear;
	  }

	  public String getLastChargingEndResult() {
	    return lastChargingEndResult;
	  }

	  public String getTrunk_state() {
	    return trunk_state;
	  }

	  public String getHood_state() {
	    return hood_state;
	  }

	  public String getChargingLevelHv() {
	    return chargingLevelHv;
	  }

	  public String getLastUpdateReason() {
	    return lastUpdateReason;
	  }

	  public String getBeRemainingRangeFuel() {
	    return beRemainingRangeFuel;
	  }

	  public String getSunroof_position() {
	    return sunroof_position;
	  }

	  public String getLsc_trigger() {
	    return lsc_trigger;
	  }

	  public String getUnitOfEnergy() {
	    return unitOfEnergy;
	  }

	  public String getSegment_LastTrip_time_segment_end_formatted_date() {
	    return Segment_LastTrip_time_segment_end_formatted_date;
	  }

	  public String getPrognosisWhileChargingStatus() {
	    return prognosisWhileChargingStatus;
	  }

	  public String getBeMaxRangeElectricKm() {
	    return beMaxRangeElectricKm;
	  }

	  public String getUnitOfElectricConsumption() {
	    return unitOfElectricConsumption;
	  }

	  public String getSegment_LastTrip_ratio_electric_driven_distance() {
	    return Segment_LastTrip_ratio_electric_driven_distance;
	  }

	  public String getHead_unit_pu_software() {
	    return head_unit_pu_software;
	  }

	  public String getDCS_CCH_Activation() {
	    return DCS_CCH_Activation;
	  }

	  public String getHead_unit() {
	    return head_unit;
	  }

	  public String getChargingSystemStatus() {
	    return chargingSystemStatus;
	  }

	  public String getDoor_driver_rear() {
	    return door_driver_rear;
	  }

	  public String getCharging_status() {
	    return charging_status;
	  }

	  public String getBeRemainingRangeFuelMile() {
	    return beRemainingRangeFuelMile;
	  }

	  public String getBeRemainingRangeElectricKm() {
	    return beRemainingRangeElectricKm;
	  }

	  public String getGps_lng() {
	    return gps_lng;
	  }

	  public String getDoor_passenger_rear() {
	    return door_passenger_rear;
	  }

	  public String getUpdateTime_converted_date() {
	    return updateTime_converted_date;
	  }

	  public String getUnitOfLength() {
	    return unitOfLength;
	  }

	  public String getChargingLogicCurrentlyActive() {
	    return chargingLogicCurrentlyActive;
	  }

	  public String getBattery_size_max() {
	    return battery_size_max;
	  }

	 // Setter Methods 

	  public void setUpdateTime_converted( String updateTime_converted ) {
	    this.updateTime_converted = updateTime_converted;
	  }

	  public void setShdStatusUnified( String shdStatusUnified ) {
	    this.shdStatusUnified = shdStatusUnified;
	  }

	  public void setCondition_based_services( String condition_based_services ) {
	    this.condition_based_services = condition_based_services;
	  }

	  public void setDoor_lock_state( String door_lock_state ) {
	    this.door_lock_state = door_lock_state;
	  }

	  public void setVehicle_tracking( String vehicle_tracking ) {
	    this.vehicle_tracking = vehicle_tracking;
	  }

	  public void setSegment_LastTrip_time_segment_end_formatted_time( String Segment_LastTrip_time_segment_end_formatted_time ) {
	    this.Segment_LastTrip_time_segment_end_formatted_time = Segment_LastTrip_time_segment_end_formatted_time;
	  }

	  public void setLastChargingEndReason( String lastChargingEndReason ) {
	    this.lastChargingEndReason = lastChargingEndReason;
	  }

	  public void setDoor_passenger_front( String door_passenger_front ) {
	    this.door_passenger_front = door_passenger_front;
	  }

	  public void setCharging_inductive_positioning( String charging_inductive_positioning ) {
	    this.charging_inductive_positioning = charging_inductive_positioning;
	  }

	  public void setCheck_control_messages( String check_control_messages ) {
	    this.check_control_messages = check_control_messages;
	  }

	  public void setBeMaxRangeElectricMile( String beMaxRangeElectricMile ) {
	    this.beMaxRangeElectricMile = beMaxRangeElectricMile;
	  }

	  public void setChargingHVStatus( String chargingHVStatus ) {
	    this.chargingHVStatus = chargingHVStatus;
	  }

	  public void setLights_parking( String lights_parking ) {
	    this.lights_parking = lights_parking;
	  }

	  public void setBeRemainingRangeFuelKm( String beRemainingRangeFuelKm ) {
	    this.beRemainingRangeFuelKm = beRemainingRangeFuelKm;
	  }

	  public void setConnectorStatus( String connectorStatus ) {
	    this.connectorStatus = connectorStatus;
	  }

	  public void setKombi_current_remaining_range_fuel( String kombi_current_remaining_range_fuel ) {
	    this.kombi_current_remaining_range_fuel = kombi_current_remaining_range_fuel;
	  }

	  public void setBeRemainingRangeElectricMile( String beRemainingRangeElectricMile ) {
	    this.beRemainingRangeElectricMile = beRemainingRangeElectricMile;
	  }

	  public void setWindow_passenger_front( String window_passenger_front ) {
	    this.window_passenger_front = window_passenger_front;
	  }

	  public void setMileage( String mileage ) {
	    this.mileage = mileage;
	  }

	  public void setDoor_driver_front( String door_driver_front ) {
	    this.door_driver_front = door_driver_front;
	  }

	  public void setUpdateTime( String updateTime ) {
	    this.updateTime = updateTime;
	  }

	  public void setWindow_passenger_rear( String window_passenger_rear ) {
	    this.window_passenger_rear = window_passenger_rear;
	  }

	  public void setSegment_LastTrip_time_segment_end( String Segment_LastTrip_time_segment_end ) {
	    this.Segment_LastTrip_time_segment_end = Segment_LastTrip_time_segment_end;
	  }

	  public void setRemaining_fuel( String remaining_fuel ) {
	    this.remaining_fuel = remaining_fuel;
	  }

	  public void setUpdateTime_converted_time( String updateTime_converted_time ) {
	    this.updateTime_converted_time = updateTime_converted_time;
	  }

	  public void setWindow_driver_front( String window_driver_front ) {
	    this.window_driver_front = window_driver_front;
	  }

	  public void setChargeNowAllowed( String chargeNowAllowed ) {
	    this.chargeNowAllowed = chargeNowAllowed;
	  }

	  public void setChargingTimeRemaining( String chargingTimeRemaining ) {
	    this.chargingTimeRemaining = chargingTimeRemaining;
	  }

	  public void setUnitOfCombustionConsumption( String unitOfCombustionConsumption ) {
	    this.unitOfCombustionConsumption = unitOfCombustionConsumption;
	  }

	  public void setBeMaxRangeElectric( String beMaxRangeElectric ) {
	    this.beMaxRangeElectric = beMaxRangeElectric;
	  }

	  public void setSoc_hv_percent( String soc_hv_percent ) {
	    this.soc_hv_percent = soc_hv_percent;
	  }

	  public void setSingle_immediate_charging( String single_immediate_charging ) {
	    this.single_immediate_charging = single_immediate_charging;
	  }

	  public void setBeRemainingRangeElectric( String beRemainingRangeElectric ) {
	    this.beRemainingRangeElectric = beRemainingRangeElectric;
	  }

	  public void setHeading( String heading ) {
	    this.heading = heading;
	  }

	  public void setDCS_CCH_Ongoing ( String DCS_CCH_Ongoing  ) {
	    this.DCS_CCH_Ongoing  = DCS_CCH_Ongoing ;
	  }

	  public void setSunroof_state( String sunroof_state ) {
	    this.sunroof_state = sunroof_state;
	  }

	  public void setCharging_connection_type( String charging_connection_type ) {
	    this.charging_connection_type = charging_connection_type;
	  }

	  public void setSegment_LastTrip_time_segment_end_formatted( String Segment_LastTrip_time_segment_end_formatted ) {
	    this.Segment_LastTrip_time_segment_end_formatted = Segment_LastTrip_time_segment_end_formatted;
	  }

	  public void setUpdateTime_converted_timestamp( String updateTime_converted_timestamp ) {
	    this.updateTime_converted_timestamp = updateTime_converted_timestamp;
	  }

	  public void setGps_lat( String gps_lat ) {
	    this.gps_lat = gps_lat;
	  }

	  public void setWindow_driver_rear( String window_driver_rear ) {
	    this.window_driver_rear = window_driver_rear;
	  }

	  public void setLastChargingEndResult( String lastChargingEndResult ) {
	    this.lastChargingEndResult = lastChargingEndResult;
	  }

	  public void setTrunk_state( String trunk_state ) {
	    this.trunk_state = trunk_state;
	  }

	  public void setHood_state( String hood_state ) {
	    this.hood_state = hood_state;
	  }

	  public void setChargingLevelHv( String chargingLevelHv ) {
	    this.chargingLevelHv = chargingLevelHv;
	  }

	  public void setLastUpdateReason( String lastUpdateReason ) {
	    this.lastUpdateReason = lastUpdateReason;
	  }

	  public void setBeRemainingRangeFuel( String beRemainingRangeFuel ) {
	    this.beRemainingRangeFuel = beRemainingRangeFuel;
	  }

	  public void setSunroof_position( String sunroof_position ) {
	    this.sunroof_position = sunroof_position;
	  }

	  public void setLsc_trigger( String lsc_trigger ) {
	    this.lsc_trigger = lsc_trigger;
	  }

	  public void setUnitOfEnergy( String unitOfEnergy ) {
	    this.unitOfEnergy = unitOfEnergy;
	  }

	  public void setSegment_LastTrip_time_segment_end_formatted_date( String Segment_LastTrip_time_segment_end_formatted_date ) {
	    this.Segment_LastTrip_time_segment_end_formatted_date = Segment_LastTrip_time_segment_end_formatted_date;
	  }

	  public void setPrognosisWhileChargingStatus( String prognosisWhileChargingStatus ) {
	    this.prognosisWhileChargingStatus = prognosisWhileChargingStatus;
	  }

	  public void setBeMaxRangeElectricKm( String beMaxRangeElectricKm ) {
	    this.beMaxRangeElectricKm = beMaxRangeElectricKm;
	  }

	  public void setUnitOfElectricConsumption( String unitOfElectricConsumption ) {
	    this.unitOfElectricConsumption = unitOfElectricConsumption;
	  }

	  public void setSegment_LastTrip_ratio_electric_driven_distance( String Segment_LastTrip_ratio_electric_driven_distance ) {
	    this.Segment_LastTrip_ratio_electric_driven_distance = Segment_LastTrip_ratio_electric_driven_distance;
	  }

	  public void setHead_unit_pu_software( String head_unit_pu_software ) {
	    this.head_unit_pu_software = head_unit_pu_software;
	  }

	  public void setDCS_CCH_Activation( String DCS_CCH_Activation ) {
	    this.DCS_CCH_Activation = DCS_CCH_Activation;
	  }

	  public void setHead_unit( String head_unit ) {
	    this.head_unit = head_unit;
	  }

	  public void setChargingSystemStatus( String chargingSystemStatus ) {
	    this.chargingSystemStatus = chargingSystemStatus;
	  }

	  public void setDoor_driver_rear( String door_driver_rear ) {
	    this.door_driver_rear = door_driver_rear;
	  }

	  public void setCharging_status( String charging_status ) {
	    this.charging_status = charging_status;
	  }

	  public void setBeRemainingRangeFuelMile( String beRemainingRangeFuelMile ) {
	    this.beRemainingRangeFuelMile = beRemainingRangeFuelMile;
	  }

	  public void setBeRemainingRangeElectricKm( String beRemainingRangeElectricKm ) {
	    this.beRemainingRangeElectricKm = beRemainingRangeElectricKm;
	  }

	  public void setGps_lng( String gps_lng ) {
	    this.gps_lng = gps_lng;
	  }

	  public void setDoor_passenger_rear( String door_passenger_rear ) {
	    this.door_passenger_rear = door_passenger_rear;
	  }

	  public void setUpdateTime_converted_date( String updateTime_converted_date ) {
	    this.updateTime_converted_date = updateTime_converted_date;
	  }

	  public void setUnitOfLength( String unitOfLength ) {
	    this.unitOfLength = unitOfLength;
	  }

	  public void setChargingLogicCurrentlyActive( String chargingLogicCurrentlyActive ) {
	    this.chargingLogicCurrentlyActive = chargingLogicCurrentlyActive;
	  }

	  public void setBattery_size_max( String battery_size_max ) {
	    this.battery_size_max = battery_size_max;
	  }
	}
