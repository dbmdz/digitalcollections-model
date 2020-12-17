package de.digitalcollections.model.jackson.view;

import de.digitalcollections.model.impl.view.RenderingHints;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class RenderingHintsTest extends BaseJsonSerializationTest {
  @Test
  public void testSerialisationInBothWays() throws Exception {
    RenderingHints hints = new RenderingHints();
    hints.setShowInPageNavigation(true);
    hints.setTemplateName("my-template");
    checkSerializeDeserialize(hints);
  }
}
