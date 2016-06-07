package com.devng.template.springboot.controller.dto;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public class SystemMessageDTO implements JsonSerializable {

	private HttpStatus status;

	private String error;

	private String message;

	public SystemMessageDTO(HttpStatus status, String error, String message) {
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeNumberField("status", status.value());
		jgen.writeStringField("error", error);
		jgen.writeStringField("message", message);
		jgen.writeEndObject();
		jgen.close();
	}

	@Override
	public void serializeWithType(JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
		serialize(jgen, provider);
	}
}
