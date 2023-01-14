package com.workshop.resource.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String id) {
		super("Entity not found, id: " + id);
	}
}