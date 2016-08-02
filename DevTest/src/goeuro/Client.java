package goeuro;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class Client {
	
	private String urlBasic ="http://api.goeuro.com/api/v2/position/suggest/en/";
	private String urlFull ;
	private String cityName;
	
	public Client(String s){
		cityName = s;
		urlFull= urlBasic+cityName;
	}
	
	public String fetchData(){
		URL url;
		String data = null;
		try {
			url = new URL(urlFull);
			InputStream is = url.openStream();
			data = IOUtils.toString(is, StandardCharsets.UTF_8);	// get the JSON document in String
		} catch (MalformedURLException e) {
			// can be ignored because we already know that the server will respond with empty array in case of wrong city name
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("problem connecting to the server");
			e.printStackTrace();
		}
				return data;
	}

	public String getUrl() {
		return urlFull;
	}


	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
		urlFull= urlBasic+cityName;
	}
	
	
}
