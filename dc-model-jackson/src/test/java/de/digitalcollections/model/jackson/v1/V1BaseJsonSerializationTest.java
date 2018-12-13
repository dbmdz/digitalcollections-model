package de.digitalcollections.model.jackson.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.jackson.v1.V1DigitalCollectionsObjectMapper;

public class V1BaseJsonSerializationTest extends BaseJsonSerializationTest {

  @Override
  protected ObjectMapper getMapper() {
    return new V1DigitalCollectionsObjectMapper();
  }
}
