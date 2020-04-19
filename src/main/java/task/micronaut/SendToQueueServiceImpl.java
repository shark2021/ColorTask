package task.micronaut;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class SendToQueueServiceImpl implements SendToQueueService {
	
	@Inject
	ColorsClient colorsClient;
	
	@Override
	public void filterAndSendToQueue(List<Color> colors) {
		List<Color> validatedColors = validateColors(colors);
		mapColors(validatedColors);
		
		validatedColors.stream()
							.forEach(col -> colorsClient.updateColors(col));
	}

	private List<Color> validateColors(List<Color> colors) {
		return colors.stream()
				.filter(col -> col.isPublish())
				.filter(col -> col.getColor() != null)
				.filter(col -> !col.getColor().isEmpty())
				.collect(Collectors.toList());
	}

	private void mapColors(List<Color> validatedColors) {
		// TODO Implementation: The color field should be mapped according to the microservice configuration (application.yml)
	}
	
}
