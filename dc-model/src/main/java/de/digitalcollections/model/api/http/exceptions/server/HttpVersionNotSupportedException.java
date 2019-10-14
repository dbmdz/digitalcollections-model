package de.digitalcollections.model.api.http.exceptions.server;

public class HttpVersionNotSupportedException extends HttpServerException {

  public HttpVersionNotSupportedException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }
}
