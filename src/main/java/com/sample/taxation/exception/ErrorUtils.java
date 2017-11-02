package com.sample.taxation.exception;

public final class ErrorUtils {

  private ErrorUtils() {
    // Intentionally empty
  }

  /**
   * creates and return an error object.
   * 
   * @param errMsgKey message of error
   * @param errorCode code of error
   * @param httpStatusCode status of error
   * @return error
   */
  public static Error createError(final String errMsgKey, final String errorCode,
      final Integer httpStatusCode) {
    final Error error = new Error();
    error.setMessage(errMsgKey);
    error.setCode(errorCode);
    error.setStatus(httpStatusCode);
    return error;
  }

}
