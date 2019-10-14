package de.digitalcollections.model.jackson.identifiable;

import de.digitalcollections.model.api.identifiable.Version.Status;
import de.digitalcollections.model.impl.identifiable.VersionImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class VersionTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    VersionImpl version = new VersionImpl();
    version.setUuid(UUID.fromString("1e2d8b1e-c29d-475b-8f61-67b22ca6de89"));
    version.setVersionValue(0);
    version.setStatus(Status.INITIAL);

    checkSerializeDeserialize(version);
  }
}
