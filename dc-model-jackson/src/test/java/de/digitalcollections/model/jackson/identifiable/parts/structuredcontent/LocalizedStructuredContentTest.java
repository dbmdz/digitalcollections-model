package de.digitalcollections.model.jackson.identifiable.parts.structuredcontent;

import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import java.util.Locale;
import org.junit.Test;

public class LocalizedStructuredContentTest extends BaseSerializationTest {

  @Test
  public void testSerialization() throws Exception {
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    ContentBlock contentBlock = new ParagraphImpl("Buon Giorno!");
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.add(Locale.ITALY, structuredContent);
    
    checkSerializeDeserialize(localizedStructuredContent);
  }
}
