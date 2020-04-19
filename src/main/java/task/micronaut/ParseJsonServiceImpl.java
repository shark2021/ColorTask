package task.micronaut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.ObjectMapper;

@Singleton
public class ParseJsonServiceImpl implements ParseJsonService {
	
	@Override
	public List<Color> parseJsonToObjects() {
		// TODO: improve string concat! 
		String jsonDir = System.getProperty("user.dir") + "\\src\\main\\resources\\PostColors.json";
		ObjectMapper mapper = new ObjectMapper();
		List<Color> colorObjects = new ArrayList<Color>();
		
		try {
			byte[] jsonBytes = Files.readAllBytes(Paths.get(jsonDir));
			colorObjects = Arrays.asList(mapper.readValue(jsonBytes, Color[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return colorObjects;
	}

}
