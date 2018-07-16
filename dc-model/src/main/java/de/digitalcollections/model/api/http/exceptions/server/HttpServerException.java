package de.digitalcollections.model.api.http.exceptions.server;

import de.digitalcollections.model.api.http.exceptions.HttpException;

public class HttpServerException extends HttpException {

  public HttpServerException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }

}
