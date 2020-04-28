package de.digitalcollections.model.feign.codec;

import de.digitalcollections.model.api.http.exceptions.HttpException;
import de.digitalcollections.model.api.http.exceptions.client.ForbiddenException;
import de.digitalcollections.model.api.http.exceptions.client.HttpClientException;
import de.digitalcollections.model.api.http.exceptions.client.ImATeapotException;
import de.digitalcollections.model.api.http.exceptions.client.ResourceNotFoundException;
import de.digitalcollections.model.api.http.exceptions.client.UnauthorizedException;
import de.digitalcollections.model.api.http.exceptions.client.UnavailableForLegalReasonsException;
import de.digitalcollections.model.api.http.exceptions.server.BadGatewayException;
import de.digitalcollections.model.api.http.exceptions.server.GatewayTimeOutException;
import de.digitalcollections.model.api.http.exceptions.server.HttpServerException;
import de.digitalcollections.model.api.http.exceptions.server.HttpVersionNotSupportedException;
import de.digitalcollections.model.api.http.exceptions.server.NotImplementedException;
import de.digitalcollections.model.api.http.exceptions.server.ServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;

/** Allows you to decode HTTP error codes into application-specific ones. */
public class EndpointErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    final int status = response.status();
    final String request = response.request().toString();

    if (400 <= status && status < 500) {
      return clientException(methodKey, status, request);
    } else if (500 <= status && status < 600) {
      return serverException(methodKey, status, request);
    } else {
      return new HttpException(methodKey, status, request);
    }
  }

  private HttpClientException clientException(String methodKey, int status, String request) {
    switch (status) {
      case 401:
        return new UnauthorizedException(methodKey, status, request);
      case 403:
        return new ForbiddenException(methodKey, status, request);
      case 404:
        return new ResourceNotFoundException(methodKey, status, request);
      case 418:
        return new ImATeapotException(methodKey, status, request);
      case 451:
        return new UnavailableForLegalReasonsException(methodKey, status, request);
      default:
        return new HttpClientException(methodKey, status, request);
    }
  }

  private HttpServerException serverException(String methodKey, int status, String request) {
    switch (status) {
      case 501:
        return new NotImplementedException(methodKey, status, request);
      case 502:
        return new BadGatewayException(methodKey, status, request);
      case 503:
        return new ServiceUnavailableException(methodKey, status, request);
      case 504:
        return new GatewayTimeOutException(methodKey, status, request);
      case 505:
        return new HttpVersionNotSupportedException(methodKey, status, request);
      default:
        return new HttpServerException(methodKey, status, request);
    }
  }
}
