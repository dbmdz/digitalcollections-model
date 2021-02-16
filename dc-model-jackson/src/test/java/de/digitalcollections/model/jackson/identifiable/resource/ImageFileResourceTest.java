package de.digitalcollections.model.jackson.identifiable.resource;

import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class ImageFileResourceTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    ImageFileResource image = new ImageFileResource();
    image.setHeight(768);
    image.setWidth(1024);

    checkSerializeDeserialize(image);
  }
}
