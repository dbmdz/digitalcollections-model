package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class ManifestationTest extends BaseJsonSerializationTest {

  private LocalizedStructuredContent createNote(String noteText) {
    LocalizedStructuredContent localizedStructuredContent = new LocalizedStructuredContent();
    StructuredContent structuredContent = new StructuredContent();
    ContentBlock contentBlock = new Paragraph(noteText);
    structuredContent.addContentBlock(contentBlock);
    localizedStructuredContent.put(Locale.GERMAN, structuredContent);

    return localizedStructuredContent;
  }

  private Manifestation createObject() {
    Manifestation manifestation =
        Manifestation.builder()
            .composition("1 Partitur (11 Seiten)")
            .dimensions("26,5 x 70 x 2 cm")
            .scale("[Ca. 1:820 000]")
            .note(createNote("Plattendruck"))
            .note(createNote("Pr. 54 kr"))
            .build();
    //    manifestation.setLabel(new LocalizedText(Locale.GERMAN, "Zimmer-Gymnastik ohne Geräte"));
    //    Person person = new Person();
    //    person.setLabel(new LocalizedText(Locale.GERMAN, "Arnold Hiller"));
    //    manifestation.setCreators(Arrays.asList(person));
    //    manifestation.setFirstAppearedDate(LocalDate.parse("2020-04-28"));
    //    TimeValue timeValuePublished =
    //        new TimeValue(
    //            2020,
    //            (byte) 0,
    //            (byte) 0,
    //            (byte) 0,
    //            (byte) 0,
    //            (byte) 0,
    //            TimeValue.PREC_YEAR,
    //            0,
    //            0,
    //            0,
    //            TimeValue.CM_GREGORIAN_PRO);
    //    manifestation.setFirstAppearedTimeValue(timeValuePublished);
    return manifestation;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    Manifestation manifestation = createObject();
    checkSerializeDeserialize(
        manifestation, "serializedTestObjects/identifiable/entity/work/Manifestation.json");
  }
}
