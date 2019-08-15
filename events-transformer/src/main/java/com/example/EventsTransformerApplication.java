package com.example;

import com.example.avro.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@SpringBootApplication
public class EventsTransformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsTransformerApplication.class, args);
	}

}

@Service
@Slf4j
class MovieEventsTransformer {

	private static final String TOPIC = "raw-movies";

	@KafkaListener(topics = TOPIC)
	public void consume(Movie movie) {
		log.info("consumed movie:{} ", movie);
	}
}