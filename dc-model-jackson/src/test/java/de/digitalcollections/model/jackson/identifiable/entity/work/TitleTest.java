package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.work.Title;
import de.digitalcollections.model.identifiable.entity.work.TitleType;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Title")
public class TitleTest extends BaseJsonSerializationTest {

  @DisplayName("can be serialized and deserialized")
  @Test
  public void testSerializeDeserialize() throws Exception {
    Title title =
        Title.builder()
            .titleType(TitleType.builder().mainType("main").subType("main").build())
            .text(
                LocalizedText.builder()
                    .text(Locale.GERMAN, "Titel")
                    .text(
                        new Locale.Builder().setLanguage("zh").setScript("hani").build(),
                        "圖註八十一難經辨眞")
                    .build())
            .textLocalesOfOriginalScript(
                new Locale.Builder().setLanguage("zh").setScript("hani").build())
            .build();

    checkSerializeDeserialize(title, "serializedTestObjects/identifiable/entity/work/Title.json");
  }
}
