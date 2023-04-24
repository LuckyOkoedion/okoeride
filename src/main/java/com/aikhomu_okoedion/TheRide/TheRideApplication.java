package com.aikhomu_okoedion.TheRide;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TheRideApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;

		try {

			context = SpringApplication.run(TheRideApplication.class, args);

		} catch (Exception e) {
			if (context != null) {
			Environment environment = context.getBean(Environment.class);
			System.out.println("Environment variables:");
			String[] propertyNames = {
				"spring.data.cassandra.local-datacenter",
				"spring.data.cassandra.keyspace-name",
				"spring.data.cassandra.username",

		        "spring.data.cassandra.password",
				"spring.data.cassandra.port",
				"spring.data.cassandra.auth-provider",
				"spring.data.cassandra.contact-points",
				"spring.data.cassandra.schema-action",
				"spring.data.cassandra.request.timeout",
				"spring.data.cassandra.connection.connect-timeout",
				"spring.data.cassandra.connection.init-query-timeout",
				"spring.kafka.consumer.auto-offset-reset",
				"spring.kafka.bootstrap-servers",
				"spring.kafka.producer.topic.retention.check.interval.ms",
				"spring.kafka.producer.topic.retention.ms"
			};

                for (String propertyName : propertyNames) {
		            System.out.println(propertyName + ": " + environment.getProperty(propertyName));
				}
			}
			throw e;
		}
	}

	@Bean
	public ApplicationRunner runner(@Autowired @Qualifier("geolocationKafkaTemplate")  KafkaTemplate<String, GeolocationDTO> template) {

		System.out.println("Environment variables:");
		String[] propertyNames = {
				"spring.data.cassandra.local-datacenter",
				"spring.data.cassandra.keyspace-name",
				"spring.data.cassandra.username",
				"spring.data.cassandra.password",
				"spring.data.cassandra.port",
				"spring.data.cassandra.auth-provider",
				"spring.data.cassandra.contact-points",
				"spring.data.cassandra.schema-action",
				"spring.data.cassandra.request.timeout",
				"spring.data.cassandra.connection.connect-timeout",
				"spring.data.cassandra.connection.init-query-timeout",
				"spring.kafka.consumer.auto-offset-reset",
				"spring.kafka.bootstrap-servers",
				"spring.kafka.producer.topic.retention.check.interval.ms",
				"spring.kafka.producer.topic.retention.ms"
	};
        for (String propertyName : propertyNames) {
		System.out.println(propertyName + ": " + environment.getProperty(propertyName));
	}


		GeolocationDTO testMessage = new GeolocationDTO();
		testMessage.setX(2);
		testMessage.setY(3);

		return args -> {

			try {
				System.out.println("===============Sending test payload to kafka Pending =============");
				template.send("pending", "test1", testMessage);

			} catch (Exception e) {
				e.printStackTrace();

			}

		};
	}



}
