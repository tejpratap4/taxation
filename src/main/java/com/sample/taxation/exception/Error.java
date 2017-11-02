package com.sample.taxation.exception;

import java.io.Serializable;

/**
 * Error Object - Complex type that contains error details for a REST call.
 * 
 */

public class Error implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Application error code, which is different from HTTP error code.
	 * 
	 */
	private String code;

	/**
	 * Summary of the problem.
	 */
	private String message;

	/**
	 * HTTP status code for this occurrence of the problem, set by the origin
	 * server.
	 * 
	 */
	private Integer status;

	/**
	 * Get the code.
	 * 
	 * @return code of error
	 */
	public String getCode() {
		return code;
	}

	/**
	 * set the code.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the message.
	 * 
	 * @return message of error
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * set the message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the status.
	 * 
	 * @return status of error
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * set the status.
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
