package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.impl.identifiable.IdentifierImpl;
import de.digitalcollections.model.impl.identifiable.entity.DigitalObjectImpl;
import de.digitalcollections.model.impl.identifiable.resource.ApplicationFileResourceImpl;
import de.digitalcollections.model.impl.identifiable.resource.ImageFileResourceImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class DigitalObjectTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    DigitalObjectImpl digitalObject = new DigitalObjectImpl();

    digitalObject.addIdentifier(new IdentifierImpl(null, "zend", "bsb10001234"));

    ImageFileResource image = new ImageFileResourceImpl();
    image.setHeight(100);
    image.setWidth(400);
    digitalObject.getFileResources().add(image);

    digitalObject.setPreviewImage(image);

    ApplicationFileResourceImpl appFile = new ApplicationFileResourceImpl();
    appFile.setFilename("dings.pdf");
    digitalObject.getFileResources().add(appFile);

    checkSerializeDeserialize(digitalObject);
  }
}
