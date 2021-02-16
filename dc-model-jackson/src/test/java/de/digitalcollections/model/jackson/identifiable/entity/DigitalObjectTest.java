package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class DigitalObjectTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    DigitalObject digitalObject = new DigitalObject();

    digitalObject.addIdentifier(new Identifier(null, "zend", "bsb10001234"));

    ImageFileResource image = new ImageFileResource();
    image.setHeight(100);
    image.setWidth(400);
    digitalObject.getFileResources().add(image);

    digitalObject.setPreviewImage(image);

    ApplicationFileResource appFile = new ApplicationFileResource();
    appFile.setFilename("dings.pdf");
    digitalObject.getFileResources().add(appFile);

    digitalObject.setCustomAttribute("isHighlight", "true");

    checkSerializeDeserialize(digitalObject);
  }
}
