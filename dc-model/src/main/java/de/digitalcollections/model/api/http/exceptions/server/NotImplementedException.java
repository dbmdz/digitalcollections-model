package de.digitalcollections.model.api.http.exceptions.server;

public class NotImplementedException extends HttpServerException {

  public NotImplementedException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }
}
