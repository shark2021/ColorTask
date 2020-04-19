package task.micronaut;

import java.util.List;

public interface SendToQueueService {

	void filterAndSendToQueue(List<Color> colors);
	
}
