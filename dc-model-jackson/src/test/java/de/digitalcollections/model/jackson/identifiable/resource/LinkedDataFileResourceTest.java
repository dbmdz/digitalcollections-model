package de.digitalcollections.model.jackson.identifiable.resource;

import de.digitalcollections.model.impl.identifiable.resource.LinkedDataFileResourceImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.net.URI;
import org.junit.jupiter.api.Test;

public class LinkedDataFileResourceTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    LinkedDataFileResourceImpl resource = new LinkedDataFileResourceImpl();
    resource.setContext(URI.create("http://iiif.io/api/presentation/2/context.json"));
    resource.setObjectType("sc:Manifest");

    checkSerializeDeserialize(resource);
  }
}
