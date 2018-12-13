package de.digitalcollections.model.jackson.identifiable.resource;

import de.digitalcollections.cudami.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.api.identifiable.resource.MimeType;
import org.junit.jupiter.api.Test;

public class MimeTypeTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    checkSerializeDeserialize(createObject());
  }

  public MimeType createObject() {
    return MimeType.MIME_IMAGE_JPEG;
  }
}
