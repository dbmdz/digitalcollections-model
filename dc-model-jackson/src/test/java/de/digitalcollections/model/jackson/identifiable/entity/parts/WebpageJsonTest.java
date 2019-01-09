package de.digitalcollections.model.jackson.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class WebpageJsonTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Webpage webpage = WebpageFactory.create();
    checkSerializeDeserialize(webpage);
  }
}
