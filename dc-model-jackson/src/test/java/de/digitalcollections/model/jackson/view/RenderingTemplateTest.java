package de.digitalcollections.model.jackson.view;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.view.RenderingTemplate;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class RenderingTemplateTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    RenderingTemplate template = new RenderingTemplate();
    template.setDescription(new LocalizedText(Locale.ENGLISH, "Template description"));
    template.setLabel(new LocalizedText(Locale.ENGLISH, "Template label"));
    template.setName("Template name");
    template.setUuid(UUID.randomUUID());
    checkSerializeDeserialize(template);
  }
}
