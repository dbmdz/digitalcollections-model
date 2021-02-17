package de.digitalcollections.model.jackson.view;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.view.RenderingTemplate;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class RenderingTemplateTest extends BaseJsonSerializationTest {

  private RenderingTemplate createObject() {
    RenderingTemplate template = new RenderingTemplate();
    template.setDescription(new LocalizedText(Locale.ENGLISH, "Template description"));
    template.setLabel(new LocalizedText(Locale.ENGLISH, "Template label"));
    template.setName("Template name");
    template.setUuid(UUID.fromString("2552a82e-8d5c-4bfd-87df-e2f185476885"));
    return template;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    RenderingTemplate template = createObject();
    checkSerializeDeserialize(template, "serializedTestObjects/view/RenderingTemplate.json");
  }
}
