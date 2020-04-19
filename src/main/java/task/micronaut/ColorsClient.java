package task.micronaut;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut")
public interface ColorsClient {

	@Binding("colors")
	void updateColors(Color color);
}
