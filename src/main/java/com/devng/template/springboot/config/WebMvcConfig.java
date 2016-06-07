package com.devng.template.springboot.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Configuration
public class WebMvcConfig {

	// Strict ISO 8601 date format with UTC offset
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	@Bean
	public ObjectMapper objectMapper() {

		ObjectMapper mapper = new ObjectMapper();

		JodaModule jodaModule = new JodaModule();
		mapper.registerModule(jodaModule);
		mapper.setTimeZone(TimeZone.getTimeZone("UTC"));

		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		SerializationConfig serConfig = mapper.getSerializationConfig();
		serConfig.with(dateFormat);
		DeserializationConfig deserConfig = mapper.getDeserializationConfig();
		deserConfig.with(dateFormat);

		return mapper;
	}

	@PostConstruct
	public void initialize() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
