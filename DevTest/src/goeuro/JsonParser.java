package goeuro;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

	private String jsonData;
	private ArrayList<CitySuggestion> suggestions = new ArrayList<CitySuggestion>();
	
	public JsonParser(String jsonData){
		this.jsonData = jsonData;
	}
	
	public void parse(){
		JSONArray myArray=null;
		try {
			myArray = new JSONArray(jsonData);
		} catch (JSONException e) {
			System.out.println("error in the data format received from the server");
			e.printStackTrace();
		}
		
		JSONObject myObject, position;
		for(int i=0;i<myArray.length();i++){
			myObject= myArray.optJSONObject(i);		// iterate over the objects in the array
			position = myObject.optJSONObject("geo_position");	// for each object get the position object
			
			suggestions.add(i,new CitySuggestion());
			suggestions.get(i).setId(myObject.optInt("_id"));
			suggestions.get(i).setKey(myObject.optString("key"));
			suggestions.get(i).setName(myObject.optString("name"));
			suggestions.get(i).setFullName(myObject.optString("fullName"));
			suggestions.get(i).setIataAirportCode(myObject.optString("iata_airport_code"));
			suggestions.get(i).setType(myObject.optString("type"));
			suggestions.get(i).setCountry(myObject.optString("countrey"));
			suggestions.get(i).setGeoPosition(new GeoPosition(position.optDouble("latitude"), position.optDouble("longitude")));
			suggestions.get(i).setLocationID(myObject.optInt("location_id"));
			suggestions.get(i).setInEurope(myObject.optString("inEurope"));
			suggestions.get(i).setCountryCode(myObject.optString("countryCode"));;
			suggestions.get(i).setCoreCountry(myObject.optString("coreCountry"));
			suggestions.get(i).setDistance(myObject.optString("distance"));
			}
		
		
	}
	
	public ArrayList<CitySuggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(ArrayList<CitySuggestion> suggestions) {
		this.suggestions = suggestions;
	}
}
