package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.entity.WebsiteImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import java.net.URL;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class WebsiteTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    WebsiteImpl website = new WebsiteImpl(new URL("http://www.example.org/"));
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    ContentBlock contentBlock = new ParagraphImpl("Buon Giorno!");
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.add(Locale.ITALY, structuredContent);
    website.setDescription(localizedStructuredContent);
    checkSerializeDeserialize(website);
  }

}
