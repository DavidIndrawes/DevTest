package junit;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import goeuro.CSVWriter;
import goeuro.Client;
import goeuro.JsonParser;
import junit.framework.TestCase;

public class testingJUNIT extends TestCase {
	
	public void testingClientCorrectURL(){
		Client c = new Client("London");
		assertEquals(c.getUrl(), "http://api.goeuro.com/api/v2/position/suggest/en/London");
	}
	
	public void testingFetchingRightData(){
		Client c = new Client("Huddersfield");
		// JSON data for huddersfield has been fetched manually to be compared with what the program got
		assertEquals(c.fetchData(), "[{\"_id\":380442,\"key\":null,\"name\":\"Huddersfield\",\"fullName\":\"Huddersfield, United Kingdom\",\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"United Kingdom\",\"geo_position\":{\"latitude\":53.64904,\"longitude\":-1.78416},\"locationId\":12632,\"inEurope\":true,\"countryId\":75,\"countryCode\":\"GB\",\"coreCountry\":true,\"distance\":null,\"names\":{\"zh\":\"哈德斯菲尔德\",\"ru\":\"Хаддерсфилд\"},\"alternativeNames\":{}}]");
	}
	
	public void testingFetchingDataForWrongCityName(){
		Client c = new Client("Loay");
		// empty array expected
		assertEquals(c.fetchData(), "[]");
	}
	
	// check the parsing method running without any errors
	public void testingParsingMethod(){
		Client c = new Client("London");
		JsonParser parser = new JsonParser(c.fetchData());
		parser.parse();
	}
	
	// check if parsing correctly or not
	public void testingFetchingMethodResultWithWrongCity(){
		Client c = new Client("Loay");
		JsonParser parser = new JsonParser(c.fetchData());
		parser.parse();
		assertEquals(parser.getSuggestions().size(), 0);
	}
	
	public void testingFetchingMethodResultWithRightCity(){
		Client c = new Client("Berlin");
		JsonParser parser = new JsonParser(c.fetchData());
		parser.parse();
		// number of suggestion has been counted manually to compare it to what have found , expected 8 suggesstions
		assertEquals(parser.getSuggestions().size(), 8);
	}
	
	// continue to check right results
	public void testingFetchingMethodResultWithRightCity2(){
		Client c = new Client("Berlin");
		JsonParser parser = new JsonParser(c.fetchData());
		parser.parse();
		// check the seventh suggestion id should be: 334196
		assertEquals(parser.getSuggestions().get(6).getId(), 334196);
	}
	
	public void testWritingToCSVFile(){
		Client c = new Client("Berlin");
		JsonParser parser = new JsonParser(c.fetchData());
		parser.parse();
		CSVWriter writer = new CSVWriter(parser.getSuggestions(), "Berlin");
		writer.write();
	}
	
}
