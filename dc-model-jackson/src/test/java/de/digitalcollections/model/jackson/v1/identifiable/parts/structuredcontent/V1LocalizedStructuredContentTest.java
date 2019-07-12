package de.digitalcollections.model.jackson.v1.identifiable.parts.structuredcontent;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.jackson.v1.V1BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class V1LocalizedStructuredContentTest extends V1BaseJsonSerializationTest {

  @Test
  public void testSerialization() throws Exception {
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    ContentBlock contentBlock = new ParagraphImpl("Buon Giorno!");
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.put(Locale.ITALY, structuredContent);

    checkSerializeDeserialize(localizedStructuredContent);
  }
}
