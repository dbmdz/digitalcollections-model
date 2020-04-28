# DigitalCollections: Model (Feign)

This library provides classes for handling model object transport using REST-library [OpenFeign](https://github.com/OpenFeign/feign).

- `EndpointErrorDecoder` allows developers to decode HTTP error codes into application-specific ones.
- `QueryMapEncoder` implementations encode request specific (paging, sorting, filtering) model objects into a map of query parameter names and values, see [Dynamic Query Parameters](https://github.com/OpenFeign/feign#dynamic-query-parameters)
