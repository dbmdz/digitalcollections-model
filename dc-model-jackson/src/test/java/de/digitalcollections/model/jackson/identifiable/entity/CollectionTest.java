package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import java.time.LocalDate;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class CollectionTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Collection collection = new Collection();
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContent();
    StructuredContent structuredContent = new StructuredContent();
    ContentBlock contentBlock = new Paragraph("Collection of all medieval manuscripts");
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.put(Locale.ENGLISH, structuredContent);
    collection.setDescription(localizedStructuredContent);
    collection.setPublicationStart(LocalDate.MIN);
    collection.setPublicationEnd(LocalDate.MAX);
    checkSerializeDeserialize(collection);
  }
}
