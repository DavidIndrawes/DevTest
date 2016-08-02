package goeuro;

public class Main {

	public static void main(String[] args) {
		String cityName;
		try{
			cityName = args[0];
			Client c = new Client(cityName);
			JsonParser parser = new JsonParser(c.fetchData());
			parser.parse();
			CSVWriter writer = new CSVWriter(parser.getSuggestions(), cityName);
			writer.write();
		}catch (NullPointerException e){
			System.out.println("parameter is missing, please add the city name as a parameter the command");
		}
		
		
	}

}
