package com.aikhomu_okoedion.TheRide;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TheRideApplication {

	@Autowired
	@Qualifier("geolocationKafkaTemplate")
	KafkaTemplate<String, GeolocationDTO> geolocationKafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TheRideApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(@Autowired @Qualifier("geolocationKafkaTemplate")  KafkaTemplate<String, GeolocationDTO> template) {

		GeolocationDTO testMessage = new GeolocationDTO();
		testMessage.setX(2);
		testMessage.setY(3);

		return args -> {
			template.send("pending", "test1", testMessage);
		};
	}

}
