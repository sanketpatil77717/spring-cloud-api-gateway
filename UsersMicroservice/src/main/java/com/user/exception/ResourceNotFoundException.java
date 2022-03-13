package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1354223L;
	
	private String resourceName;
	
	private String fieldName;
	
	private Object fieldValue;
	
	
	public ResourceNotFoundException(String resourceName,String fieldName,Object fieldValue)
	{
		super(String.format("Resource %s with %s : %s not found.",resourceName,fieldName,fieldValue));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
		
	}


	public String getFieldName() {
		return resourceName;
	}


	public void setFieldName(String fieldName) {
		this.resourceName = fieldName;
	}


	public String getFieldValue() {
		return fieldName;
	}


	public void setFieldValue(String fieldValue) {
		this.fieldName = fieldValue;
	}


	public Object getFieldtype() {
		return fieldValue;
	}


	public void setFieldtype(Object fieldtype) {
		this.fieldValue = fieldtype;
	}
	
	

}
