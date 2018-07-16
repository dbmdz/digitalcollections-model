package de.digitalcollections.model.api.http.exceptions.client;

public class ResourceNotFoundException extends HttpClientException {

  public ResourceNotFoundException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }

}
