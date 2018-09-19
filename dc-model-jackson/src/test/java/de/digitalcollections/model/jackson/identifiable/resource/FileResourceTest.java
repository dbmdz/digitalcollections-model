package de.digitalcollections.model.jackson.identifiable.resource;

import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.api.identifiable.resource.MimeType;
import de.digitalcollections.model.impl.identifiable.resource.FileResourceImpl;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;

public class FileResourceTest extends BaseSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    checkSerializeDeserialize(createObject());
  }

  public FileResource createObject() {
    FileResource obj = new FileResourceImpl();
    obj.setFilename("filename.jpg");
    obj.setFilenameExtension("jpg");
    obj.setMimeType(MimeType.MIME_IMAGE_JPEG);
    obj.setLastModified(LocalDateTime.ofInstant(Instant.ofEpochMilli(1000000), ZoneId.systemDefault()));
    return obj;
  }
}
