package de.digitalcollections.model.jackson.identifiable.resource;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.view.RenderingHintsPreviewImage;
import java.net.URI;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class RenderingHintsImageTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    RenderingHintsPreviewImage hints = new RenderingHintsPreviewImage();
    hints.setAltText(new LocalizedText(Locale.ENGLISH, "image001.jpg"));
    hints.setCaption(
        new LocalizedText(Locale.ENGLISH, "Wonderful landscape in Lower Bavaria, Germany."));
    hints.setTitle(new LocalizedText(Locale.ENGLISH, "Photo of city of Straubing"));
    hints.setOpenLinkInNewWindow(true);
    hints.setTargetLink(
        URI.create("https://upload.wikimedia.org/wikipedia/commons/1/11/Straubinger_Stadtbild.jpg")
            .toURL());
    checkSerializeDeserialize(hints);
  }
}
