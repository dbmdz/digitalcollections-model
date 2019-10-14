package de.digitalcollections.model.jackson.identifiable;

import de.digitalcollections.model.impl.identifiable.IdentifierImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class IdentifierTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    IdentifierImpl identifier = new IdentifierImpl();
    identifier.setId("bsb10001234");
    identifier.setNamespace("digId");

    checkSerializeDeserialize(identifier);
  }
}
