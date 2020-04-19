package task.micronaut;

import java.util.List;

import javax.inject.Inject;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/")
public class ColorController {
	
	@Inject
	ParseJsonService jsonService;
	
	@Inject
	SendToQueueService queueService;

	@Post(value = "/publish", consumes = MediaType.TEXT_PLAIN)
    public HttpResponse<?> publishColorsToQueue() {
		
		System.out.println("Getting json and parsing to objects");
		List<Color> parseJsonToObjects = jsonService.parseJsonToObjects();
		if (parseJsonToObjects != null) {
			queueService.filterAndSendToQueue(parseJsonToObjects);
		}
		
		return HttpResponse.ok("{ \"published\" : true }");
    }
	

	
}
