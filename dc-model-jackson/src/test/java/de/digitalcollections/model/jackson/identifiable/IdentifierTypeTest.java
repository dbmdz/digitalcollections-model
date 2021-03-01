package de.digitalcollections.model.jackson.identifiable;

import de.digitalcollections.model.identifiable.IdentifierType;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class IdentifierTypeTest extends BaseJsonSerializationTest {

  private IdentifierType createObject() {
    IdentifierType identifierType = new IdentifierType();
    identifierType.setUuid(UUID.fromString("61033a4d-318f-4aa4-96b1-6663137bb807"));
    identifierType.setPattern("^(\\w{3})(\\d{4})(\\d{4})$");
    identifierType.setLabel("Digital object id");
    identifierType.setNamespace("digId");
    return identifierType;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    IdentifierType identifierType = createObject();
    checkSerializeDeserialize(
        identifierType, "serializedTestObjects/identifiable/IdentifierType.json");
  }
}
