package de.digitalcollections.model.jackson.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class V1DigitalCollectionsObjectMapper extends ObjectMapper {

  public V1DigitalCollectionsObjectMapper() {
    super();
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    registerModule(new JavaTimeModule());
    registerModule(new V1DigitalCollectionsModelModule());
  }

  private V1DigitalCollectionsObjectMapper(V1DigitalCollectionsObjectMapper objectMapper) {
    super(objectMapper);
  }

  @Override
  public ObjectMapper copy() {
    return new V1DigitalCollectionsObjectMapper(this);
  }
}
