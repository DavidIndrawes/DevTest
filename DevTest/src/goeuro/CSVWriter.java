package goeuro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CSVWriter {

	private ArrayList<CitySuggestion> suggestions = new ArrayList<CitySuggestion>();
	private String cityName;
	
	public CSVWriter(ArrayList<CitySuggestion> suggestions, String cityName){
		this.suggestions = suggestions;
		this.cityName = cityName;
	}
	
	public void write(){
		File csvFile = new File(cityName+".csv");
		FileWriter writer;
		try {
			writer = new FileWriter(csvFile);
			writer.write("Id,Name,Type,Latitude,Longitude\n");	// table heading
			
			for(CitySuggestion suggestion  : suggestions){
				writer.write(suggestion.getId()+","+suggestion.getName()+","+suggestion.getType()+","+suggestion.getGeoPosition().getLatitude()+","+suggestion.getGeoPosition().getLongitude()+"\n");
			}
			
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			System.out.print("cannot write to the file"+cityName+".csv please make sure that the file is not being used by other program");
			e.printStackTrace();
		}
		
		
		

	}
}
