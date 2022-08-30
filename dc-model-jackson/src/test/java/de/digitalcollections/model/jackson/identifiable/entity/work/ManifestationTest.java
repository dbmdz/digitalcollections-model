package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.work.Involvement;
import de.digitalcollections.model.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.identifiable.entity.work.Series;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValue;
import de.digitalcollections.model.time.TimeValueRange;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Set;
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
    // Later, because series extends work
    Series series = (Series) Series.builder().label("Aus Natur und Geisteswelt").build();

    Manifestation manifestation =
        Manifestation.builder()
            .identifier("foo", "bar")
            .label(Locale.GERMAN, "Zimmer-Gymnastik ohne Geräte")
            .composition("1 Partitur (11 Seiten)")
            .dimensions("26,5 x 70 x 2 cm")
            .scale("[Ca. 1:820 000]")
            .note(createNote("Plattendruck"))
            .note(createNote("Pr. 54 kr"))
            // .series(Set.of(series))
            .sortKey("1932-40-12-25-41")
            .version("2. Auflage")
            .involvements(
                List.of(
                    Involvement.builder()
                        .isCreator(true)
                        .agent(Person.builder().label(Locale.GERMAN, "Arnold Hiller").build())
                        .build()))
            .publishingTimeValueRange(
                new TimeValueRange(
                    new TimeValue(
                        2020,
                        (byte) 0,
                        (byte) 0,
                        (byte) 0,
                        (byte) 0,
                        (byte) 0,
                        TimeValue.PREC_YEAR,
                        0,
                        0,
                        0,
                        TimeValue.CM_GREGORIAN_PRO),
                    new TimeValue(
                        2020,
                        (byte) 0,
                        (byte) 0,
                        (byte) 0,
                        (byte) 0,
                        (byte) 0,
                        TimeValue.PREC_YEAR,
                        0,
                        0,
                        0,
                        TimeValue.CM_GREGORIAN_PRO)))
            .publishingDatePresentation("2020")
            .publishingDateRange(
                new LocalDateRange(LocalDate.parse("2020-04-28"), LocalDate.parse("2020-04-28")))
            .navDate("2022-08-30")
            .language(Locale.GERMAN)
            .otherLanguages(Set.of(Locale.ITALIAN))
            // TODO, wenn TitleType fertig ist .titles(List.of())
            .build();
    return manifestation;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    Manifestation manifestation = createObject();
    checkSerializeDeserialize(
        manifestation, "serializedTestObjects/identifiable/entity/work/Manifestation.json");
  }
}
