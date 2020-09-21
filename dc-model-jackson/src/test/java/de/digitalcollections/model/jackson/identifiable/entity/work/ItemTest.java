package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.work.Item;
import de.digitalcollections.model.impl.identifiable.entity.work.ItemImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.identifiable.resource.ImageFileResourceImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class ItemTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Item item = new ItemImpl();
    item.setLabel(
        new LocalizedTextImpl(
            Locale.GERMAN,
            "Zimmer-Gymnastik ohne Geräte : 50 tägliche Übungen für die gesamte Körpermuskulatur, zur Erhaltung der Gesundheit und Förderung der Gewandtheit"));
    item.setLanguage(Locale.GERMAN);
    final ImageFileResourceImpl previewImage = new ImageFileResourceImpl();
    previewImage.setUuid(UUID.fromString("6bed2ff9-4ad5-4e18-b520-bb9843fe9a73"));
    item.setPreviewImage(previewImage);
    item.setPublicationDate("1912");
    item.setPublicationPlace("Leipzig");
    item.setPublisher("Thieme");
    item.setVersion("Zweite Auflage");
    checkSerializeDeserialize(item);
  }
}
