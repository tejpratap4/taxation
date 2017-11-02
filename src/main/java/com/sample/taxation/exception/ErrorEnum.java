package com.sample.taxation.exception;

/**
 * An enumeration of error codes and associated message keys for taxation
 * related validation errors.
 *
 *
 */
public enum ErrorEnum {
	GENERIC_ERROR("TAX-0001","The system is unable to complete the task. Contact your supervisor."), 
	PRODUCT_NOT_FOUND_IN_MAP("TAX-1002", "Product Name does not exists.");

	private String errCode;
	private String errMsgKey;

	ErrorEnum(final String errCode, final String errMsgKey) {
		this.errCode = errCode;
		this.errMsgKey = errMsgKey;
	}

	/**
	 * Get the error code.
	 * 
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * Get the error message.
	 * 
	 * @return the errMsgKey
	 */
	public String getErrMsgKey() {
		return errMsgKey;
	}

}
