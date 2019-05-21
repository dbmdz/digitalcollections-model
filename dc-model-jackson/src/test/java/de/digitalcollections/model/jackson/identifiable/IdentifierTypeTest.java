package de.digitalcollections.model.jackson.identifiable;

import de.digitalcollections.model.impl.identifiable.IdentifierTypeImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class IdentifierTypeTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    IdentifierTypeImpl identifierType = new IdentifierTypeImpl();
    identifierType.setId(4711);
    identifierType.setPattern("^(\\w{3})(\\d{4})(\\d{4})$");
    identifierType.setLabel("Digital object id");
    identifierType.setNamespace("digId");

    checkSerializeDeserialize(identifierType);
  }

}
