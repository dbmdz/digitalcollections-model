package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.identifiable.entity.work.ExpressionType;
import de.digitalcollections.model.identifiable.entity.work.Involvement;
import de.digitalcollections.model.identifiable.entity.work.Manifestation;
import de.digitalcollections.model.identifiable.entity.work.Publication;
import de.digitalcollections.model.identifiable.entity.work.Series;
import de.digitalcollections.model.identifiable.entity.work.Title;
import de.digitalcollections.model.identifiable.entity.work.TitleType;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.semantic.Subject;
import de.digitalcollections.model.semantic.Tag;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.text.StructuredContent;
import de.digitalcollections.model.text.contentblock.ContentBlock;
import de.digitalcollections.model.text.contentblock.Paragraph;
import de.digitalcollections.model.time.LocalDateRange;
import de.digitalcollections.model.time.TimeValue;
import de.digitalcollections.model.time.TimeValueRange;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Manifestation")
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
    Series series = Series.builder().label("Aus Natur und Geisteswelt").build();

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
                        .involvementRoles(Set.of("author"))
                        .involvementRolesPresentation(List.of("Autor"))
                        .agent(Person.builder().label(Locale.GERMAN, "Arnold Hiller").build())
                        .involvementPlace(
                            HumanSettlement.builder().label(Locale.GERMAN, "München").build())
                        .build()))
            .publishingTimeValueRange(
                new TimeValueRange(
                    new TimeValue(
                        2020,
                        0,
                        0,
                        0,
                        0,
                        0,
                        TimeValue.PREC_YEAR,
                        0,
                        0,
                        0,
                        TimeValue.CM_GREGORIAN_PRO),
                    new TimeValue(
                        2020,
                        0,
                        0,
                        0,
                        0,
                        0,
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
            .otherLanguages(new LinkedHashSet<>(List.of(Locale.ITALIAN)))
            .manufacturingType("PRINT")
            .expressionTypes(
                new LinkedHashSet<>(
                    List.of( // list ensures order
                        ExpressionType.builder().mainType("TEXT").subType("PRINT").build(),
                        ExpressionType.builder().mainType("TEXT").subType("HANDWRITING").build())))
            .publications(
                List.of(
                    buildPublication(List.of("Karl Ranseier"), List.of("Köln")),
                    buildPublication(List.of("Hans Dampf"), List.of("Frankfurt", "München")),
                    buildPublication(List.of("n.n.", "x,y"), List.of("München", "Berlin"))))
            .tag(
                Tag.builder()
                    .type("tag-type")
                    .namespace("tag-namespace")
                    .id("tag-id")
                    .label(new LocalizedText(Locale.GERMAN, "tag-label"))
                    .build())
            .subject(
                Subject.builder()
                    .type("type")
                    .identifier(Identifier.builder().namespace("namespace1").id("id1").build())
                    .identifier(Identifier.builder().namespace("namespace2").id("id2").build())
                    .label(new LocalizedText(Locale.GERMAN, "Subject A"))
                    .build())
            .subject(
                Subject.builder()
                    .type("type")
                    .identifier(Identifier.builder().namespace("namespace3").id("id3").build())
                    .label(new LocalizedText(Locale.GERMAN, "Subject B"))
                    .build())
            .mediaTypes(new LinkedHashSet<>(List.of("Buch", "CD")))
            .titles(
                List.of(
                    Title.builder()
                        .titleType(TitleType.builder().mainType("main").subType("main").build())
                        .text(
                            LocalizedText.builder()
                                .text(Locale.GERMAN, "Titel")
                                .text(
                                    new Locale.Builder()
                                        .setLanguage("zh")
                                        .setScript("hani")
                                        .build(),
                                    "圖註八十一難經辨眞")
                                .build())
                        .textLocaleOfOriginalScript(
                            new Locale.Builder().setLanguage("zh").setScript("hani").build())
                        .build(),
                    Title.builder()
                        .titleType(TitleType.builder().mainType("main").subType("sub").build())
                        .text(new LocalizedText(Locale.GERMAN, "Ein Test"))
                        .build()))
            .build();
    return manifestation;
  }

  private Publication buildPublication(List<String> personNames, List<String> cityNames) {
    return Publication.builder()
        .publishers(
            personNames.stream()
                .map(p -> Person.builder().label(p).title(Locale.GERMAN, p).build())
                .collect(Collectors.toList()))
        .publishersPresentation(personNames)
        .publicationLocations(
            cityNames.stream()
                .map(c -> HumanSettlement.builder().label(c).title(Locale.GERMAN, c).build())
                .collect(Collectors.toList()))
        .build();
  }

  @DisplayName("can be serialized and deserialized")
  @Test
  public void testSerializeDeserialize() throws Exception {
    Manifestation manifestation = createObject();
    checkSerializeDeserialize(
        manifestation, "serializedTestObjects/identifiable/entity/work/Manifestation.json");
  }
}
