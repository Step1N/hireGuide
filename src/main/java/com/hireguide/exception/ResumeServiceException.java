package com.hireguide.exception;

public class ResumeServiceException extends RuntimeException{

  public ResumeServiceException(String message) {
    super(message);
  }

  public ResumeServiceException(String message, Throwable cause) {
    super(message, cause);
  }

}
