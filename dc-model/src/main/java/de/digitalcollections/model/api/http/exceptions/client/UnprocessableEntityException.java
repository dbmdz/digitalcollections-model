package de.digitalcollections.model.api.http.exceptions.client;

public class UnprocessableEntityException extends HttpClientException {

  public UnprocessableEntityException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }
}
