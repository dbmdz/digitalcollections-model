package de.digitalcollections.model.jackson.identifiable.entity.semantic;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.semantic.Subject;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Subject")
public class SubjectTest extends BaseJsonSerializationTest {

  @DisplayName("can be serialized and deserialized")
  @Test
  public void testSerializeDeserialize() throws Exception {
    Subject subject =
        Subject.builder()
            .identifier(Identifier.builder().namespace("namespace1").id("id1").build())
            .identifier(Identifier.builder().namespace("namespace2").id("id2").build())
            .label(new LocalizedText(Locale.GERMAN, "Subject"))
            .build();

    checkSerializeDeserialize(
        subject, "serializedTestObjects/identifiable/entity/semantic/Subject.json");
  }
}
