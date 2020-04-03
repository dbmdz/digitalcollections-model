package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.parts.Subtopic;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.ContentBlock;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import de.digitalcollections.model.impl.identifiable.entity.TopicImpl;
import de.digitalcollections.model.impl.identifiable.entity.parts.SubtopicImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.LocalizedStructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.StructuredContentImpl;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks.ParagraphImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class TopicTest extends BaseJsonSerializationTest {

  /* rendered json: see test resource "topic.json" */
  @Test
  public void testSerialisationInBothWays() throws Exception {
    TopicImpl topic = new TopicImpl();

    topic.setLabel(createLabel(Locale.ENGLISH, "King Ludwig II of Bavaria and his Times"));
    topic.setDescription(
        createDescription(
            Locale.ENGLISH,
            "King Ludwig II (1845-1886) is one of the most famous figures of Bavarian history. By means of his castles and buildings, this theme attests to the splendid, colourful side of the \"Märchenkönig\" (fairy tale king). Nevertheless, less well-known aspects of Ludwig’s life are also illustrated, for example artistic influences and models or his relationship to the Bayerische Staatsbibliothek. Specialists receive information on early biographies of Ludwig II and about sources on his life."));

    Subtopic subtopic1 =
        createSubtopic(Locale.ENGLISH, "Sources about the Life and Times of Ludwig II", "");
    topic.addSubtopic(subtopic1);

    Subtopic subtopic2 = createSubtopic(Locale.ENGLISH, "Artistic Influences and Models", "");
    topic.addSubtopic(subtopic2);

    Subtopic subtopic3 =
        createSubtopic(Locale.ENGLISH, "Castles and Constructions of Ludwig II", "");
    topic.addSubtopic(subtopic3);

    Subtopic subtopic4 =
        createSubtopic(
            Locale.ENGLISH,
            "Ludwig II and the Bayerische Staatsbibliothek",
            "King Ludwig II (1845-1886) left his mark on the Bayerische Staatsbibliothek in the form of a large number of diverse and noteworthy sources and materials ranging from the tenth to the nineteenth centuries.");
    topic.addSubtopic(subtopic4);

    checkSerializeDeserialize(topic);
  }

  private static LocalizedTextImpl createLabel(Locale locale, String text) {
    return new LocalizedTextImpl(locale, text);
  }

  private LocalizedStructuredContent createDescription(Locale locale, String text) {
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContentImpl();
    StructuredContent structuredContent = new StructuredContentImpl();
    ContentBlock contentBlock = new ParagraphImpl(text);
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.put(locale, structuredContent);
    return localizedStructuredContent;
  }

  private Subtopic createSubtopic(Locale locale, String label, String description) {
    Subtopic subtopic = new SubtopicImpl();
    subtopic.setLabel(createLabel(locale, label));
    subtopic.setDescription(createDescription(locale, description));
    return subtopic;
  }
}
