package de.digitalcollections.model.api.http.exceptions.client;

public class ForbiddenException extends HttpClientException {

  public ForbiddenException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }
}
