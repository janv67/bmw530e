package be.jv.bmw.controller;

public class CarController {
	private static String ClaxonURL = "/remoteservices/rsapi/v1/WBAJA91010B306212/RHB";
	// response
	// {"eventId":{"eventId":"02fe083c-e111-4897-83dd-22e8d26ebd4e"},"vin":"WBAJA91010B306212","creationTime":"2020-03-29T12:33:40.293+0000"}
	
	// Lights
	// /remoteservices/rsapi/v1/WBAJA91010B306212/RLF
	// response
	// {"eventId":{"eventId":"774b7487-661d-472c-ba3f-1a3a38797b24"},"vin":"WBAJA91010B306212","creationTime":"2020-03-29T12:37:38.463+0000"}
	
	// Vergrendelen
	// /remoteservices/rsapi/v1/WBAJA91010B306212/RDL
	// response
	// {"eventId":{"eventId":"66299d63-c02f-4940-8b06-a8bdde66dc8b"},"vin":"WBAJA91010B306212","creationTime":"2020-03-29T12:39:13.499+0000"}
	
	// History request
	// /remoteservices/rsapi/v1/WBAJA91010B306212/history
	// response
	// {"events":[{"eventId":"66299d63-c02f-4940-8b06-a8bdde66dc8b","ngtpEventId":"423330363231322613537100@bmw.de","rsType":"RDL","rsTypeVersion":"v1","vin":"WBAJA91010B306212","userid":"f86cdf4a-270e-4ab2-a973-a36496e55c07","creationTime":"2020-03-29T12:39:13.499+0000","lastUpdated":"2020-03-29T12:39:35.514+0000","rsEventStatus":"EXECUTED","requestParams":"{\"clientId\":3,\"doorControl\":\"LOCK\"}","actions":[{"rsStatus":"EXECUTED","rsDetailedStatus":"DLQ_MESSAGE_FETCHED","rsStatusMessage":"NgtpStatus","initiationError":"NO_ERROR","rsError":"NO_ERROR","creationTime":"2020-03-29T12:39:20.929+0000","initStatus":true},{"rsStatus":"EXECUTED","rsDetailedStatus":"SMS_DELIVERED_TO_VEHICLE","rsStatusMessage":"NgtpStatus","initiationError":"NO_ERROR","rsError":"NO_ERROR","creationTime":"2020-03-29T12:39:18.638+0000","initStatus":true}],"uploads":[]},{"eventId":"774b7487-661d-472c-ba3f-1a3a38797b24","ngtpEventId":"423330363231322613531200@bmw.de","rsType":"RLF","rsTypeVersion":"v1","vin":"WBAJA91010B306212","userid":"f86cdf4a-270e-4ab2-a973-a36496e55c07","creationTime":"2020-03-29T12:37:38.463+0000","lastUpdated":"2020-03-29T12:37:56.639+0000","rsEventStatus":"EXECUTED","requestParams":"{\"number\":2,\"pause\":1,\"duration\":1}","actions":[{"rsStatus":"EXECUTED","rsDetailedStatus":"DLQ_MESSAGE_FETCHED","rsStatusMessage":"NgtpStatus","initiationError":"NO_ERROR","rsError":"NO_ERROR","creationTime":"2020-03-29T12:37:48.009+0000","initStatus":true},{"rsStatus":"EXECUTED","rsDetailedStatus":"SMS_DELIVERED_TO_VEHICLE","rsStatusMessage":"NgtpStatus","initiationError":"NO_ERROR","rsError":"NO_ERROR","creationTime":"2020-03-29T12:37:45.606+0000","initStatus":true}],"uploads":[]},{"eventId":"02fe083c-e111-4897-83dd-22e8d26ebd4e","ngtpEventId":"423330363231322613522400@bmw.de","rsType":"RHB","rsTypeVersion":"v1","vin":"WBAJA91010B306212","userid":"f86cdf4a-270e-4ab2-a973-a36496e55c07","creationTime":"2020-03-29T12:33:40.293+0000","lastUpdated":"2020-03-29T12:33:59.367+0000","rsEventStatus":"EXECUTED","requestParams":"{\"number\":2,\"pause\":1,\"duration\":1}","actions":[{"rsStatus":"EXECUTED","rsDetailedStatus":"SMS_DELIVERED_TO_VEHICLE","rsStatusMessage":"NgtpStatus","initiationError":"NO_ERROR","rsError":"NO_ERROR","creationTime":"2020-03-29T12:33:47.867+0000","initStatus":true},{"rsStatus":"EXECUTED","rsDetailedStatus":"DLQ_MESSAGE_FETCHED","rsStatusMessage":"NgtpStatus","initiationError":"NO_ERROR","rsError":"NO_ERROR","creationTime":"2020-03-29T12:33:50.287+0000","initStatus":true}],"uploads":[]}]}
	
	// Bericht sturen
	// /api/vehicle/myinfo/v1
	// post bericht met parameters
	// {vins: ["WBAJA91010B306212"], message: "En waar komt het terecht?↵", subject: "Hoe werkt dit?"}
	// response
	// 
}
