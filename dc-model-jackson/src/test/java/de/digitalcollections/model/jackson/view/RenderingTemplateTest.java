package de.digitalcollections.model.jackson.view;

import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.view.RenderingTemplate;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class RenderingTemplateTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    RenderingTemplate template = new RenderingTemplate();
    template.setDescription(new LocalizedTextImpl(Locale.ENGLISH, "Template description"));
    template.setLabel(new LocalizedTextImpl(Locale.ENGLISH, "Template label"));
    template.setName("Template name");
    template.setUuid(UUID.randomUUID());
    checkSerializeDeserialize(template);
  }
}
