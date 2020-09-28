package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Collection;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.entity.CollectionImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.time.LocalDate;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class CollectionTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Collection collection = new CollectionImpl();
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    ContentBlock contentBlock = new ParagraphImpl("Collection of all medieval manuscripts");
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.put(Locale.ENGLISH, structuredContent);
    collection.setDescription(localizedStructuredContent);
    collection.setPublicationStart(LocalDate.MIN);
    collection.setPublicationEnd(LocalDate.MAX);
    checkSerializeDeserialize(collection);
  }
}
