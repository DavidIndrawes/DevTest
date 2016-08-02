package goeuro;

public class CitySuggestion {
	private int id ;
	private String key = null;
	private String name;
	private String fullName;
	private String iataAirportCode=null;
	private String type;
	private String country;
	private GeoPosition geoPosition;
	private int locationID;
	private boolean inEurope;
	private String countryCode;
	private boolean coreCountry;
	private String distance=null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		if(key!= "null")this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIataAirportCode() {
		return iataAirportCode;
	}
	public void setIataAirportCode(String iataAirportCode) {
		if(iataAirportCode!= "null")this.iataAirportCode = iataAirportCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public boolean isInEurope() {
		return inEurope;
	}
	public void setInEurope(String inEurope) {
		this.inEurope =(inEurope=="true")?true:false; 
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public boolean isCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(String coreCountry) {
		this.coreCountry = (coreCountry =="true")?true:false; 
	} 
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		if(distance!= "null")this.distance = distance;
	}
}
