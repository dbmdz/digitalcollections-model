package de.digitalcollections.model.exception;

/**
 * An exception indicating that there has been an error in the communication between client and
 * server that neither was a problem on client side not on server side but between (connection,
 * "wire", etc.)
 */
public class TechnicalException extends Exception {

  public TechnicalException() {}

  public TechnicalException(String message) {
    super(message);
  }

  public TechnicalException(String message, Throwable cause) {
    super(message, cause);
  }

  public TechnicalException(Throwable cause) {
    super(cause);
  }
}
