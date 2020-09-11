package de.digitalcollections.model.api.http.exceptions;

import de.digitalcollections.model.api.http.exceptions.client.ForbiddenException;
import de.digitalcollections.model.api.http.exceptions.client.HttpClientException;
import de.digitalcollections.model.api.http.exceptions.client.ImATeapotException;
import de.digitalcollections.model.api.http.exceptions.client.ResourceNotFoundException;
import de.digitalcollections.model.api.http.exceptions.client.UnauthorizedException;
import de.digitalcollections.model.api.http.exceptions.client.UnavailableForLegalReasonsException;
import de.digitalcollections.model.api.http.exceptions.client.UnprocessableEntityException;
import de.digitalcollections.model.api.http.exceptions.server.BadGatewayException;
import de.digitalcollections.model.api.http.exceptions.server.GatewayTimeOutException;
import de.digitalcollections.model.api.http.exceptions.server.HttpServerException;
import de.digitalcollections.model.api.http.exceptions.server.HttpVersionNotSupportedException;
import de.digitalcollections.model.api.http.exceptions.server.NotImplementedException;
import de.digitalcollections.model.api.http.exceptions.server.ServiceUnavailableException;
import java.net.MalformedURLException;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpErrorDecoder {

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpErrorDecoder.class);

  public static HttpException decode(String methodKey, int statusCode, HttpResponse response) {
    String requestUrl = null;
    try {
      if (response != null) {
        requestUrl = response.request().uri().toURL().toString();
      }
    } catch (MalformedURLException ex) {
      LOGGER.warn("Invalid request Url for: " + response.request().uri());
    }

    if (400 <= statusCode && statusCode < 500) {
      return clientException(methodKey, statusCode, requestUrl);
    } else if (500 <= statusCode && statusCode < 600) {
      return serverException(methodKey, statusCode, requestUrl);
    } else {
      return genericHttpException(methodKey, statusCode, requestUrl);
    }
  }

  private static HttpException clientException(
      String methodKey, int statusCode, String requestUrl) {
    switch (statusCode) {
      case 401:
        return new UnauthorizedException(methodKey, statusCode, requestUrl);
      case 403:
        return new ForbiddenException(methodKey, statusCode, requestUrl);
      case 404:
        return new ResourceNotFoundException(methodKey, statusCode, requestUrl);
      case 413:
        return new ImATeapotException(methodKey, statusCode, requestUrl);
      case 422:
        return new UnprocessableEntityException(methodKey, statusCode, requestUrl);
      case 451:
        return new UnavailableForLegalReasonsException(methodKey, statusCode, requestUrl);
      default:
        return new HttpClientException(methodKey, statusCode, requestUrl);
    }
  }

  private static HttpException genericHttpException(
      String methodKey, int statusCode, String requestUrl) {
    return new HttpException(methodKey, statusCode, requestUrl);
  }

  private static HttpServerException serverException(
      String methodKey, int statusCode, String requestUrl) {
    switch (statusCode) {
      case 501:
        return new NotImplementedException(methodKey, statusCode, requestUrl);
      case 502:
        return new BadGatewayException(methodKey, statusCode, requestUrl);
      case 503:
        return new ServiceUnavailableException(methodKey, statusCode, requestUrl);
      case 504:
        return new GatewayTimeOutException(methodKey, statusCode, requestUrl);
      case 505:
        return new HttpVersionNotSupportedException(methodKey, statusCode, requestUrl);
      default:
        return new HttpServerException(methodKey, statusCode, requestUrl);
    }
  }
}
