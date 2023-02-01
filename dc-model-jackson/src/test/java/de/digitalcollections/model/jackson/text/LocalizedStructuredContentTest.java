package de.digitalcollections.model.jackson.text;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalizedStructuredContentTest extends BaseJsonSerializationTest {
  private LocalizedStructuredContent createObject() {
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContent();
    StructuredContent structuredContent = new StructuredContent();
    ContentBlock contentBlock = new Paragraph("Buon Giorno!");
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.put(Locale.ITALY, structuredContent);
    return localizedStructuredContent;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    LocalizedStructuredContent localizedStructuredContent = createObject();
    checkSerializeDeserialize(
        localizedStructuredContent, "serializedTestObjects/text/LocalizedStructuredContent.json");
  }

  @DisplayName("can deserialize")
  @Test
  public void testDeserialize() throws JsonProcessingException {
    String json =
        "[{\"und\": \"{\\\"type\\\": \\\"doc\\\", \\\"content\\\": [{\\\"type\\\": \\\"paragraph\\\", \\\"content\\\": [{\\\"text\\\": \\\"*TESTDATA*: digifeed2, mit Inhouse-OCR\\\", \\\"type\\\": \\\"text\\\"}]}]}\"}]";
    LocalizedStructuredContent expected = new LocalizedStructuredContent();

    LocalizedStructuredContent actual =
        getMapper().readValue(json, LocalizedStructuredContent.class);
    assertThat(actual).isEqualTo(expected);
  }
}
