package de.digitalcollections.model.jackson.identifiable.resource;

import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.identifiable.parts.RenderingHintsPreviewImageImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.net.URI;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class RenderingHintsImageTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    RenderingHintsPreviewImageImpl hints = new RenderingHintsPreviewImageImpl();
    hints.setAltText(new LocalizedTextImpl(Locale.ENGLISH, "image001.jpg"));
    hints.setCaption(
        new LocalizedTextImpl(Locale.ENGLISH, "Wonderful landscape in Lower Bavaria, Germany."));
    hints.setTitle(new LocalizedTextImpl(Locale.ENGLISH, "Photo of city of Straubing"));
    hints.setOpenLinkInNewWindow(true);
    hints.setTargetLink(
        URI.create("https://upload.wikimedia.org/wikipedia/commons/1/11/Straubinger_Stadtbild.jpg")
            .toURL());
    checkSerializeDeserialize(hints);
  }
}
