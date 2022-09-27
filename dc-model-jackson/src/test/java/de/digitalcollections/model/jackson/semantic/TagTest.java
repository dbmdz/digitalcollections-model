package de.digitalcollections.model.jackson.semantic;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.semantic.Tag;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Tag")
public class TagTest extends BaseJsonSerializationTest {

  @DisplayName("can be serialized and deserialized")
  @Test
  public void testSerializeDeserialize() throws Exception {
    Tag tag =
        Tag.builder()
            .type("type")
            .id("tag-id")
            .label(new LocalizedText(Locale.GERMAN, "Das Label"))
            .namespace("tag-name")
            .build();

    checkSerializeDeserialize(tag, "serializedTestObjects/semantic/Tag.json");
  }
}
