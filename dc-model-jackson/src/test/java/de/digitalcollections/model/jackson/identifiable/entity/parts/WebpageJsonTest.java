package de.digitalcollections.model.jackson.identifiable.entity.parts;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebpageJsonTest extends BaseJsonSerializationTest {

  private String expectedJson;
  private static Webpage webpage;
  private ObjectMapper mapper;

  @BeforeAll
  public static void setUpGlobal() {
    webpage = WebpageFactory.create();
  }

  @BeforeEach
  public void setUp() throws Exception {
    expectedJson = readFromResources("serializedTestObjects/webpage.json").replaceAll("\\s", "");
    mapper = getMapper();
  }

  @Test
  public void testSerialization() throws Exception {
    webpage.setCreated(null);
    webpage.setLastModified(null);
    String json =
        mapper.writerWithDefaultPrettyPrinter().writeValueAsString(webpage).replaceAll("\\s", "");
    assertThat(json).isEqualTo(expectedJson);
  }

  @Test
  public void testSerialisationInBothWays() throws Exception {
    checkSerializeDeserialize(webpage);
  }
}
