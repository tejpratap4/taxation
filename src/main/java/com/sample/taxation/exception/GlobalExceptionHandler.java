package com.sample.taxation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Implement global exception handling behavior. This simplifies controller code; it can just throw
 * an appropriate exception and the appropriate error response is generated.
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
  
  /**
   * Handle a Exception, returning response with the status specified in exception.
   * 
   * @param exception the exception
   * @return a response with status as specified in exception
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> handleGeneralException(final Exception exception) {
    LOGGER.error("Exception Message: {} " , exception.getMessage());
    final Error error = ErrorUtils.createError(ErrorEnum.GENERIC_ERROR.getErrMsgKey(),
        ErrorEnum.GENERIC_ERROR.getErrCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  /**
   * Handle a ProductNotFoundInMapException, returning response with the status specified in exception.
   * 
   * @param notFoundInMapException the exception
   * @return a response with status 404 - Not Found
   */
  @ExceptionHandler(NotFoundInMapException.class)
  public ResponseEntity<Error> handleNotFoundInDbException(
      final NotFoundInMapException notFoundInMapException) {
    final Error error = ErrorUtils.createError(notFoundInMapException.getErrMsgKey(),
        notFoundInMapException.getErrorCode(), HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

}
