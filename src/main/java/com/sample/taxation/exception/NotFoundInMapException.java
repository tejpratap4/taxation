package com.sample.taxation.exception;

import java.text.MessageFormat;

/**
 * Custom NotFoundInMapException class.
 *
 *
 */
public class NotFoundInMapException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String errMsgKey;
	private final String errorCode;

	/**
	 * Parameterize constructor for creating not found in DB exception.
	 * 
	 * @param errorInfo
	 *            Information about error
	 */
	public NotFoundInMapException(final ErrorEnum errorInfo) {
		super(errorInfo.getErrMsgKey());
		this.errMsgKey = errorInfo.getErrMsgKey();
		this.errorCode = errorInfo.getErrCode();
	}

	/**
	 * 
	 * @param erorrInfo
	 * @param params
	 */
	public NotFoundInMapException(final ErrorEnum erorrInfo, final Object[] params) {
		super(erorrInfo.getErrMsgKey());
		final MessageFormat messageFormat = new MessageFormat(erorrInfo.getErrMsgKey());
		this.errMsgKey = messageFormat.format(params);
		this.errorCode = erorrInfo.getErrCode();
	}

	public String getErrMsgKey() {
		return errMsgKey;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
