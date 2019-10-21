package br.com.repository.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DefaultResponse {
	private Boolean success;
	private String message;

	public DefaultResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}
}
