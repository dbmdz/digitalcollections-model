package de.digitalcollections.model.api.http.exceptions;

public class HttpException extends RuntimeException {

  private final String methodKey;

  private final String request;
  private final int status;

  public HttpException(String methodKey, int status, String request) {
    super(String.format("Got %d for backend call %s.%n⤷ %s", status, methodKey, request));
    this.methodKey = methodKey;
    this.request = request;
    this.status = status;
  }

  public String getMethodKey() {
    return methodKey;
  }

  public String getRequest() {
    return request;
  }

  public int getStatus() {
    return status;
  }
}
