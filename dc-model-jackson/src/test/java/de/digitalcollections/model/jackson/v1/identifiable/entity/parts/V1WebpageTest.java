package de.digitalcollections.model.jackson.v1.identifiable.entity.parts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.jackson.identifiable.entity.parts.WebpageFactory;
import de.digitalcollections.model.jackson.v1.V1BaseJsonSerializationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V1WebpageTest extends V1BaseJsonSerializationTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(V1WebpageTest.class);

  @Disabled
  @Test
  public void testSerialization() throws Exception {
    Webpage webpage = WebpageFactory.create();
    webpage.setCreated(null);
    webpage.setLastModified(null);

    final ObjectMapper mapper = getMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    String result = mapper.writeValueAsString(webpage);

    LOGGER.info(result);

    String expectedJson = readFromResources("serializedTestObjects/v1Webpage.json");

    Assertions.assertThat(result).isEqualTo(expectedJson);
  }
}
