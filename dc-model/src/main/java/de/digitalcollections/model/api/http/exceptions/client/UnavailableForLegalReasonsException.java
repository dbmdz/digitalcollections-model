package de.digitalcollections.model.api.http.exceptions.client;

public class UnavailableForLegalReasonsException extends HttpClientException {

  public UnavailableForLegalReasonsException(String methodKey, int status, String request) {
    super(methodKey, status, request);
  }

}
