package com.example.playground.playground;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@Configuration
public class PlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

	@Autowired
  public void configureJackson(ObjectMapper mapper) {
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
