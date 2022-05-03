package de.digitalcollections.model.identifiable.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Entity")
class EntityTest {

  @DisplayName("can create an instance with the help of its inner class builder")
  @Test
  public void testBuilder() {
    Entity entity =
        Entity.builder()
            .randomUuid()
            .created("2021-01-13T12:34:54")
            .lastModified("2021-01-14T02:45:24")
            .identifier("foo", "bar")
            .description(Locale.GERMAN, "Beispiel-Bild")
            .description(Locale.ENGLISH, "Example Image")
            .label(Locale.GERMAN, "Beispielbild")
            .label(Locale.ENGLISH, "Example Image")
            .withPrimaryLocalizedUrlAlias("blubb")
            .build();
    assertThat(entity).isExactlyInstanceOf(Entity.class);
  }
}
